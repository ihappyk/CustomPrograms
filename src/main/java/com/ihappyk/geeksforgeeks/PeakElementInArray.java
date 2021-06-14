package com.ihappyk.geeksforgeeks;

import java.util.Arrays;
import java.util.Collections;
import java.util.stream.Stream;

public class PeakElementInArray
{
    public static void main (String[] args)
    {
        int[] arr = new int[]{1,2,3,4,5,6};
        int[] resArr = getPeakElement(arr,3);
        Arrays.stream(resArr).forEach(i->System.out.println(i));

    }

    private static int[] getPeakElement(int arr[], int n){
        /* int[] copyOfArr  = Arrays.copyOf(arr,n);
        Arrays.sort(copyOfArr);
        if(Arrays.equals(copyOfArr,arr)) {
            System.out.println("Sorted Array");
        }
        Arrays.sort(copyOfArr); */
        int[] resArr  = new int[arr.length];
        int i=0,j=0;
        for(;i<n;i++){
           resArr[j++] = arr[i];
           resArr[j++] = arr[i+n];
        }
        return resArr;
    }
}
