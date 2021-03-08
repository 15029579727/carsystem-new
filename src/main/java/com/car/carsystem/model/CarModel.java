package com.car.carsystem.model;

import java.io.Serializable;

public class CarModel implements Serializable {
    private String carModelCode;
    private String carModelName;
    private String carBrandCode;
    private String carBrandName;

    public String getCarBrandCode() {
        return carBrandCode;
    }

    public void setCarBrandCode(String carBrandCode) {
        this.carBrandCode = carBrandCode;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarModelCode() {
        return carModelCode;
    }

    public void setCarModelCode(String carModelCode) {
        this.carModelCode = carModelCode;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }
}