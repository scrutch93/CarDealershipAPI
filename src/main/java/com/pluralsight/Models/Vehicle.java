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

    public int getVehicleId() {
        return vehicleId;
    }

    public void setVehicleId(int vehicleId) {
        this.vehicleId = vehicleId;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getMileage() {
        return mileage;
    }

    public void setMileage(int mileage) {
        this.mileage = mileage;
    }

    public int getSold() {
        return sold;
    }

    public void setSold(int sold) {
        this.sold = sold;
    }

    public String getVIN() {
        return VIN;
    }

    public void setVIN(String VIN) {
        this.VIN = VIN;
    }

    public String getMake() {
        return make;
    }

    public void setMake(String make) {
        this.make = make;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public String getTransmissionType() {
        return transmissionType;
    }

    public void setTransmissionType(String transmissionType) {
        this.transmissionType = transmissionType;
    }

    @Override
    public String toString() {
        return String.format("Vehicle ID: %d\nYear: %d\nMileage: %d\nSold: %d\nVIN: %s\nMake: %s\nModel: %s\nColor: %s\nFuel Type: %s\nTransmission Type: %s\n-------------------------------\n",
                vehicleId, year, mileage, sold, VIN, make, model, color, fuelType, transmissionType);
    }


}
