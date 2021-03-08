package com.car.carsystem.dao;

import com.car.carsystem.model.CarBrand;
import com.car.carsystem.model.CarInfo;
import com.car.carsystem.model.CarModel;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface CarMapper {

    List<CarInfo> getCarList(
            @Param(value = "carBrandName") String carBrandName,
            @Param(value = "carModelName") String carModelName);

    int  deleteCarInfo(@Param(value = "deleteList") List<String> deleteList);

    CarInfo getCarInfoById(@Param(value = "ids") List<String> ids);

    int updateCarInfo(@Param(value = "carInfo") CarInfo carInfo);

    List<CarBrand> getCarBrandSelection();

    List<CarModel> getCarCarModelSelection(@Param(value = "carBrand") String carBrand);

    int insertCarInfo(@Param(value = "carInfo") CarInfo carInfo);

    String getNextCarCode();

    List<CarBrand>  getBrandInfo(@Param(value = "brandName") String brandName);
}