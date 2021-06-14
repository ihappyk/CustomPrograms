package com.ihappyk.leetcode;

public class Program709
{
    public static String toUpperCase(String str)
    {
        char charArr[] = str.toCharArray();
        for(int i=0;i<str.length(); i++) {
            if((int)charArr[i] >= 65 && (int)charArr[i] <= 90 ){
                charArr[i] = (char)(((int)charArr[i])+32);
            }
        }
        return String.valueOf(charArr);
    }

    public static void main(String[] args)
    {
        String str = "HELLO";
        System.out.println(toUpperCase(str));
    }
}
