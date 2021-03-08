package com.car.carsystem.model;

import java.io.Serializable;

/**
 * @ClassName CarInfo
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/20 13:25
 * @Version 1.0
 **/
public class CarInfo implements Serializable {
    private String id;
    private String carCode;
    private String carBrandCode;
    private String carBrandName;
    private String carModelCode;
    private String carModelName;
    private String carNumbers;
    private String carPhoto;
    private String carStatus;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }


    public String getCarBrandCode() {
        return carBrandCode;
    }

    public void setCarBrandCode(String carBrandCode) {
        this.carBrandCode = carBrandCode;
    }

    public String getCarModelCode() {
        return carModelCode;
    }

    public void setCarModelCode(String carModelCode) {
        this.carModelCode = carModelCode;
    }

    public String getCarCode() {
        return carCode;
    }

    public void setCarCode(String carCode) {
        this.carCode = carCode;
    }

    public String getCarBrandName() {
        return carBrandName;
    }

    public void setCarBrandName(String carBrandName) {
        this.carBrandName = carBrandName;
    }

    public String getCarModelName() {
        return carModelName;
    }

    public void setCarModelName(String carModelName) {
        this.carModelName = carModelName;
    }

    public String getCarNumbers() {
        return carNumbers;
    }

    public void setCarNumbers(String carNumbers) {
        this.carNumbers = carNumbers;
    }

    public String getCarPhoto() {
        return carPhoto;
    }

    public void setCarPhoto(String carPhoto) {
        this.carPhoto = carPhoto;
    }

    public String getCarStatus() {
        return carStatus;
    }

    public void setCarStatus(String carStatus) {
        this.carStatus = carStatus;
    }
}