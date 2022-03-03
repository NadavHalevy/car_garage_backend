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

    public Vehicles(Vehicles vehicle) {
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
        switch (this.getVehicleType().toLowerCase()) {

            case "regular motorcycle":
            case "electric motorcycle":
                this.wheels = 2;
                break;
            case "regular car":
            case "electric car":
                this.wheels = 4;
                break;
            case "truck":
                this.wheels = 16;
                break;
            default:
                this.wheels = wheels;
                break;

        }
    }

    public String getBatteryOrFuel() {
        return batteryOrFuel;
    }

    public void setBatteryOrFuel(String batteryOrFuel) {

        switch (this.getVehicleType().toLowerCase()) {

            case "regular motorcycle":
            case "regular car":
            case "truck":
                this.batteryOrFuel = "fuel";
                break;
            case "electric motorcycle":
            case "electric car":
                this.batteryOrFuel = "battery";
                break;
            default:
                this.batteryOrFuel = batteryOrFuel;
                break;

        }
    }

    public void inflateTire (int howMuchAirPressureToAdd){
        /*if(this.tirePressure >)*/
        this.tirePressure += howMuchAirPressureToAdd;
    }

    public void addEnergy (
            int howMuchEnergyToAdd){
        this.energyPercentage += howMuchEnergyToAdd;
    }


}