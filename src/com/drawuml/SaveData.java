/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.drawuml;


import java.util.ArrayList;

public class SaveData {
	
	public String name;
	public ArrayList<String> methods;
	public ArrayList<String> variables;

	public SaveData()
	{
		name = "";
		methods = new ArrayList<String>();
		variables = new ArrayList<String>();
	}

}

