package com.ihappyk;

public class Anagram
{
    public static boolean isAnagram(String str, String str1) {
        char[] char1 = str.toCharArray();
        char[] char2 = str1.toCharArray();
        boolean result = false;

        if(char1.length != char2.length ) {
            return result;
        }
        int count =0;

        for(int i=0; i< char1.length ; i++) {
            count += char1[i];
            count -= char2[i];
        }

        if(count == 0) result = true;
        else
            result = false;
        return result;
    }

    public static void main(String args[]) {
        String str1 = "geeks";
        String str2 = "seekg";
        System.out.println("--->"+isAnagram(str1,str2));
    }
}
