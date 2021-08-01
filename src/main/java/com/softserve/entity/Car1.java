package com.softserve.entity;

public class Car1 {

    private String brand;
    private String model;
    private int year;
    private String fuelType;
    private int transmission;
    private int horsePower;

    public Car1() {
        this.brand = "default";
        this.model = "default";
        this.year = -1;
        this.fuelType = "default";
        this.transmission = -1;
        this.horsePower = -1;
    }

    public Car1(String brand, String model, int year, String fuelType, int transmission, int horsePower) {
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.fuelType = fuelType;
        this.transmission = transmission;
        this.horsePower = horsePower;
    }

    public String getBrand() {
        return brand;
    }

    public String getModel() {
        return model;
    }

    public int getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public int getTransmission() {
        return transmission;
    }

    public double getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTransmission(int transmission) {
        this.transmission = transmission;
    }

    public void setHorsePower(int horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", year=" + year + ", fuelType=" + fuelType + ", transmission="
                + transmission + ", horsePower=" + horsePower + "]";
    }

}
