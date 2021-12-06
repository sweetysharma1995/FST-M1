package com.java.activities;

public class Activity_2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
 int[] numbers = {10, 77, 10, 54, -11, 10};
 
 
System.out.print("Result is ----------------->>"+ find10sInTheArray(numbers,10,30));
		
		
	}
	
	
	public static boolean find10sInTheArray(int[] numArray,int searchNum,int expectedSum) {
		int sum =0;
		for(int num : numArray ) {
			
			if(num == searchNum) {
				sum+=searchNum;
			}
			
			if(sum>30) {
				break;
			}
				
			 
		 }	
		
	return 	sum ==expectedSum;
	}

}
