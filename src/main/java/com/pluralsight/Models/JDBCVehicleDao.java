package com.pluralsight.Models;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

@Component
public class JDBCVehicleDao implements VehicleDao {

    private DataSource dataSource;


    @Autowired
    public JDBCVehicleDao(DataSource dataSource){
        this.dataSource = dataSource;
    }


    @Override
    public List<Vehicle> getAllVehicles() {
        return null;
    }

    @Override
    public List<Vehicle> getVehicleByPriceRange(double minPrice, double maxPrice) {
        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles v\n" +
                "JOIN sales_contracts s ON v.VIN = s.VIN\n" +
                "WHERE sale_price BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setDouble(1, minPrice);
            preparedStatement.setDouble(2,maxPrice);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");

                Vehicle vehicle = new Vehicle(vehicleId,year,  mileage,  sold,  VIN,  make,  model,  color,  fuelType,  transmissionType);
                vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;
    }

    @Override
    public List<Vehicle> getVehicleByMakeModel(String inputMake, String inputModel) {
        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles \n" +
                "WHERE make = ? AND model = ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setString(1,inputMake);
            preparedStatement.setString(2,inputModel);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");

                Vehicle vehicle = new Vehicle(vehicleId,year,  mileage,  sold,  VIN,  make,  model,  color,  fuelType,  transmissionType);
                vehicleList.add(vehicle);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;


    }

    @Override
    public List<Vehicle> getVehicleByYearRange(int minYear, int maxYear) {
        List<Vehicle> vehicleList = new ArrayList<>();

        String sql = "SELECT * FROM vehicles v\n" +
                "WHERE year BETWEEN ? AND ?;";

        try (Connection connection = dataSource.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {

            preparedStatement.setInt(1,minYear);
            preparedStatement.setInt(2,maxYear);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int vehicleId = resultSet.getInt("vehicle_id");
                int year = resultSet.getInt("year");
                int mileage = resultSet.getInt("mileage");
                int sold = resultSet.getInt("SOLD");

                String VIN = resultSet.getString("VIN");
                String make = resultSet.getString("make");
                String model = resultSet.getString("model");
                String color = resultSet.getString("Color");
                String fuelType = resultSet.getString("fuel_type");
                String transmissionType = resultSet.getString("transmission_type");


            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return vehicleList;


    }

    @Override
    public List<Vehicle> getVehicleByColor() {
        return null;
    }

    @Override
    public List<Vehicle> getVehicleByType() {
        return null;
    }

    @Override
    public Vehicle addVehicle() {
        return null;
    }

    @Override
    public Vehicle removeVehicle() {
        return null;
    }
}
