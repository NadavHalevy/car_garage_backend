package com.nadav_halevy.car_garage.controller;

import com.nadav_halevy.car_garage.model.Vehicles;
import com.nadav_halevy.car_garage.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.NoSuchElementException;

@RestController
@RequestMapping("/vehicles")
@CrossOrigin
public class VehiclesController {
    @Autowired
    private VehiclesService vhiclesService;


    @PostMapping("/add")
    public String add(@RequestBody Vehicles vehicle){
        vhiclesService.saveVehicles(vehicle);
        return "New vehicle is added";
    }

    @GetMapping("/getAll")
    public List<Vehicles> getAllVehicles(){
        return vhiclesService.getAllVehicles();
    }

   @GetMapping("/getSingleVehicle/{id}")
    public ResponseEntity<Vehicles> getVehicleByID(@PathVariable int id){

       try {
            Vehicles vehicle = vhiclesService.findVehicleByID(id);
            return new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);

       }catch (NoSuchElementException e) {
           return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/getSingleVehicleByLicenseNumber/{licenseNumber}")
    public ResponseEntity<Vehicles> getVehicleByLicenseNumber(@PathVariable int licenseNumber){

        try {
            Vehicles vehicle = vhiclesService.findVehicleByLicenseNumber(licenseNumber);
            return new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);

        }catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicles> updateVehicles(@RequestBody Vehicles vehicle, @PathVariable int id) {
        try {
            Vehicles existingVehicle = vhiclesService.findVehicleByID(id);
            vhiclesService.saveVehicles(vehicle);
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
        public String deleteVehicle( @PathVariable int id){
            vhiclesService.deleteVehicle(id);
            return "Deleted Vehicle With id: " + id;
        }

    @DeleteMapping("/deleteAll")
    public String deleteAllVehicles( ){
        vhiclesService.deleteAllVehicles();
        return "All Vehicles Were Deleted";
    }

    @PutMapping("/updateTires/{licenseNumber}/{howMuch}")
    public ResponseEntity<Vehicles> vehicleTiresToMaximumPressure(@PathVariable int licenseNumber,@PathVariable  int howMuch) {

        try {
            Vehicles existingVehicle = vhiclesService.findVehicleByLicenseNumber(licenseNumber);
            existingVehicle.inflateTire(howMuch);
            vhiclesService.saveVehicles(existingVehicle);
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/addEnergy/{licenseNumber}/{howMuch}")
    public ResponseEntity<Vehicles> addEnergyRefuelOrRecharge(@PathVariable int licenseNumber,@PathVariable  int howMuch) {

        try {
            Vehicles existingVehicle = vhiclesService.findVehicleByLicenseNumber(licenseNumber);
            existingVehicle.addEnergy(howMuch);
            vhiclesService.saveVehicles(existingVehicle);
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }
 }
