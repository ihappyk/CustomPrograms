package com.ihappyk.leetcode;

/**
 * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * You can return the answer in any order.
 *
 * Example:
 * Input: nums = [2,7,11,15], target = 9
 * Output: [0,1]
 * Output: Because nums[0] + nums[1] == 9, we return [0, 1].
 */
public class TwoSumProgram
{
    public int[] twoSum(int[] nums, int target)
    {
        int[] res = new int[2];
        int i = 0,j = 0,n = nums.length;
        boolean flag = false;
        while(i < n){
            j = i+1;
            while(j < n){
                if (nums[i]+nums[j] == target) {
                    res[0] = i;
                    res[1] = j;
                    flag = true;
                    break;
                }
                j=j+1;
            }
            if(flag) break;
            i=i+1;
        }
        return res;
    }

    public static void main(String args[]) {
        int[] n = new int[] {2,7,11,15};
        TwoSumProgram twoSumProgram = new TwoSumProgram();
        int[] res = twoSumProgram.twoSum(n,9);
    }
}
