package com.ihappyk.hackerrank;

// 1 2 3 4 5
// 5 1 2 3 4
// 4 5 1 2 3
// 3 4 5 1 2
// 2 3 4 5 1
// 1 2 3 4 5
public class ArrayReverse
{
    public static int[] reverse(int a[], int n, int r)
    {
        int temp[] = new int[n];
        int mod = r % n ;
        for(int i = 0 ; i< n; i++){
            temp[i] = a[(i+mod) % n];
        }
        return temp;
    }

    public static void main(String args[]) {
        int a[]  = new int[]{1,2,3,4,5};
        int rev[] = reverse(a,5,2);
        System.out.println(rev.toString());
     }
}
