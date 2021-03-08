package com.car.carsystem.controller.login;

import com.car.carsystem.model.User;
import com.car.carsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;

/**
 * @ClassName LoginController
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/8 14:53
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "/login")
public class LoginController {

    @Autowired
    private UserService userService;

    @GetMapping("/loginUser")
    public String loginUser(@ModelAttribute User user, Model model,HttpServletRequest request){
        if(user == null){
            model.addAttribute("loginMsg","ユーザ名またはパスワードが空です。");
            return "login";
        }
        User user1 = userService.login(user);
        if(user1 != null){
            // Sessionにユーザー情報を入れます
            request.getSession().setAttribute("userInfo", user1);
            return "index";
        }else{
            model.addAttribute("loginMsg","ユーザー名かパスワードが間違います。");
            return "login";
        }
    }

    @RequestMapping("/logout")
    public String loginPage(){
        return "login";
    }
}