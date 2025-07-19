package com.example.mywebproject.Controller;


import com.example.mywebproject.Pojo.myResult;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.PersonalInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
public class PersonalInfoController {

    @Autowired
    private PersonalInfoService personalInfoService;

    @PostMapping("/Authentication")
    public myResult Authentication(@RequestBody myUser user) {
        if(personalInfoService.selectByEmailAndId(user.getUserEmail(),user.getId()) != null)
            return myResult.success(personalInfoService.setUUidById(user.getId()));
        return myResult.error("您的账号与您的邮箱不符合");
    }

    @PostMapping("/sendOTP")
    public myResult sendOTP(@RequestBody myUser user) {
        if(personalInfoService.selectByEmailAndId(user.getUserEmail(),user.getId()) != null)
            return myResult.success(personalInfoService.sendOTP(user.getUserEmail()));
        return myResult.error("您的帐号与您输入的邮箱不匹配");
    }

}
