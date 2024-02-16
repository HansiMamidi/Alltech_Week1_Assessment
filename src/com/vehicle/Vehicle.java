package com.vehicle;

public abstract class Vehicle {
	int vehicleNo;
	String engineStatus;
	int currentGear;
	public Vehicle(int vehicleNo, String engineStatus, int currentGear) {
//		super();
		this.vehicleNo = vehicleNo;
		this.engineStatus = engineStatus;
		this.currentGear = currentGear;
	}
	public abstract void ignite();
	public abstract int changeGear(int flag);
	public abstract void stop();

	

}
