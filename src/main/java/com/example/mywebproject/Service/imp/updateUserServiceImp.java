package com.example.mywebproject.Service.imp;

import com.example.mywebproject.Mapper.updateUserMapper;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.updateUserService;
import com.example.mywebproject.anno.OTPCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class updateUserServiceImp implements updateUserService {

    @Autowired
    private updateUserMapper updateusermapper;

    @Override
    public void updateUser(myUser user) {
        updateusermapper.updateUser(user);
    }

    @OTPCode
    @Override
    public String getCode(String userEmail) {
        Integer id = updateusermapper.selectUserIdByEmail(userEmail);
        if(id==null) return "Not found";
        return null;
    }
}
