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
    private String typeOfVehicle;
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
        this.setTypeOfVehicle(vehicle.getTypeOfVehicle());
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
    //Maximum
    public void setTirePressure(int tirePressure) {
        this.tirePressure = tirePressure;
    }

    public int getWheels() {
        return wheels;
    }

    public void setWheels(int wheels) {
        switch (this.getTypeOfVehicle().toLowerCase()) {

            case "regular motorcycle":
                this.wheels = MOTORCYCLE;
            case "electric motorcycle":
                this.wheels = MOTORCYCLE;
            case "regular car":
                this.wheels = CAR;
            case "electric car":
                this.wheels = CAR;
            case "truck":
                this.wheels = TRUCK;
            default:
                this.wheels = wheels;

        }
    }

    public String getBatteryOrFuel() {
        return batteryOrFuel;
    }

    public void setBatteryOrFuel(String batteryOrFuel) {

        switch (this.getTypeOfVehicle().toLowerCase()) {

            case "regular motorcycle":
                this.batteryOrFuel = "fuel";
            case "electric motorcycle":
                this.batteryOrFuel = "battery";
            case "regular car":
                this.batteryOrFuel = "fuel";
            case "electric car":
                this.batteryOrFuel = "battery";
            case "truck":
                this.batteryOrFuel = "fuel";
            default:
                this.batteryOrFuel = batteryOrFuel;

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
