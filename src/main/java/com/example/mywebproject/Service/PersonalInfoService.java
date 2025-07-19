package com.example.mywebproject.Service;

public interface PersonalInfoService {
    public String sendOTP(String userEmail);
    public Integer selectByEmailAndId(String userEmail,Integer id);
    public String setUUidById(Integer id);
}
