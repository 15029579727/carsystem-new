package com.car.carsystem.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName HelloWordController
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/8 14:27
 * @Version 1.0
 **/
@Controller
@RequestMapping(value = "")
public class InitController {

    /**
     * サーバーが起動時にログイン画面を遷移する
     * @return
     */
    @GetMapping("/")
    public String login(){
        return "login";
    }

    /**
     * ログイン画面へ遷移
     * @return
     */
    @RequestMapping("/loginPage")
    public String loginPage(){
        return "login";
    }

    /**
     * 主なメニュー画面へ遷移
     * @return
     */
    @RequestMapping("/index")
    public String index(){
        return "index";
    }
}