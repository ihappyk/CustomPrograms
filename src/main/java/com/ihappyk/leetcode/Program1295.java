package com.ihappyk.leetcode;

//Find Numbers with Even Number of Digits
public class Program1295
{
    public static void main(String args[]) {
        int[] nums = new int[]{555,901,482,1771};
        int count = findNumbers(nums);
        System.out.println("Count: "+count);
    }

    public static int findNumbers(int[] nums) {
        int evenNumCount = 0;
        for (int i= 0;i< nums.length; i++) {
            int num = nums[i];
            int numCount = 0;
            while (num !=0) {
                int rem = num % 10;
                numCount++;
                num = num / 10;
            }
            if(numCount % 2 ==0) evenNumCount++;
        }
        return evenNumCount;
    }
}
