package com.car.carsystem.service.impl;

import com.car.carsystem.dao.UserMapper;
import com.car.carsystem.model.User;
import com.car.carsystem.model.UserInfo;
import com.car.carsystem.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @ClassName UserServiceImpl
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/9 15:38
 * @Version 1.0
 **/
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public User login(User user) {
        return userMapper.userLogin(user);
    }

    @Override
    public List<UserInfo> getUserInfo(String userName, String userMobile) {
        return userMapper.getUserInfo(userName,userMobile);
    }
}