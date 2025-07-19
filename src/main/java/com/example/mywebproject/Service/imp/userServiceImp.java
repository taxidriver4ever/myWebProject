package com.example.mywebproject.Service.imp;

import com.example.mywebproject.Mapper.userMapper;
import com.example.mywebproject.Pojo.myResult;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.userService;
import com.example.mywebproject.anno.OTPCode;
import jakarta.mail.Message;
import jakarta.mail.internet.InternetAddress;
import jakarta.mail.internet.MimeMessage;
import jakarta.mail.internet.NewsAddress;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.annotation.Order;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMailMessage;
import org.springframework.mail.javamail.MimeMessagePreparator;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Random;

@Service
public class userServiceImp implements userService {

    @Autowired
    private userMapper userMapper;

    @Transactional
    @Override
    public void addMyUser(myUser user) {
        DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        user.setCreateDate(dateFormat.format(new Date()));
        userMapper.addMyUser(user);
    }

    @OTPCode
    @Override
    public String getCode(String email) {
        return null;
    }

    @Override
    public String findByUserName(String userName) {
        return userMapper.findByUserName(userName);
    }

    @Override
    public String findByUserEmail(String userEmail) {
        return userMapper.findByUserEmail(userEmail);
    }


}
