package com.java.activities;

public class Bicycle implements BicycleParts, BicycleOperations{
	public int gears;
    public int currentSpeed;

    //the Bicycle class has one constructor
    public Bicycle(int gears, int currentSpeed) {
        this.gears = gears;
        this.currentSpeed = currentSpeed;
    }

	public void applyBrake(int decrement) {		
		
		// TODO Auto-generated method stub
		currentSpeed -= decrement;
        System.out.println("Current speed: " + currentSpeed);
	}

	public void speedUp(int increment) {
		// TODO Auto-generated method stub
		currentSpeed += increment;
        System.out.println("Current speed: " + currentSpeed);
		
	}
	public String bicycleDesc() {
        return("No of gears are "+ gears + "\nSpeed of bicycle is " + currentSpeed);
    }

}
