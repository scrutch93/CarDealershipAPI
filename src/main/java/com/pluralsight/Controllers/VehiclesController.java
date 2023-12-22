package com.pluralsight.Controllers;

import com.pluralsight.Models.Vehicle;
import com.pluralsight.Models.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;


import java.sql.SQLException;
import java.util.List;

@RestController
public class VehiclesController {

    private VehicleDao dao;

    @Autowired
    public VehiclesController(VehicleDao dao){
        this.dao = dao;
    }

    @RequestMapping(path = "/vehicles", method = RequestMethod.GET)
    public List<Vehicle> getAllVehicle() throws SQLException {

        List<Vehicle> vehicles = dao.getAllVehicles();

        return vehicles;
    }

    @RequestMapping(path = "/vehicles/{minPrice}/{maxPrice}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByPrice(
            @PathVariable double minPrice,
            @PathVariable double maxPrice
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByPriceRange(minPrice, maxPrice);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/{make}/{model}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByMakeModel(
            @PathVariable String make,
            @PathVariable String model
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByMakeModel(make, model);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/{color}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByMakeModel(
            @PathVariable String color
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByColor(color);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/{menYear}/{maxYear}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByYearRange(
            @PathVariable int minYear,
            @PathVariable int maxYear
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByYearRange(minYear, maxYear);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/{minMiles}/{maxMiles}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByMileageRange(
            @PathVariable int minMiles,
            @PathVariable int maxMiles
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByMileRange(minMiles, maxMiles);
        return vehicles;
    }


}
