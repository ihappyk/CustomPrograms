package com.ihappyk.geeksforgeeks;

import java.util.Scanner;

public class TheMuskteers {

	public static boolean theMuskteers(String s){
		boolean flag = true;
		//char[] chArr = s.toCharArray();
		if(s.indexOf('0')<0){
			flag = false;
		}else{
			for(int i=s.indexOf('0');i<s.length();i++){
				if(s.charAt(i)!='0' ){
					if( s.substring(i, s.length()).indexOf('0')<0){
						flag = true;
					}else{
						flag = false;
					}

					break;
				}
			}
		}
		return flag;
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner in = new Scanner(System.in);
		int t = in.nextInt();
		while(t>0){
			String inp = in.next();
			System.out.println(theMuskteers(inp));
			t--;
		}
		//
	}

}
