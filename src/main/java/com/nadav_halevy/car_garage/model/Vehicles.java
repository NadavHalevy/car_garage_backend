package com.nadav_halevy.car_garage.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Vehicles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    //private TypeOfVehicleEnum typeOfVehicle;
    private String typeOfVehicle;
    private int licenseNumber;
    private String modelName;
    private int energyPercentage; //How much battery or fuel is left
    private int tirePressure; //Maximum
    private int wheels;
    private String batteryOrFuel;

    public Vehicles() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    /*
    REGULAR_MOTORCYCLE(2, "fuel") ,
    ELECTRIC_MOTORCYCLE(2, "battery" ),
    REGULAR_CAR(4, "fuel"),
    ELECTRIC_CAR(4, "battery"),
    TRUCK(16, "fuel");
    */

    public String getTypeOfVehicle() {
        return typeOfVehicle;
    }

    public void setTypeOfVehicle(String typeOfVehicle) {
        /*switch (typeOfVehicle){
            case "REGULAR_MOTORCYCLE":
                this.setBatteryOrFuel("fuel");
                this.setWheels(2);
            case "ELECTRIC_MOTORCYCLE":
                this.setBatteryOrFuel("battery");
                this.setWheels(2);
            case "REGULAR_CAR":
                this.setBatteryOrFuel("fuel");
                this.setWheels(4);
            case "ELECTRIC_CAR":
                this.setBatteryOrFuel("battery");
                this.setWheels(4);
            case "TRUCK":
                this.setBatteryOrFuel("fuel");
                this.setWheels(16);
            default:
                System.out.println("Midweek days are so-so.");
                break;
        }*/
        this.typeOfVehicle = typeOfVehicle;
    }

    public int getLicenseNumber() {
        return licenseNumber;
    }

    public void setLicenseNumber(int licenseNumber) {
        this.licenseNumber = licenseNumber;
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

    public void inflateTire (int howMuchAirPressureToAdd){
        this.tirePressure += howMuchAirPressureToAdd;
    }

    public void addEnergy (int howMuchEnergyToAdd){
        this.energyPercentage += howMuchEnergyToAdd;
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
}
