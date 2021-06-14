package com.java.leetcode;

/**
 * Jewels and Stones
 */
public class Program771
{
    public static void main(String args[])
    {
        System.out.println("Start Interview Coding");
        String J = "aA", S = "aAAbbbb";
        System.out.println("Answer :" + numJewelsInStones(J,S));
    }

    public static int numJewelsInStones(String J, String S) {
        char[] jewArr = J.toCharArray();
        char[] gotArr = S.toCharArray();
        int count = 0;
        for(int i=0; i<J.length(); i++) {
            for(int j=0; j<S.length();j++) {
                if(jewArr[i] == gotArr[j]){
                    count++;
                }
            }
        }
        return count;
    }
}
