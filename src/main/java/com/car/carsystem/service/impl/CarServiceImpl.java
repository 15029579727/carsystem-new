package com.car.carsystem.service.impl;

import com.car.carsystem.dao.CarMapper;
import com.car.carsystem.model.CarBrand;
import com.car.carsystem.model.CarInfo;
import com.car.carsystem.model.CarModel;
import com.car.carsystem.service.CarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName CarServiceImpl
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/20 13:31
 * @Version 1.0
 **/
@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarMapper carMapper;
    @Override
    public List<CarInfo> getCarList(String carBrandName,String carModelName) {
        return carMapper.getCarList(carBrandName, carModelName);
    }

    @Override
    public int deleteCarInfo(List<String> deleteList) {
        return carMapper.deleteCarInfo(deleteList);
    }

    @Override
    public CarInfo getCarInfoById(List<String> ids) {
        return carMapper.getCarInfoById(ids);
    }

    @Override
    public int updateCarInfo(CarInfo carInfo) {
        return carMapper.updateCarInfo(carInfo);
    }

    @Override
    public List<CarBrand> getCarBrandSelection() {
        return carMapper.getCarBrandSelection();
    }

    @Override
    public List<CarModel> getCarCarModelSelection(String carBrand) {
        return carMapper.getCarCarModelSelection(carBrand);
    }

    @Override
    public int insertCarInfo(CarInfo carInfo) {
        // 次の車番号を取得
        String nextCarCode = carMapper.getNextCarCode();
        carInfo.setCarCode(nextCarCode);
        return carMapper.insertCarInfo(carInfo);
    }

    @Override
    public List<CarBrand> getBrandInfo(String brandName) {
        return carMapper.getBrandInfo(brandName);
    }
}