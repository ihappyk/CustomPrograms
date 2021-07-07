package com.ihappyk.leetcode;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;

public class CreateTargetArrayintheGivenOrder
{
    public static int[] createTargetArray(int[] nums, int[] index) {
        List<Integer> resultArr = new ArrayList<>(nums.length);
        for (int i=0; i < nums.length; i++) {
            resultArr.add(index[i],nums[i]);
        }
        return resultArr.stream().mapToInt(i->i).toArray();
    }

    public static void main (String[] args)
    {
        int[] nums = new int[]{0,1,2,3,4};
        int[] index = new int[] {0,1,2,2,1};
        int[] output = createTargetArray(nums,index);
        Arrays.stream(output).forEach(System.out::println);
    }
}
