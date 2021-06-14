package com.ihappyk;

public class ArraySumRecursion
{
    public static int calculateSum(int a[],int n) {
        if(n<=0) return 0;
        else return calculateSum(a,n-1)+ a[n-1];
    }

    public static void main(String args[]) {
        System.out.println("array sum: " + calculateSum(new int[] {1,2,3,4,5},5));
    }
}