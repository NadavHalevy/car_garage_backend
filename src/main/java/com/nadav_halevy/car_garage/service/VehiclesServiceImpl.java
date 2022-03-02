package com.nadav_halevy.car_garage.service;

import com.nadav_halevy.car_garage.model.Vehicles;
import com.nadav_halevy.car_garage.repository.VehiclesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class VehiclesServiceImpl implements VehiclesService{

    @Autowired
    private VehiclesRepository vehiclesRepository;

    @Override
    public Vehicles saveVehicles(Vehicles vehicle) {
        return vehiclesRepository.save(vehicle);
    }

    @Override
    public List<Vehicles> getAllVehicles() {
        return vehiclesRepository.findAll();
    }

    @Override

    public Optional<Vehicles> retrieveSingleVehicleByLicenseNumber(String id) {
        return vehiclesRepository.findById(id);
    }

    /*@Override
    public void vehicleTiresToMaximumPressure(int licenseNumber) {

    }

    @Override
    public void addEnergy(int licenseNumber) {

    }*/
}
