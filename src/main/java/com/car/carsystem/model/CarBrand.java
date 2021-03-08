package com.car.carsystem.model;

import java.io.Serializable;

public class CarBrand implements Serializable {

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
}