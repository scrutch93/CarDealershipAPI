package com.pluralsight.Controllers;

import com.pluralsight.Models.Vehicle;
import com.pluralsight.Models.VehicleDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;


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

    @RequestMapping(path = "/vehicles/priceSearch/{minPrice}/{maxPrice}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByPrice(
            @PathVariable double minPrice,
            @PathVariable double maxPrice
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByPriceRange(minPrice, maxPrice);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/makeModelSearch/{make}/{model}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByMakeModel(
            @PathVariable String make,
            @PathVariable String model
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByMakeModel(make, model);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/colorSearch/{color}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByColor(
            @PathVariable String color
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByColor(color);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/yearSearch/{minYear}/{maxYear}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByYearRange(
            @PathVariable int minYear,
            @PathVariable int maxYear
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByYearRange(minYear, maxYear);
        return vehicles;
    }

    @RequestMapping(path = "/vehicles/mileageSearch/{minMiles}/{maxMiles}", method = RequestMethod.GET)
    public List<Vehicle> getVehicleByMileageRange(
            @PathVariable int minMiles,
            @PathVariable int maxMiles
    ) throws SQLException {
        List<Vehicle> vehicles = dao.getVehicleByMileRange(minMiles, maxMiles);
        return vehicles;
    }

    @RequestMapping(path="/vehicles/added",method=RequestMethod.POST)
    @ResponseStatus(value = HttpStatus.CREATED)
    public Vehicle addVehicle (
            @RequestBody Vehicle vehicle
    )
    {
        // the insert method of the DAO should return
        // a Employee object with the new id that was generated
        Vehicle newVehicle = dao.addVehicle(vehicle);
        // return the new supplier object
        return newVehicle;
    }


}
