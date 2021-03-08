package com.car.carsystem.model;

import java.io.Serializable;

/**
 * @ClassName User
 * @Deacription TODO
 * @Author Administrator
 * @Date 2020/11/8 15:34
 * @Version 1.0
 **/
public class User implements Serializable {
    private String userName;
    private String passWord;
    private String userAccount;
    private String lastLoginTime;

    public String getUserAccount() {
        return userAccount;
    }

    public void setUserAccount(String userAccount) {
        this.userAccount = userAccount;
    }

    public String getLastLoginTime() {
        return lastLoginTime;
    }

    public void setLastLoginTime(String lastLoginTime) {
        this.lastLoginTime = lastLoginTime;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassWord() {
        return passWord;
    }

    public void setPassWord(String passWord) {
        this.passWord = passWord;
    }
}