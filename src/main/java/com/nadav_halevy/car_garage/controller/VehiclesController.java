package com.nadav_halevy.car_garage.controller;

import com.nadav_halevy.car_garage.model.Vehicles;
import com.nadav_halevy.car_garage.service.VehiclesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.persistence.PostUpdate;
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
    public ResponseEntity<Vehicles> getSingleVehicleByLicenseNumber(@PathVariable String id){

       try {
            Vehicles vehicle = vhiclesService.retrieveSingleVehicleByLicenseNumber(id);
            return new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);

       }catch (NoSuchElementException e) {
           return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
       }
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicles> updateVehicles(@RequestBody Vehicles vehicle, @PathVariable String id) {
        try {
            Vehicles existingVehicle = vhiclesService.retrieveSingleVehicleByLicenseNumber(id);
            vhiclesService.saveVehicles(vehicle);
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
        public String deleteVehicle( @PathVariable String id){
            vhiclesService.deleteVehicle(id);
            return "Deleted Student With id: " + id;
        }
   /* @PostMapping("/addEnergy")
    public void addEnergyRefuelOrRecharge(int licenseNumber){
        vhiclesService.vehicleTiresToMaximumPressure(licenseNumber);
    }*/



}
