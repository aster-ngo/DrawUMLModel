/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

public class Main {
       
	public static final int HEIGHT = 20;
	public static JFrame VFrame;
	public readFile rf=new readFile();
        public static Menu menu;
	
	public Main(){}
	
	public static void main(String[] args) {
		Main uml=new Main();
		int width = 1200;
		int height = 700;
		
		VFrame = new JFrame("Convert from Source code to Diagram class");
		
		VFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		VFrame.setSize(width, height);
		VFrame.setLayout(null);
	
		ArrayList<ClassView>classesView = new ArrayList<ClassView>();
		for(int i=0; i<uml.rf.arr.size(); i++) 
		{
                        
			LabelLine tempTittle = new LabelLine(10, 10, 0, HEIGHT ,uml.rf.arr.get(i).name);
			ArrayList<LabelLine>variables = new ArrayList<LabelLine>();
			ArrayList<LabelLine>methods = new ArrayList<LabelLine>();
                       
			if(uml.rf.arr.get(i).variables.size() != 0){
				for(int j=0; j<uml.rf.arr.get(i).variables.size(); j++) {
                                        
					LabelLine tempVal = new LabelLine(10, 10+(j+1)*HEIGHT, 0, HEIGHT, " -" + uml.rf.arr.get(i).variables.get(j));
					
                                        variables.add(tempVal);
				}
			}else{
				uml.rf.arr.get(i).variables.add("\t\t\t\t\t\t\t\t\t\t\t\t\t\t\t");
				for(int j=0; j<uml.rf.arr.get(i).variables.size(); j++) {
					LabelLine tempVal = new LabelLine(10, 10+(j+1)*HEIGHT, 0, HEIGHT, " " + uml.rf.arr.get(i).variables.get(j));
					variables.add(tempVal);
				}
			}
                        
			if(uml.rf.arr.get(i).methods.size() != 0){
				for(int j=0; j<uml.rf.arr.get(i).methods.size(); j++) {
					LabelLine tempMet = new LabelLine(10, 10+(j+uml.rf.arr.get(i).variables.size()+1)*HEIGHT, 0, HEIGHT, " +" + uml.rf.arr.get(i).methods.get(j));
					methods.add(tempMet);
				}
			}else{
				uml.rf.arr.get(i).methods.add(" ");
				for(int j=0; j<uml.rf.arr.get(i).methods.size(); j++) {
					LabelLine tempMet = new LabelLine(10, 10+(j+uml.rf.arr.get(i).variables.size()+1)*HEIGHT, 0, HEIGHT, " ");
					methods.add(tempMet);
				}
			}
			ClassView Classs = new ClassView(tempTittle, variables, methods);
			classesView.add(Classs);
                       
		}
		      
                
		VFrame.setSize(new Dimension(1500, 1000));
		VFrame.setLocation(105, 20);
                
		Drawing draw = new Drawing(classesView, VFrame.getWidth(), VFrame.getHeight());
		draw.setBackground(Color.WHITE);
	
		draw.setPreferredSize(new Dimension(VFrame.getWidth(), VFrame.getHeight()));
		
	  	JScrollPane srp = new JScrollPane(draw);
	  	srp.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
	  	srp.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_ALWAYS);
	  	srp.setBounds(10, 10, width-20, height-40);
                JPanel contentPane = new JPanel(null);
                contentPane.setPreferredSize(new Dimension(500, 400));
                contentPane.add(srp);
                
                VFrame.setContentPane(contentPane);
                VFrame.pack();
                VFrame.setSize(width, height);
                VFrame.setResizable(false);
                
                menu=new Menu();
	}
}