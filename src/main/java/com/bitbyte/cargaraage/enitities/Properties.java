package com.bitbyte.cargaraage.enitities;

public class Properties {

    private BodyStylesEntity bodyStyle;
    private MakesEntity make;
    private String fuelType;
    private FuelConsumption mileage;
    private Integer fuelCapacity;
    private Integer accelerationTime;
    private Integer seatingCapacity;
    private Integer horsePower;
    private Integer torque;
    private String engineType;
    private Integer year;
    private String interiorColor;
    private String exteriorColor;
    private String transmission;
    private String driveterrain;

    public Properties(BodyStylesEntity bodyStyle, MakesEntity make, String fuelType, FuelConsumption mileage, Integer fuelCapacity, Integer accelerationTime, Integer seatingCapacity, Integer horsePower, Integer torque, String engineType, Integer year, String interiorColor, String exteriorColor, String transmission, String driveterrain) {
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
        this.year = year;
        this.interiorColor = interiorColor;
        this.exteriorColor = exteriorColor;
        this.transmission = transmission;
        this.driveterrain = driveterrain;
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

    public Integer getFuelCapacity() {
        return fuelCapacity;
    }

    public void setFuelCapacity(Integer fuelCapacity) {
        this.fuelCapacity = fuelCapacity;
    }

    public Integer getAccelerationTime() {
        return accelerationTime;
    }

    public void setAccelerationTime(Integer accelerationTime) {
        this.accelerationTime = accelerationTime;
    }

    public Integer getSeatingCapacity() {
        return seatingCapacity;
    }

    public void setSeatingCapacity(Integer seatingCapacity) {
        this.seatingCapacity = seatingCapacity;
    }

    public Integer getHorsePower() {
        return horsePower;
    }

    public void setHorsePower(Integer horsePower) {
        this.horsePower = horsePower;
    }

    public Integer getTorque() {
        return torque;
    }

    public void setTorque(Integer torque) {
        this.torque = torque;
    }

    public String getEngineType() {
        return engineType;
    }

    public void setEngineType(String engineType) {
        this.engineType = engineType;
    }

    public Integer getYear() {
        return year;
    }

    public void setYear(Integer year) {
        this.year = year;
    }

    public String getInteriorColor() {
        return interiorColor;
    }

    public void setInteriorColor(String interiorColor) {
        this.interiorColor = interiorColor;
    }

    public String getExteriorColor() {
        return exteriorColor;
    }

    public void setExteriorColor(String exteriorColor) {
        this.exteriorColor = exteriorColor;
    }

    public String getTransmission() {
        return transmission;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public String getDriveterrain() {
        return driveterrain;
    }

    public void setDriveterrain(String driveterrain) {
        this.driveterrain = driveterrain;
    }
}
