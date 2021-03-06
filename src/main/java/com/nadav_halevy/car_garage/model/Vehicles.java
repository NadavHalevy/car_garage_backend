package com.nadav_halevy.car_garage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicles {

    final int MOTORCYCLE = 2;
    final int CAR = 4;
    final int TRUCK = 16;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int licenseNumber;
    private String vehicleType;
    private String modelName;
    private int energyPercentage; //How much battery or fuel is left
    private int tirePressure; //Maximum
    private int wheels;
    private String batteryOrFuel;

    public Vehicles() {
    }

    public Vehicles(int licenseNumber, String vehicleType, String modelName, int energyPercentage, int tirePressure, int wheels, String batteryOrFuel) {
        super();
        this.licenseNumber = licenseNumber;
        this.vehicleType = vehicleType;
        this.modelName = modelName;
        this.energyPercentage = energyPercentage;
        this.tirePressure = tirePressure;
        this.wheels = wheels;
        this.batteryOrFuel = batteryOrFuel;
    }

    public Vehicles(Vehicles vehicle){
        this.setId(vehicle.getId());
        this.setLicenseNumber(vehicle.getLicenseNumber());
        this.setVehicleType(vehicle.getVehicleType());
        this.setModelName(vehicle.getModelName());
        this.setEnergyPercentage(vehicle.getEnergyPercentage());
        this.setTirePressure(vehicle.getTirePressure());
        this.setWheels(vehicle.getWheels());
        this.setBatteryOrFuel(vehicle.getBatteryOrFuel());
    }
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
    }

    public String getVehicleType(){
        return vehicleType;
    }

    public void setVehicleType(String vehicleType ){
        this.vehicleType = vehicleType;
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
    //Maximum
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