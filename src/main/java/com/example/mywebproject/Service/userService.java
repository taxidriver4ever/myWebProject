package com.example.mywebproject.Service;

import com.example.mywebproject.Pojo.myUser;

import java.util.List;

public interface userService {
    public void addMyUser(myUser user);
    public String getCode(String email);
    public String findByUserName(String userName);
    public String findByUserEmail(String userEmail);
}
