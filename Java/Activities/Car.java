package com.java.activities;

public class Car {
	
	String color;
	String transmission;
	int make;
	int tyres;
	int doors;
	
	Car(){
		tyres =4;
		doors=4;
		
	}
	

	public  void displayCharacteristics() {
		System.out.println("Value of color is--------------->>"+color);
		System.out.println("Value of transmission is--------------->>"+transmission);
		System.out.println("Value of make is--------------->>"+make);
		System.out.println("Value of tyres is--------------->>"+tyres);
		System.out.println("Value of doors is--------------->>"+doors);
		
	}
	
	public void accelarate() {
		
		System.out.println("-----------Car is moving forward.--------------->>");
		
	}
	
public void brake() {
		
		System.out.println("-----------Car has stopped.--------------->>");
		
	}
}
