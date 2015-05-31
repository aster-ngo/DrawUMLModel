/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

public class Drawing extends JPanel implements MouseListener, MouseMotionListener {
	//private static final long serialVersionUID = 1L;
	public ArrayList<ClassView>classes;
	public Point point;
	public Dimension dimension;
    public Main tool=new Main();
	public boolean start;
	public Point begin;
	public Point end;
	public int indexOfClass;
	public int  fatherIndex, mainIndex = -2;
	public int a, b;
       
	public Drawing(ArrayList<ClassView>classes, int width, int height) {
		this.classes = classes;
		addMouseListener(this);
		addMouseMotionListener(this);
		dimension = new Dimension(width, height);
		point = new Point(0, 0);
		start = false;
		indexOfClass = -1;
		for(int i=0; i<classes.size(); i++) {
			this.add(classes.get(i).title.label);
			point = classes.get(i).title.point;
			for(int j=0; j<classes.get(i).variables.size(); j++) this.add(classes.get(i).variables.get(j).label);
			for(int j=0; j<classes.get(i).methods.size(); j++) this.add(classes.get(i).methods.get(j).label);
		}
	}
	
	
	public void compare()
	{
		String a = tool.rf.arr1.get(0).name;
		String c = "main";
		for(int i=0; i<classes.size(); i++){
			String name = classes.get(i).title.value;
			if(name.equals(a) == true){
				fatherIndex = i;
			}else{
				// Bat vi tri main tuc la phuong thuc test
				for(int j=0; j<classes.get(i).methods.size(); j++){
					String name1 = classes.get(i).methods.get(j).value;
					if(tool.rf.searchString(c, name1) != -1)
						mainIndex = i;
					else if(tool.rf.searchString(c, name1) == -1 && mainIndex == -2)
						mainIndex = -1;
				}
			}
		}
	}
	

	public int getIndex(String ht, ArrayList<ClassView>classes, ArrayList<String> a)
	{
		for(int i=0; i<classes.size(); i++){
			String name = classes.get(i).title.value;
			if(name.equals(ht) == true){
				for(int j=0; j<a.size(); j++)
					if(name.equals(a.get(j)) == true)
						return i;
			}
		}
		return -1;
	}
	
	public void paint(Graphics g) {
		super.paint(g);
                
		for(int i=0; i<classes.size(); i++){
				g.setColor(Color.black);
                                
				g.drawRect(classes.get(i).point.x, classes.get(i).point.y ,
                                           classes.get(i).dimension.width, classes.get(i).dimension.height);
                                
				g.drawRect(classes.get(i).title.point.x, classes.get(i).title.point.y ,
                                           classes.get(i).title.dimension.width, classes.get(i).title.dimension.height);
                                
				classes.get(i).title.label.setBounds(classes.get(i).title.point.x, classes.get(i).title.point.y , 
                                                                     classes.get(i).title.dimension.width, classes.get(i).title.dimension.height);
                                
				g.drawRect(classes.get(i).variables.get(0).point.x,classes.get(i).variables.get(0).point.y,
						classes.get(i).variables.get(0).dimension.width,
						classes.get(i).variables.get(0).dimension.height*classes.get(i).variables.size());
				
				for(int j=0; j<classes.get(i).variables.size(); j++) {
					classes.get(i).variables.get(j).label.setBounds(classes.get(i).variables.get(j).point.x, classes.get(i).variables.get(j).point.y ,
                                                                                        classes.get(i).variables.get(j).dimension.width, classes.get(i).variables.get(j).dimension.height);
				}
                              
				for(int j=0; j<classes.get(i).methods.size(); j++) {
					classes.get(i).methods.get(j).label.setBounds(classes.get(i).methods.get(j).point.x, classes.get(i).methods.get(j).point.y ,
                                                                                      classes.get(i).methods.get(j).dimension.width, classes.get(i).methods.get(j).dimension.height);
				}	
		}
                Graphics2D g2d=(Graphics2D)g;
                
                compare();
                
                for(int i=0; i<classes.size(); i++){  
                	String name = classes.get(i).title.value;
                	int k = getIndex(name, classes, tool.rf.noRelationship);
                    
	                if(i != fatherIndex && i != mainIndex && i != k){
	                	if(classes.get(i).point.y >= classes.get(fatherIndex).point.y+12+classes.get(fatherIndex).dimension.height
                                        &&(classes.get(i).point.x >= classes.get(fatherIndex).point.x||
                                        classes.get(i).point.x < classes.get(fatherIndex).point.x)){
                            
						g2d.drawLine(classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y,
                                                             classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y-18);
                                                
						g2d.drawLine(classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y-18,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2, 
                                                             classes.get(i).title.point.y-18);
                                                
						g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(i).title.point.y-18,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height+12);
                                                
						g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2-5,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height+12 ,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2+5 ,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height+12);
                                                
						g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2-5,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height+12,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2 ,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height);
                                                
						g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2+5,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height+12,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(fatherIndex).title.point.y+classes.get(fatherIndex).dimension.height);
				
                    
                    }
                   
                        if(classes.get(i).point.y <= classes.get(fatherIndex).point.y
                                        &&(classes.get(i).point.x >= classes.get(fatherIndex).point.x||
                                            classes.get(i).point.x < classes.get(fatherIndex).point.x)){
                                               
                                               g2d.drawLine(classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y,
                                                             classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y-18);
                                               
                                              g2d.drawLine(classes.get(i).title.point.x+classes.get(i).dimension.width/2,
                                                             classes.get(i).title.point.y-18,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2, 
                                                             classes.get(i).title.point.y-18);
                                               
                                              g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(i).title.point.y-18,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(fatherIndex).title.point.y-12);
                                              
                                              g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2-5,
                                                             classes.get(fatherIndex).title.point.y-12 ,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2+5 ,
                                                             classes.get(fatherIndex).title.point.y-12);
                                               
                                              g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2-5,
                                                             classes.get(fatherIndex).title.point.y-12,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2 ,
                                                             classes.get(fatherIndex).title.point.y);
                                              
                                              g2d.drawLine(classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2+5,
                                                             classes.get(fatherIndex).title.point.y-12,
                                                             classes.get(fatherIndex).title.point.x+classes.get(fatherIndex).title.dimension.width/2,
                                                             classes.get(fatherIndex).title.point.y);
                        }
                       
                        if(classes.get(i).point.y > classes.get(fatherIndex).point.y
                                        &&classes.get(i).point.y < classes.get(fatherIndex).point.y+12+classes.get(fatherIndex).dimension.height
                                        &&classes.get(i).point.x+classes.get(i).dimension.height<= classes.get(fatherIndex).point.x-12)
                                            {
                                             g2d.drawLine(classes.get(i).point.x+classes.get(i).dimension.width,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2,
                                                          classes.get(i).point.x+classes.get(i).dimension.width+18,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2);
                                             
                                             g2d.drawLine(classes.get(i).point.x+classes.get(i).dimension.width+18,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2,
                                                          classes.get(i).point.x+classes.get(i).dimension.width+18,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                             
                                             g2d.drawLine(classes.get(i).point.x+classes.get(i).dimension.width+18,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2,
                                                          classes.get(fatherIndex).point.x-12,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                             
                                             g2d.drawLine(classes.get(fatherIndex).point.x-12,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2-5,
                                                          classes.get(fatherIndex).point.x-12,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2+5);
                                             
                                             g2d.drawLine(classes.get(fatherIndex).point.x-12,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2-5,
                                                          classes.get(fatherIndex).point.x,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                             
                                             g2d.drawLine(classes.get(fatherIndex).point.x-12,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2+5,
                                                          classes.get(fatherIndex).point.x,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                            
                        }
                      
                        if(classes.get(i).point.y > classes.get(fatherIndex).point.y
                                        &&classes.get(i).point.y < classes.get(fatherIndex).point.y+12+classes.get(fatherIndex).dimension.height
                                        &&classes.get(i).point.x+classes.get(i).dimension.height>= classes.get(fatherIndex).point.x-12){
                                            g2d.drawLine(classes.get(i).point.x,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2,
                                                          classes.get(i).point.x-18,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2);
                                            
                                            g2d.drawLine(classes.get(i).point.x-18,
                                                          classes.get(i).point.y+classes.get(i).dimension.height/2,
                                                          classes.get(i).point.x-18,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                            
                                            g2d.drawLine(classes.get(i).point.x-18,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2,
                                                          classes.get(fatherIndex).point.x+12+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                            
                                            g2d.drawLine(classes.get(fatherIndex).point.x+12+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2-5,
                                                          classes.get(fatherIndex).point.x+12+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2+5);
                                            
                                            g2d.drawLine(classes.get(fatherIndex).point.x+12+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2-5,
                                                          classes.get(fatherIndex).point.x+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                            
                                            g2d.drawLine(classes.get(fatherIndex).point.x+12+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2+5,
                                                          classes.get(fatherIndex).point.x+classes.get(fatherIndex).dimension.width,
                                                          classes.get(fatherIndex).point.y+classes.get(fatherIndex).dimension.height/2);
                                            
                    
                	}
                }
            }
        }
    
	public boolean pressInOtherClass(int x, int y, int exeption) {
		if(classes.get(exeption).inLabelLine(x, y)) return false;
		for(int i=0; i<classes.size(); i++)
			if(classes.get(i).inLabelLine(x, y) && i != exeption)
				return true;
		return false;
	}
	@Override
	public void mouseClicked(MouseEvent e) {}
	@Override
	public void mousePressed(MouseEvent e) {
		for(int i=classes.size()-1; i>=0; i--) {
			if(classes.get(i).inLabelLine(e.getX(), e.getY())) {
				
				if(!pressInOtherClass(e.getX(), e.getY(), i)){
					indexOfClass = i;
					start = true;
					begin = new Point(e.getX(), e.getY());
				}
			}
		}
	}
	@Override
	public void mouseReleased(MouseEvent e) {
		if(start) start = false;
	}
	@Override
	public void mouseEntered(MouseEvent e) {}
	@Override
	public void mouseExited(MouseEvent e) {}
	@Override 
	public void mouseDragged(MouseEvent e) {
		if(start) {
			end = new Point(e.getX(), e.getY());
			classes.get(indexOfClass).changedPoint(end.x - begin.x, end.y - begin.y);
			begin = end;
			repaint();
		}
	}
	public void mouseMoved(MouseEvent e) {}

}

