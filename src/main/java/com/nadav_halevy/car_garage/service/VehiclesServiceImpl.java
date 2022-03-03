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

    public Vehicles retrieveSingleVehicleByLicenseNumber(String id) {
        return vehiclesRepository.findById(id).get();
    }

    public void deleteVehicle(String id){
        vehiclesRepository.deleteById(id);
    }

    /*@Override
    public void vehicleTiresToMaximumPressure(String id, int howMuch) {
        try {
            Optional<Vehicles> vehicle = this.vehiclesRepository.findById(update.getId());
            ResponseEntity<Vehicles> vehiclesResponseEntity = new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);
            return vehiclesResponseEntity;

        }catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }*/

    /*@Override
    public void addEnergy(int licenseNumber) {

    }*/
}
