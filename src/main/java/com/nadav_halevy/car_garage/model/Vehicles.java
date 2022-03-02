package com.nadav_halevy.car_garage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private String id;
    private int licenseNumber;
    private String typeOfVehicle;
    private String modelName;
    private int energyPercentage; //How much battery or fuel is left
    private int tirePressure; //Maximum
    private int wheels;
    private String batteryOrFuel;

    public Vehicles() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        this.typeOfVehicle = typeOfVehicle;
    }

    public String getModelName() {
        return modelName;
    }

    public void setModelName(String modelName) {
        this.modelName = modelName;
    }

    public int getEnergyPercentage() {
        return energyPercentage;
    }

    public void setEnergyPercentage(int energyPercentage) {
        this.energyPercentage = energyPercentage;
    }

    public int getTirePressure() {
        return tirePressure;
    }

    public void setTirePressure(int tirePressure) {
        this.tirePressure = tirePressure;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        this.wheels = wheels;
    }

    public String getBatteryOrFuel() {
        return batteryOrFuel;
    }

    public void setBatteryOrFuel(String batteryOrFuel) {
        this.batteryOrFuel = batteryOrFuel;
    }

    public void inflateTire (int howMuchAirPressureToAdd){

        this.tirePressure += howMuchAirPressureToAdd;
    }

    public void addEnergy (
            int howMuchEnergyToAdd){
        this.energyPercentage += howMuchEnergyToAdd;
    }

}
