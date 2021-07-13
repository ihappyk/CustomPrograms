package com.ihappyk.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/*LeetCode Program: 1790*/
public class CheckifOneStringSwapCanMakeStringsEqual
{
    public static boolean areAlmostEqual(String s1, String s2) {
        /*Check for length of the String*/
        if(s1.length() != s2.length()) return false;

        /*Check if the string already same*/
        if(s1.equals(s2)) return true;

        char[] chars1 = s1.toCharArray();
        char[] chars2 = s2.toCharArray();
        int len = s1.length();
        List<Integer> indicesList = new ArrayList<>();

        /*find the indices which are not matching*/
        for(int i=0;i<len;i++) {
            if(chars1[i] != chars2[i]){
                indicesList.add(i);
            }
        }
        if(indicesList.size() != 2) return false;

        /*SWAP the indices*/
        char ch = chars1[indicesList.get(0)];
        chars1[indicesList.get(0)] = chars1[indicesList.get(1)];
        chars1[indicesList.get(1)] = ch;

        return Arrays.equals(chars1,chars2);
    }

    public static void main (String[] args)
    {
        String str1 = "aa";
        String str2 = "ac";
        boolean result = areAlmostEqual(str1,str2);
        System.out.println("Result:"+result);
    }
}
