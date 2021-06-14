package com.ihappyk.geeksforgeeks;

import java.util.LinkedHashMap;
import java.util.Map;

public class FirstRepeatedChar {

	 public static char firstRepeatedChar(String inputStr){
	        char[] chArr = inputStr.toCharArray();
	        char ch = 0;
	        Map<Character,Integer> charFrequencySet = new LinkedHashMap<Character,Integer>();
	        for(char c : chArr){
	            if(charFrequencySet.containsKey(c)){
	                charFrequencySet.put(c,charFrequencySet.get(c)+1);
	            }else{
	                charFrequencySet.put(c,1);
	            }
	            if(charFrequencySet.get(c) > 1){
	            	ch = c;
	            	break;
	            }
	            
	        }
	        return ch;
	        
	    }
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			System.out.println(firstRepeatedChar("geeksforgeeks"));
	}

}
