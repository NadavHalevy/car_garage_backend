package com.nadav_halevy.car_garage.controller;

import com.nadav_halevy.car_garage.model.Vehicles;
import com.nadav_halevy.car_garage.service.VehiclesService;
import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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
    private Log logger = LogFactory.getLog(VehiclesController.class);


    @PostMapping("/add")
    public String add(@RequestBody Vehicles vehicle){
        vhiclesService.saveVehicles(vehicle);
        this.logger.info(String.format("VehiclesController add - adding vehicle: %d ", vehicle.getLicenseNumber()));
        return "New vehicle is added";
    }

    @GetMapping("/getAll")
    public List<Vehicles> getAllVehicles(){
        this.logger.info(String.format("VehiclesController getAllVehicles - Retrieve all of the available vehicles"));
        return vhiclesService.getAllVehicles();
    }

   @GetMapping("/getSingleVehicle/{id}")
    public ResponseEntity<Vehicles> getVehicleByID(@PathVariable int id){

       try {
           Vehicles vehicle = vhiclesService.findVehicleByID(id);
           this.logger.info(String.format("VehiclesController getVehicleByID - Retrieve a single vehicle by ID: %d", id));
           return new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);

       }catch (NoSuchElementException e) {
           return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
       }
    }

    @GetMapping("/getSingleVehicleByLicenseNumber/{licenseNumber}")
    public ResponseEntity<Vehicles> getVehicleByLicenseNumber(@PathVariable int licenseNumber){

        try {
            Vehicles vehicle = vhiclesService.findVehicleByLicenseNumber(licenseNumber);
            this.logger.info(String.format("VehiclesController getVehicleByLicenseNumber - Retrieve a single vehicle by license number: %d", licenseNumber));
            return new ResponseEntity<Vehicles>(vehicle, HttpStatus.OK);

        }catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }


    @PutMapping("/update/{id}")
    public ResponseEntity<Vehicles> updateVehicles(@RequestBody Vehicles vehicle, @PathVariable int id) {
        try {
            Vehicles existingVehicle = vhiclesService.findVehicleByID(id);
            existingVehicle.setLicenseNumber(vehicle.getLicenseNumber());
            existingVehicle.setVehicleType(vehicle.getVehicleType());
            existingVehicle.setModelName(vehicle.getModelName());
            existingVehicle.setEnergyPercentage(vehicle.getEnergyPercentage());
            existingVehicle.setTirePressure(vehicle.getTirePressure());
            existingVehicle.setWheels(vehicle.getWheels());
            existingVehicle.setBatteryOrFuel(vehicle.getBatteryOrFuel());

            vhiclesService.saveVehicles(existingVehicle);
            this.logger.info(String.format("VehiclesController updateVehicles - vehicle details update: %d", vehicle.getLicenseNumber()));
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/delete/{id}")
        public String deleteVehicle( @PathVariable int id){
            vhiclesService.deleteVehicle(id);
            this.logger.info(String.format("VehiclesController deleteVehicle - Delete a single vehicle by ID: %d", id));
            return "Deleted Vehicle With id: " + id;
        }

    @DeleteMapping("/deleteAll")
    public String deleteAllVehicles( ){
        vhiclesService.deleteAllVehicles();
        this.logger.info(String.format("VehiclesController deleteVehicle - Delete all vehicles"));
        return "All Vehicles Were Deleted";
    }

    @PutMapping("/updateTires/{licenseNumber}/{howMuch}")
    public ResponseEntity<Vehicles> vehicleTiresToMaximumPressure(@PathVariable int licenseNumber,@PathVariable  int howMuch) {

        try {
            Vehicles existingVehicle = vhiclesService.findVehicleByLicenseNumber(licenseNumber);
            existingVehicle.inflateTire(howMuch);
            vhiclesService.saveVehicles(existingVehicle);
            this.logger.info(String.format("VehiclesController vehicleTiresToMaximumPressure - Inflate vehicle tires to maximum pressure"));
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
            this.logger.info(String.format("VehiclesController addEnergyRefuelOrRecharge - Add energy (Refuel a vehicle or recharge) by license number: %d", licenseNumber));
            return new ResponseEntity<Vehicles>(HttpStatus.OK);

        } catch (NoSuchElementException e) {
            return new ResponseEntity<Vehicles>(HttpStatus.NOT_FOUND);
        }
    }
 }
