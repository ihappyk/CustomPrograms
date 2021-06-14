package com.ihappyk.hackerrank;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class ElectronicsShop
{
    static int getMoneySpent(int[] keyboards, int[] drives, int b) {
        /*
         * Write your code here.
         */
        int max = -1;
        Arrays.sort(drives);//Ascending order
        Arrays.sort(keyboards);
        int i = keyboards.length-1;
        while(i >= 0) {
            int j = 0;
            while ( j < drives.length) {
                int s = keyboards[i] + drives[j];
                j=j+1;
                if (s > b) break;
                if (s > max) max = s;
            }
            i=i-1;
        }
        return max;
    }

    public static void main(String args[])
    {
        int res = getMoneySpent(new int[]{3,1},new int[]{5,2,8},10);
        System.out.println("Res:{}"+res);
    }
}

