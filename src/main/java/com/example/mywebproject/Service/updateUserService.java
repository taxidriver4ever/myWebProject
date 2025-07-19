package com.example.mywebproject.Service;

import com.example.mywebproject.Pojo.myUser;

public interface updateUserService {
    public void updateUser(myUser user);
    public String getCode(String userEmail);
}
