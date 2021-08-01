package com.softserve.entity;

import com.google.gson.annotations.SerializedName;

import io.github.sskorol.data.Source;

@Source(path = "cars.json")
public class Car {

    @SerializedName("brand")
    private String brand;
    private String model;
    private String year;
    private String fuelType;
    private String transmission;
    private String horsePower;

    public Car() {
        this.brand = "default";
        this.model = "default";
        this.year = "default";
        this.fuelType = "default";
        this.transmission = "default";
        this.horsePower = "default";
    }

    public Car(String brand, String model, String year, String fuelType, String transmission, String horsePower) {
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

    public String getYear() {
        return year;
    }

    public String getFuelType() {
        return fuelType;
    }

    public String getTransmission() {
        return transmission;
    }

    public String getHorsePower() {
        return horsePower;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public void setFuelType(String fuelType) {
        this.fuelType = fuelType;
    }

    public void setTransmission(String transmission) {
        this.transmission = transmission;
    }

    public void setHorsePower(String horsePower) {
        this.horsePower = horsePower;
    }

    @Override
    public String toString() {
        return "Car [brand=" + brand + ", model=" + model + ", year=" + year + ", fuelType=" + fuelType + ", transmission="
                + transmission + ", horsePower=" + horsePower + "]";
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((brand == null) ? 0 : brand.hashCode());
        result = prime * result + ((fuelType == null) ? 0 : fuelType.hashCode());
        result = prime * result + ((horsePower == null) ? 0 : horsePower.hashCode());
        result = prime * result + ((model == null) ? 0 : model.hashCode());
        result = prime * result + ((transmission == null) ? 0 : transmission.hashCode());
        result = prime * result + ((year == null) ? 0 : year.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        Car other = (Car) obj;
        if (brand == null) {
            if (other.brand != null)
                return false;
        } else if (!brand.equals(other.brand))
            return false;
        if (fuelType == null) {
            if (other.fuelType != null)
                return false;
        } else if (!fuelType.equals(other.fuelType))
            return false;
        if (horsePower == null) {
            if (other.horsePower != null)
                return false;
        } else if (!horsePower.equals(other.horsePower))
            return false;
        if (model == null) {
            if (other.model != null)
                return false;
        } else if (!model.equals(other.model))
            return false;
        if (transmission == null) {
            if (other.transmission != null)
                return false;
        } else if (!transmission.equals(other.transmission))
            return false;
        if (year == null) {
            if (other.year != null)
                return false;
        } else if (!year.equals(other.year))
            return false;
        return true;
    }

}
