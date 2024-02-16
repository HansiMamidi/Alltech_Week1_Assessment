package com.vehicle.test;

import java.util.Scanner;

import com.vehicle.Car;
import com.vehicle.Vehicle;

public class TestVehicle {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int vehicleNo;
        String engineStatus;
        int currentGear;
        boolean powerSteering;
        String fuelType;

        while (true) {
            try {
                System.out.println("Enter the Vehicle No.: ");
                vehicleNo = sc.nextInt();
                System.out.println("Enter the Engine Status(on/off): ");
                engineStatus = sc.next().toLowerCase();
                if (!(engineStatus.equals("on") || engineStatus.equals("off"))) {
                    throw new InvalidInputException("Invalid engine status. Please enter 'on' or 'off'.");
                }
                System.out.println("Enter the current gear: ");
                currentGear = sc.nextInt();
                if (currentGear < 0 || currentGear > 6) {
                    throw new InvalidInputException("Invalid current gear. Please enter a value between 0 and 6.");
                }
                
                System.out.println("Is it power steered?(true/false) ");
                powerSteering = sc.nextBoolean();
                if (!(powerSteering || !powerSteering)) {
                    throw new InvalidInputException(
                            "Invalid power steering value. Please enter true or false.");
                }
                System.out.println("Enter the fuel type(Gas/Petrol/Diesel): ");
                fuelType = sc.next().toLowerCase();
                if (!(fuelType.equals("gas") || fuelType.equals("petrol") || fuelType.equals("diesel"))) {
                    throw new InvalidInputException(
                            "Invalid fuel type entered. Please enter Gas, Petrol, or Diesel.");
                }
                break;
            } catch (Exception e) {
                e.printStackTrace();
                sc.nextLine();
            }
        }

        Vehicle vehicle = new Car(vehicleNo, engineStatus, currentGear, powerSteering, fuelType);

        int choice = 0;
        do {
            System.out.println("***********Select an option below************");
            System.out.println("1-Ignite the car");
            System.out.println("2-Change gear");
            System.out.println("3-Stop car");
            System.out.println("4-Exit");
            System.out.println("Please enter your choice:");
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    vehicle.ignite();
                    ((Car) vehicle).showCarDetails();
                    break;
                case 2:
                    System.out.println("Enter the 1 to increase the gear or -1 to decrease the gear: ");
                    int flag = sc.nextInt();
                    vehicle.changeGear(flag);
                    ((Car) vehicle).showCarDetails();
                    break;
                case 3:
                    vehicle.stop();
                    ((Car) vehicle).showCarDetails();
                    break;
                case 4:
                    System.exit(0);
            }
        } while (choice != 4);

        sc.close();
    }
}
