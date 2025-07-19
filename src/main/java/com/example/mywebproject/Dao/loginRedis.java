package com.example.mywebproject.Dao;

public interface loginRedis {
    public String setIsLoggedIn(Integer id);
    public String getIsLoggedIn(String id);
}
