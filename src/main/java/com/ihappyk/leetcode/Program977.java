package com.ihappyk.leetcode;

//977. Squares of a Sorted Array

import java.util.Arrays;
import java.util.stream.Collectors;

public class Program977
{
    public static void main(String args[]) {
        int[] a = new int[]{5,1,2,3,4};
        new Program977().SquaresOfSortedArray(a);
        System.out.println();
    }

    public void SquaresOfSortedArray(int[] nums) {
        int[] squaredArray = new int[nums.length];
        Arrays.stream(nums).sorted()
            .map(i -> i*i).
            forEach(System.out::print);
    }
}
