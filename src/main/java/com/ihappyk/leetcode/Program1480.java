package com.ihappyk.leetcode;
//1480. Running Sum of 1d Array

import java.util.Arrays;

public class Program1480
{
    public static void main(String args[]) {
        int[] intArr = new int[]{1,2,3,4};
        int[] sumOfArry = runningSum(intArr);
        Arrays.stream(sumOfArry).
            forEach(System.out::print);
    }

    public static int[] runningSum(int[] nums) {
        int[] resultArry = new int[nums.length];
        for (int i=0;i <nums.length; i++) {
            int sum = nums[i];
            for(int j=0; j<i;j++){
                sum += nums[j];
            }
            resultArry[i] = sum;
        }
        return resultArry;
    }
}
