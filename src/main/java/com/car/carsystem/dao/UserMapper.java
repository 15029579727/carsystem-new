package com.car.carsystem.dao;

import com.car.carsystem.model.User;
import com.car.carsystem.model.UserInfo;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    User userLogin(@Param(value = "user") User user);

    List<UserInfo> getUserInfo(@Param(value = "userName") String userName,
            @Param(value = "userMobile") String userMobile);
}