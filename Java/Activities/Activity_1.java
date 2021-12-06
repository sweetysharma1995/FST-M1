package com.java.activities;

public class Activity_1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Car audi = new Car();
		audi.make= 2014;
		audi.color = "Black";
		audi.transmission = "Manual";
        
		audi.displayCharacteristics();
		audi.accelarate();
		audi.brake();
		

	}

}
