package com.example.mywebproject.Service;

import com.example.mywebproject.Pojo.IdWithUUID;
import com.example.mywebproject.Pojo.myUser;

import java.util.List;

public interface loginService {
    public IdWithUUID login(String userName, String userPassword);
    public String getLoginCode(String email);
    public IdWithUUID findByUserEmail(String userEmail);
    public String getLoginUUID (Integer id);
}
