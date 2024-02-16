package com.vehicle;

public class Car extends Vehicle{
	boolean powerStearing;
	String fuelType;
	

	public Car(int vehicleNo, String engineStatus, int currentGear, boolean powerStearing, String fuelType) {
		super(vehicleNo, engineStatus, currentGear);
		this.powerStearing = powerStearing;
		this.fuelType = fuelType;
	}
	
	public void showCarDetails( ) {
		System.out.println("Vehicle No.: "+vehicleNo);
		System.out.println("Engine Status: "+engineStatus);
		System.out.println("Current Gear: "+currentGear);
		System.out.println("Power Steering: "+powerStearing);
		System.out.println("Fuel Type: "+fuelType);
		
	}

	@Override
	public 	void ignite() {
		engineStatus = "on";
		currentGear = 1;
		// TODO Auto-generated method stub
		
	}

	@Override
	public int changeGear(int flag) {
	    if (flag == 1 && currentGear < 6) {
	        currentGear += 1;
	    } else if (flag == -1 && currentGear > 1) { 
	        currentGear -= 1;
	    }
	    else if(currentGear ==6 && flag == 1){
	    	System.out.println("Maximum Gear value can only be 6");
	    }
	    else if(currentGear ==1 && flag == -1){
	    	System.out.println("Minimum Gear value can only be 1");
	    }
	    return currentGear;
	}

	@Override
	public 	void stop() {
		engineStatus = "off";
		currentGear = 0;
		// TODO Auto-generated method stub
		
	}
	

}
