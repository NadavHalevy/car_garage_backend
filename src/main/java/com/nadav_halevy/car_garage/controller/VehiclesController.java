package com.nadav_halevy.car_garage.controller;

import com.nadav_halevy.car_garage.model.Vehicles;
import com.nadav_halevy.car_garage.service.VehiclesService;
import org.apache.catalina.LifecycleState;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

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

 /*   @GetMapping("/getSingleVehicle")
    public Vehicles getSingleVehicleByLicenseNumber(int licenseNumber){
        return vhiclesService.retrieveSingleVehicleByLicenseNumber(licenseNumber);
    }

    @PostMapping("/inflateVehicle")
    public void doVehicleTiresToMaximumPressure(int licenseNumber){
        vhiclesService.vehicleTiresToMaximumPressure(licenseNumber);
    }

    @PostMapping("/addEnergy")
    public void addEnergyRefuelOrRecharge(int licenseNumber){
        vhiclesService.vehicleTiresToMaximumPressure(licenseNumber);
    }*/


}
