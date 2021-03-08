package com.car.carsystem.controller.login;

import com.car.carsystem.model.CarInfo;
import com.car.carsystem.model.User;
import com.car.carsystem.model.UserInfo;
import com.car.carsystem.service.UserService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @ClassName UserController
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/9 15:39
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/getUserInfo")
    public String getUserInfo(@RequestParam(value = "page" ,defaultValue = "1") int page,
                             @RequestParam(value = "userName" ,defaultValue = "") String userName,
                             @RequestParam(value = "userMobile" ,defaultValue = "") String userMobile,
                             ModelMap model){
        PageHelper.startPage(page, 10);
        List<UserInfo> userList= userService.getUserInfo(userName, userMobile);
        PageInfo pages = new PageInfo(userList,10);
        model.addAttribute("userList",pages);
        model.addAttribute("userName",userName);
        model.addAttribute("userMobile",userMobile);
        return "userInfo";
    }
}