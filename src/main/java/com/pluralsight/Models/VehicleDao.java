package com.pluralsight.Models;

import java.util.List;

public interface VehicleDao {

    public List<Vehicle> getAllVehicles();

    public List<Vehicle> getVehicleByPriceRange(double minPrice, double maxPrice);

    public List<Vehicle> getVehicleByMakeModel(String inputMake, String inputModel);

    public List<Vehicle> getVehicleByYearRange(int minYear, int maxYear);

    public List<Vehicle> getVehicleByColor();

    public List<Vehicle> getVehicleByType();

    public Vehicle addVehicle();

    public Vehicle removeVehicle();



}
