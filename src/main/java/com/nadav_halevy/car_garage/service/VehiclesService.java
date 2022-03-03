package com.nadav_halevy.car_garage.service;

import com.nadav_halevy.car_garage.model.Vehicles;

import java.util.List;
import java.util.Optional;

public interface VehiclesService {
    //Add a new vehicle to the vehicle's collection
    public Vehicles saveVehicles(Vehicles vehicle);

    //Retrieve all available vehicles
    public List<Vehicles> getAllVehicles();
    //Find a single vehicle by ID
    public Vehicles findVehicleByID(int id);
    //Find a single vehicle by license number
    public Vehicles findVehicleByLicenseNumber(int licenseNumber);
    //Delete a single vehicle by license number
    public void deleteVehicle(int id);
    //Delete all vehicles
    public void deleteAllVehicles();

}
