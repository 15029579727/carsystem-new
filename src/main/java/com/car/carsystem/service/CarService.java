package com.car.carsystem.service;

import com.car.carsystem.model.CarBrand;
import com.car.carsystem.model.CarInfo;
import com.car.carsystem.model.CarModel;

import java.util.List;

public interface CarService {
   List<CarInfo>  getCarList(String carBrandName,String carModelName);

   int  deleteCarInfo(List<String> deleteList);

   CarInfo getCarInfoById(List<String> ids);

   int updateCarInfo(CarInfo carInfo);

   List<CarBrand> getCarBrandSelection();

   List<CarModel> getCarCarModelSelection(String carBrand);

   int  insertCarInfo(CarInfo carInfo);

   List<CarBrand>  getBrandInfo(String carBrandName);
}