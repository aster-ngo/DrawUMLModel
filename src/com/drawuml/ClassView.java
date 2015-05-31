/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;

import java.util.ArrayList;

import javax.swing.SwingConstants;

public class ClassView {
	public LabelLine title;
	public ArrayList<LabelLine>variables;
	public ArrayList<LabelLine>methods;
	public Point point;
	public Dimension dimension;
   
	public void changedPoint(int x, int y) {
		title.point.x += x;
		title.point.y += y;
		for(int i=0; i<variables.size(); i++) {
			variables.get(i).point.x += x;
			variables.get(i).point.y += y;
		}
		for(int i=0; i<methods.size(); i++) {
			methods.get(i).point.x += x;
			methods.get(i).point.y += y;
		}
	}
        
	public boolean inLabelLine(int x, int y) {
		if(x >= point.x && x <= point.x+dimension.width && y >= point.y && y <= point.y+dimension.height)
			return true;
		return false;
	}
        
	public ClassView(LabelLine title, ArrayList<LabelLine>variables, ArrayList<LabelLine>methods) {
		this.title = title;
		this.title.label.setHorizontalAlignment(SwingConstants.CENTER);
		this.variables = variables;
		this.methods = methods;
		this.point = title.point;
		int max = 0;
		for(int i=0; i<variables.size(); i++) 
			if(variables.get(i).value.length() > max) 
				max = variables.get(i).value.length();
		for(int i=0; i<methods.size(); i++) 
			if(methods.get(i).value.length() > max) 
				max = methods.get(i).value.length();
		for(int i=0; i<variables. size(); i++) {
			variables.get(i).dimension.width = max*9;
			variables.get(i).label.setBounds(variables.get(i).point.x, variables.get(i).point.y,
                                                         variables.get(i).dimension.width, variables.get(i).dimension.height);
		}
		for(int i=0; i<methods.size(); i++) {
			methods.get(i).dimension.width = max*9;
			methods.get(i).label.setBounds(methods.get(i).point.x, methods.get(i).point.y,
                                                       methods.get(i).dimension.width, methods.get(i).dimension.height);
		}
		this.dimension = new Dimension(title.dimension.width, title.dimension.height);
		this.dimension.width = max*9;
		this.dimension.height = (variables.size()+methods.size()+1)*20;
		title.dimension.width = max*9;
		title.label.setBounds(title.point.x, title.point.y, title.dimension.width, title.dimension.height);
	
	}
	
}

