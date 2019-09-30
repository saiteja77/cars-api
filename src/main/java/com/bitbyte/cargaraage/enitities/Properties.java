package com.bitbyte.cargaraage.enitities;

import org.springframework.data.mongodb.core.mapping.Document;

public class Properties {

    private BodyStylesEntity bodyStyle;
    private MakesEntity make;
    private String fuelType;
    private FuelConsumption mileage;
    private String fuelCapacity;
    private String accelerationTime;
    private String seatingCapacity;
    private String horsePower;
    private String torque;
    private String engineType;
    private String year;

    public Properties(BodyStylesEntity bodyStyle, MakesEntity make, String fuelType, FuelConsumption mileage, String fuelCapacity, String accelerationTime, String seatingCapacity, String horsePower, String torque, String engineType) {
        this.bodyStyle = bodyStyle;
        this.make = make;
        this.fuelType = fuelType;
        this.mileage = mileage;
        this.fuelCapacity = fuelCapacity;
        this.accelerationTime = accelerationTime;
        this.seatingCapacity = seatingCapacity;
        this.horsePower = horsePower;
        this.torque = torque;
        this.engineType = engineType;
    }

    public BodyStylesEntity getBodyStyle() {
        return bodyStyle;
    }

    public void setBodyStyle(BodyStylesEntity bodyStyle) {
        this.bodyStyle = bodyStyle;
    }

    public MakesEntity getMake() {
        return make;
    }

    public void setMake(MakesEntity make) {
        this.make = make;
    }

    public String getFuelType() {
        return fuelType;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public FuelConsumption getMileage() {
        return mileage;
    }

    public void setMileage(FuelConsumption mileage) {
        this.mileage = mileage;
    }

    public String getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(String fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public String getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(String accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public String getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(String seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    public String getTorque() {
        return torque;
    }

    public void setTorque(String torque) {
        this.torque = torque;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }
}
