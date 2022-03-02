package com.nadav_halevy.car_garage.service;

import com.nadav_halevy.car_garage.model.Vehicles;

import java.util.List;
import java.util.Optional;

public interface VehiclesService {
    //Add a new vehicle to the vehicle's collection
    public Vehicles saveVehicles(Vehicles vehicle);

    //Retrieve all of the available vehicles
    public List<Vehicles> getAllVehicles();

    //Retrieve a single vehicle by license number
    public Optional<Vehicles> retrieveSingleVehicleByLicenseNumber(String licenseNumber);

   /* //Inflate vehicle tires to maximum pressure
    public void vehicleTiresToMaximumPressure(int licenseNumber);

    //Add energy (Refuel a vehicle or recharge) by license number
    public void addEnergy(int licenseNumber);*/

}

//public Vehicles getVehiclesByLicenseNumber(int licenseNumber);