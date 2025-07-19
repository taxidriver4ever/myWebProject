package com.example.mywebproject.Service.imp;

import com.example.mywebproject.Dao.PersonalInfoRedis;
import com.example.mywebproject.Dao.imp.PersonalInfoRedisImp;
import com.example.mywebproject.Mapper.PersonalInfoMapper;
import com.example.mywebproject.Service.PersonalInfoService;
import com.example.mywebproject.anno.OTPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonalInfoServiceImp implements PersonalInfoService {

    @Autowired
    private PersonalInfoMapper personalInfoMapper;

    @Autowired
    private PersonalInfoRedisImp personalInfoRedisImp;

    @OTPCode
    @Override
    public String sendOTP(String userEmail) {
        return null;
    }

    @Override
    public Integer selectByEmailAndId(String userEmail,Integer id) {
        return personalInfoMapper.selectByEmailAndId(userEmail,id);
    }

    @Override
    public String setUUidById(Integer id) {
        return personalInfoRedisImp.setUUID(id);
    }

}
