package com.ihappyk.geeksforgeeks;

import java.util.Scanner;

public class CheckIfDoorOpenClosed {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		int[] arr ;
		Scanner sc = new Scanner(System.in);
		int t = sc.nextInt();
		while(t>0){
			int n = sc.nextInt();
			arr = new int[n];
			for(int i=0;i<arr.length;i++){
				arr[i] = 1-arr[i];
				for(int j=i+1;j<arr.length;j++){
					if((j+1) % (i+1)==0) {
						arr[j]  = 1- arr[j];
					}
				}
			}
			for (int i:arr){
				System.out.print(i+" ");
			}
			System.out.println();
			t--;
		}
		sc.close();
	}

}
