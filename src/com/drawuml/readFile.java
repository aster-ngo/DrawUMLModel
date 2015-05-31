package com.drawuml;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class readFile {
	
	public  SaveData sd, father;
	public  ArrayList<String> tt, pt, title, noRelationship;
	public  ArrayList<SaveData> arr, arr1;
	
	
	public readFile()
	{
		title = new ArrayList<String>();
		noRelationship = new ArrayList<String>();
		tt = new ArrayList<String>();// ArrayList variables
		pt = new ArrayList<String>();// ArrayList methods
		arr = new ArrayList<SaveData>();// ArrayList  class
		arr1 = new ArrayList<SaveData>();// ArrayList lop cha + lop main
		readFolder();
		processVariables();
		saveArr1();
	}
	

	public  int searchString(String s1, String s2){
        String temp = "";
        for( int i=0; i< s2.length(); i++ ){
            if( i+s1.length() > s2.length() ) break;
            temp = s2.substring(i,i+s1.length());
            if( temp.equals(s1) == true ){
                return i;
            }
        }
        return -1;
    }
	
	public String DanXuat(File file)
	{
		String result = "";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line, kq = "", kq1 = "", a = "", b = "";
			while( (line = br.readLine()) != null)
			{
				
				
				int index = line.indexOf("extends");
				
				if(index != -1){
					for(int i=index-2; i>= 0; i--){
						if(line.charAt(i) == 32) break;
						else a += line.charAt(i) + "";
					}
					for(int i=a.length()-1; i>=0; i--)
						kq += a.charAt(i) + "";
					for(int i=index+8; i<line.length(); i++){
						b += line.charAt(i) + "";
						// 32 = " "; 123 = "{"
						if(line.charAt(i+1) == 32 || line.charAt(i+1) == 123)
							break;
					}
					result += kq;
					title.add(b);
					break;
					
				}
				// lá»›p khÃ´ng extends
				else{
					
					int index1 = line.indexOf("class");
					if(index1 != -1){
						for(int i=index1+6; i<line.length(); i++){
							if(line.charAt(i) == 32) break;
							else kq1 += line.charAt(i) + "";
						}
						result += kq1;
						father.name = kq1;
					}
				}
			}
			br.close();
			fr.close();
		}catch(IOException e){	
		
		}
		return result;
	}
	
	public void ThuocTinh(File file)
	{
		
		String a = "public";
		String b = "protected";
		String c = "private";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while( (line = br.readLine()) != null)
			{
				// Loáº¡i bá»� khoáº£ng tráº¯ng á»Ÿ 2 Ä‘áº§u dÃ²ng
				line = line.trim();
				// TÃ¬m vá»‹ trÃ­ cá»§a kÃ½ tá»± ";"
				int index = line.indexOf(";");
				int index1 = line.indexOf("(");
				/*Kiá»ƒm tra dÃ²ng cÃ³ báº¯t Ä‘áº§u báº±ng tá»« pubic/protected/private ?
				 * VÃ  dÃ²ng cÃ³ kÃ½ tá»± ";" ?
				 * Náº¿u cÃ³ thÃ¬ dÃ²ng Ä‘Ã³ lÃ  thuá»™c tÃ­nh
				 * */
				if( (searchString(a, line) != -1 || searchString(b, line) != -1 || searchString(c, line) != -1) && searchString("//", line) == -1 && index != -1 && index1 == -1) 
				{
					String str = "", str1 = "";
					String result = "", kq = "";
					int count = 0;
					int x = line.indexOf("=");
					// Trong dÃ²ng cÃ³ kÃ½ tá»± "=", trÆ°á»�ng há»£p khai bÃ¡o giÃ¡ trá»‹ cho thuá»™c tÃ­nh
					if(x != -1){						
						for(int i=x-2; i>=0; i--){
							if(line.charAt(i) == 32) count++;
							if(count == 2) break;
							else str += line.charAt(i) + "";
						}						
					}
					if(str != null){
						int y = str.indexOf(" ");
						for(int i=y; i>=0; i--){
							result += str.charAt(i) + "";
							if(i == 0) result += " : ";
						}
						for(int i=str.length()-1; i>y; i--)
							result += str.charAt(i) + "";
						tt.add(result);
					}
					// TrÆ°á»�ng há»£p thuá»™c tÃ­nh khÃ´ng khai bÃ¡o giÃ¡ trá»‹ ban Ä‘áº§u
					if(x == -1){
						for(int i=index-1; i>=0; i--){
							if(line.charAt(i) == 32) count++;
							if(count == 2) break;
							else str1 += line.charAt(i) + "";
						}
					}
					if(str1 != null){
						int y = str1.indexOf(" ");
						for(int i=y; i>=0; i--){
							kq += str1.charAt(i) + "";
							if(i == 0) kq += " : ";
						}
						for(int i=str1.length()-1; i>y; i--)
							kq += str1.charAt(i) + "";
						tt.add(kq);
					}
				}
			}
			br.close();
			fr.close();	
		}catch(IOException e){
		}
	}
	
	public void PhuongThuc(File file)
	{
		String a = "public";
		String b = "protected";
		String c = "private";
		try {
			FileReader fr = new FileReader(file);
			BufferedReader br = new BufferedReader(fr);
			String line;
			while( (line = br.readLine()) != null)
			{
				String str = "", result = "";
				int count = 0, dem = 0;
				
				// Loáº¡i bá»� khoáº£ng tráº¯ng 2 Ä‘áº§u cá»§a dÃ²ng
				line = line.trim();
				
				// tÃ¬m vá»‹ trÃ­ cá»§a kÃ½ tá»± "(" vá»›i kÃ½ tá»± ")" trong dÃ²ng
				int index1 = line.indexOf("(");
				int index2 = line.indexOf(")");
				
				/* DÃ²ng nÃ o báº¯t Ä‘áº§u báº±ng tá»« public/protected/private, 
				 * khÃ´ng chá»©  kÃ½ tá»± "args" vÃ  trong dÃ²ng pháº£i cÃ³ dáº¥u () 
				 * -> dÃ²ng Ä‘Ã³ lÃ  tÃªn phÆ°Æ¡ng thá»©c*/
				if( (searchString(a, line) != -1 || searchString(b, line) != -1 || searchString(c, line) != -1) && searchString("//", line) == -1 /*&& searchString("args", line) == -1 */&& index1 != -1 && index2 != -1 ){
					// Ä�áº¿m sá»‘ khoáº£ng tráº¯ng giá»¯a 2 dáº¥u () Ä‘á»ƒ xÃ©t trÆ°á»�ng há»£p phÆ°Æ¡ng thá»©c cÃ³ Ä‘á»‘i sá»‘
					for(int i=index1 ; i<= index2; i++)
						if(line.charAt(i) == 32) dem++;
					// Láº¥y tÃªn phÆ°Æ¡ng thá»©c vÃ  kiá»ƒu tráº£ vá»� cá»§a nÃ³
					for(int i=index2; i>=0; i--){
						if(line.charAt(i) == 32) count++;
						if( (count - dem) == 2) break;
						else str += line.charAt(i) + "";					
					}
					if(str != null){
						int y = 0;
						for(int i= 0; i<str.length(); i++){
							if(str.charAt(i) == 32){
								y = i;
							}
						}
						for(int i=y; i>=0; i--){
							result += str.charAt(i) + "";
							if(i == 0) result += " : ";
						}
						for(int i=str.length()-1; i>y; i--)
							result += str.charAt(i) + "";
						pt.add(result);
					}
				}
			}
			br.close();
			fr.close();	
		}catch(IOException e){
		}
	}

	public void read(File file)
	{
		father = new SaveData();
		sd = new SaveData();
		String result = DanXuat(file);
		sd.name = result;
		ThuocTinh(file);
		for(int i=0; i<tt.size(); i++)
			sd.variables.add(tt.get(i));
		PhuongThuc(file);
		for(int i=0; i<pt.size(); i++)
			sd.methods.add(pt.get(i));
		if(father.name != ""){
			for(int i=0; i<tt.size(); i++)
				father.variables.add(tt.get(i));
			for(int i=0; i<pt.size(); i++)
				father.methods.add(pt.get(i));
		}
		if(father.name != "")
			arr1.add(father);
		tt.clear();
		pt.clear();
	}
	
	public void readFolder()
	{
		File file = new File("src/data/data1");
		/* DÃ¹ng 1 máº£ng danh sÃ¡ch Ä‘á»ƒ lÆ°u 1 danh sÃ¡ch file
		 * rá»“i Ä‘á»�c tá»«ng file 1
		 */
		Queue<File> files = new LinkedList<File>();
		files.add(file);
		while (!files.isEmpty()) {
		  file = files.poll(); // láº¥y vÃ  remove file khá»�i danh sÃ¡ch
		  if (file.exists()) {
		    if (file.isFile()){
		    	read(file);
		    	arr.add(sd);
		    }else
		    	for (File child : file.listFiles()) // náº¿u file lÃ  thÆ° má»¥c thÃ¬ add háº¿t file trong thÆ° má»¥c vÃ o danh sÃ¡ch file
		    		files.add(child);
		  }
		}
	}
	
	// XÆ°Ì‰ lyÌ� caÌ�c phÃ¢Ì€n tÆ°Ì‰ trong danh saÌ�ch arr cuÌ‰a maÌ‰ng variable do maÌ‰ng variable coÌ� (phÃ¢Ì€n tÆ°Ì‰)thÆ°Ì€a khoaÌ‰ng trÄƒÌ�ng
	public void processVariables()
	{
		for(int i=0; i<arr.size(); i++){
			for(int j=0; j<arr.get(i).variables.size(); j++){
				String a = "";
				a += arr.get(i).variables.get(j);
				int index = a.indexOf(":");
				if(index == -1) arr.get(i).variables.remove(j);
			}
		}
		
		for(int i=0; i<arr1.size(); i++){
			for(int j=0; j<arr1.get(i).variables.size(); j++){
				String a = "";
				a += arr1.get(i).variables.get(j);
				int index = a.indexOf(":");
				if(index == -1) arr1.get(i).variables.remove(j);
			}
		}
	}
	
	// LÆ°u phÃ¢Ì€n tÆ°Ì‰ cha vaÌ€o maÌ‰ng arr1
	public void saveArr1()
	{	
		SaveData ss = new SaveData();
		int x = -1;
		int y = -1;
		//TiÌ€m viÌ£ triÌ� tÃªn lÆ¡Ì�p cha trong danh saÌ�ch arr1 && arr
		
		// x : viÌ£ triÌ� tÃªn lÆ¡Ì�p cha trong danh saÌ�ch arr1
		for(int i=0; i<title.size(); i++){
			String a = title.get(i);
			for(int j=0; j<arr1.size(); j++){
				String b = arr1.get(j).name;
				if(a.equals(b) == true)
					x = j;	
			}
			// TrÆ°Æ¡Ì€ng hÆ¡Ì£p noÌ� voÌ� kÃªÌ� thÆ°Ì€a caÌ�c phÆ°Æ¡ng thÆ°Ì�c coÌ� sÄƒÌƒn trong java: Exception, JPanel .....
			// y : viÌ£ triÌ� tÃªn lÆ¡Ì�p cha trong danh saÌ�ch arr
			if(x == -1){
				for(int j=0; j<arr.size(); j++){
					String c = arr.get(j).name;
					if(c.equals(a) == true){
						y = j;
					}
				}
			}
		}
		
		// NÃªÌ�u tÃªn lÆ¡Ì�p cha trong danh saÌ�ch arr1
		if(x != -1 && y == -1){
			for(int i=0; i<arr1.size(); i++){
				// LÆ°u lÆ¡Ì�p cha vaÌ€o danh saÌ�ch class ss kiÃªÌ‰u SaveData
				if(i == x)
				{
					ss.name = arr1.get(x).name;
					for(int j=0; j<arr1.get(x).methods.size(); j++)
						ss.methods.add(arr1.get(x).methods.get(j));
					for(int j=0; j<arr1.get(x).variables.size(); j++)
						ss.variables.add(arr1.get(x).variables.get(j));
				}
				// LÆ°u caÌ�c tÃªn lÆ¡Ì�p khÃ´ng coÌ� dÃ¢Ìƒn xuÃ¢Ì�t cuÌƒng nhÆ° lÆ¡Ì�p cÆ¡ sÆ¡Ì‰
				else
					noRelationship.add(arr1.get(i).name);
			}
		}
		// NÃªÌ�u tÃªn lÆ¡Ì�p cha trong danh saÌ�ch arr
		else if(x == -1 && y != -1){
			for(int i=0; i<arr.size(); i++){
				// LÆ°u lÆ¡Ì�p cha vaÌ€o danh saÌ�ch class ss kiÃªÌ‰u SaveData
				if(i == y)
				{
					ss.name = arr.get(y).name;
					for(int j=0; j<arr.get(y).methods.size(); j++)
						ss.methods.add(arr.get(y).methods.get(j));
					for(int j=0; j<arr.get(y).variables.size(); j++)
						ss.variables.add(arr.get(y).variables.get(j));
				}else{
					// Copy caÌ�c lÆ¡Ì�p maÌ€ khÃ´ng coÌ� lÆ¡Ì�p dÃ¢Ìƒn xuÃ¢Ì�t vaÌ€o danh saÌ�ch noRelationship
					for(int j=0; j<arr1.size(); j++)
						noRelationship.add(arr1.get(j).name);
				}
			}
		}
		// XoÌ�a danh saÌ�ch arr1
		arr1.clear();
		// Danh saÌ�ch arr1 chiÌ‰ coÌ� phÃ¢Ì€n tÆ°Ì‰ laÌ€ lÆ¡Ì�p cha
		arr1.add(ss);
	}

}