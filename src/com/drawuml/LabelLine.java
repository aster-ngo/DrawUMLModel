/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;
import java.awt.Color;
import javax.swing.JLabel;
//Táº¡o ra 1 label cÃ³ cÃ¡c thuá»™c tÃ­nh Ä‘iá»ƒm(Point) vÃ  Ä‘á»� dÃ i vÃ  Ä‘á»™ rá»™ng(Dimension)
public class LabelLine {
	public Point point;
	public Dimension dimension;
	public String value;
	JLabel label;
	LabelLine(int x, int y, int width, int height, String value) {
		label = new JLabel(value);
		label.setBorder(null);
		label.setOpaque(true);
		label.setBackground(Color.white);
		label.setForeground(Color.BLACK);
		label.setFont(new java.awt.Font("Segoe Print", 1, 15));
		this.value = value;
		point = new Point(x, y);
		dimension = new Dimension(width, height);
	}
}

