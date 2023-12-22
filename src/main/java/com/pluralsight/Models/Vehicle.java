package com.pluralsight.Models;

public class Vehicle {
    protected int vehicleId, year, mileage, sold;
    protected String VIN, make,model, color, fuelType, transmissionType;

    public Vehicle(int vehicleId, int year, int mileage, int sold, String VIN, String make, String model, String color, String fuelType, String transmissionType) {
        this.vehicleId = vehicleId;
        this.year = year;
        this.mileage = mileage;
        this.sold = sold;
        this.VIN = VIN;
        this.make = make;
        this.model = model;
        this.color = color;
        this.fuelType = fuelType;
        this.transmissionType = transmissionType;
    }

    @Override
    public String toString() {
        return String.format("Vehicle ID: %d\nYear: %d\nMileage: %d\nSold: %d\nVIN: %s\nMake: %s\nModel: %s\nColor: %s\nFuel Type: %s\nTransmission Type: %s\n-------------------------------\n",
                vehicleId, year, mileage, sold, VIN, make, model, color, fuelType, transmissionType);
    }


}
