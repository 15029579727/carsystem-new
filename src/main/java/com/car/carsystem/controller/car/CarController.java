package com.car.carsystem.controller.car;

import com.car.carsystem.model.CarBrand;
import com.car.carsystem.model.CarInfo;
import com.car.carsystem.model.CarModel;
import com.car.carsystem.model.TableDataInfo;
import com.car.carsystem.service.CarService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

/**
 * @ClassName CarController
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/20 13:21
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/car")
public class CarController {

    @Autowired
    private CarService carService;

    @GetMapping("/getCarList")
    public String getCarList(@RequestParam(value = "page" ,defaultValue = "1") int page,
                             @RequestParam(value = "carBrandName" ,defaultValue = "") String carBrandName,
                             @RequestParam(value = "carModelName" ,defaultValue = "") String carModelName,
                             ModelMap model){
        PageHelper.startPage(page, 5);
        List<CarInfo>  carList = carService.getCarList(carBrandName, carModelName);
        PageInfo pages = new PageInfo(carList,10);
        model.addAttribute("carList",pages);
        model.addAttribute("carBrandName",carBrandName);
        model.addAttribute("carModelName",carModelName);
        return "basic_table";
    }

    @PostMapping(value = "/deleteCarInfo")
    public String deleteCarInfo(String id){
        System.out.println(id);
        List<String> deleteList = Arrays.asList(id.split(","));
        carService.deleteCarInfo(deleteList);
        return "basic_table";
    }

    @GetMapping(value = "/toCarUpdatePage")
    public String toCarUpdatePage(String updateId,  ModelMap model){
        List<String> ids = Arrays.asList(updateId.split(","));
        CarInfo carInfo = carService.getCarInfoById(ids);
        model.addAttribute("carInfo",carInfo);
        return "carUpdate";
    }

    @PostMapping(value = "/updateCarInfo")
    public String updateCarInfo(@RequestBody CarInfo carInfo){
        carService.updateCarInfo(carInfo);
        return "carUpdate";
    }

    @GetMapping(value = "/toInsertPage")
    public String getSelection(ModelMap modelMap){
        // ブランドのデーターを取得、Redisを追加してクエリの効率を上げることができます。
        List<CarBrand> brandList = carService.getCarBrandSelection();
        modelMap.addAttribute("brandList",brandList);
        return "insertPage";
    }

    @PostMapping(value = "/insertCar")
    @ResponseBody
    public int insertCar(@RequestBody CarInfo carInfo){
        int result = carService.insertCarInfo(carInfo);
        return result;
    }

    @GetMapping(value = "/getCarModelList")
    @ResponseBody
    public List<CarModel> getCarModelList(String carBrand){
        // モデルのデーターを取得、Redisを追加してクエリの効率を上げることができます。
        List<CarModel> modelList = carService.getCarCarModelSelection(carBrand);
        return modelList;
    }

    @GetMapping("/getBrandInfo")
    public String getBrandInfo(@RequestParam(value = "page" ,defaultValue = "1") int page,
                             @RequestParam(value = "brandName" ,defaultValue = "") String brandName,
                             ModelMap model){
        PageHelper.startPage(page, 5);
        List<CarBrand>  carList = carService.getBrandInfo(brandName);
        PageInfo pages = new PageInfo(carList,10);
        model.addAttribute("brandList",pages);
        model.addAttribute("brandName",brandName);
        return "brand_list";
    }
}