package com.example.mywebproject.Service.imp;

import com.example.mywebproject.Dao.loginRedis;
import com.example.mywebproject.Mapper.loginMapper;
import com.example.mywebproject.Mapper.userMapper;
import com.example.mywebproject.Pojo.IdWithUUID;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.loginService;
import com.example.mywebproject.anno.OTPCode;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class loginServiceImp implements loginService {

    @Autowired
    private loginMapper loginmapper;

    @Autowired
    private loginRedis loginredis;

    @Override
    public IdWithUUID login(String userName, String userPassword) {
        Integer id = loginmapper.selectUserNamePassword(userName, userPassword);
        IdWithUUID idWithUUID = new IdWithUUID();
        idWithUUID.setId(id);
        return idWithUUID;
    }

    @OTPCode
    @Override
    public String getLoginCode(String email) {
        return null;
    }

    @Override
    public IdWithUUID findByUserEmail(String userEmail) {
        Integer id = loginmapper.findByUserEmail(userEmail);
        IdWithUUID idWithUUID = new IdWithUUID();
        idWithUUID.setId(id);
        return idWithUUID;
    }

    @Override
    public String getLoginUUID(Integer id) {
        return loginredis.setIsLoggedIn(id);
    }


}
