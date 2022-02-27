package com.nadav_halevy.car_garage.service;

import com.nadav_halevy.car_garage.model.Vehicles;

import java.util.List;

public interface VehiclesService {
    public Vehicles saveVehicles(Vehicles vehicles);
    public List<Vehicles> getAllVehicles();
}

//public Vehicles getVehiclesByLicenseNumber(int licenseNumber);