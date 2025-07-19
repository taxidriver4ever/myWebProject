package com.example.mywebproject.Controller;

import com.example.mywebproject.Pojo.myEmail;
import com.example.mywebproject.Pojo.myResult;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.imp.userServiceImp;
import com.example.mywebproject.Service.userService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class userController {

    @Autowired
    private userService userservice;

    @PostMapping("/register")
    public myResult getAllUser(@RequestBody myUser user) {
        if(userservice.findByUserName(user.getUserName()) != null) {return myResult.error("该用户名已被占用");}
        if(userservice.findByUserEmail(user.getUserEmail()) != null) {return myResult.error("该邮箱已注册");}
        userservice.addMyUser(user);
        return myResult.success(null);
    }

    @PostMapping("/sendCode")
    public myResult getMyEmail(@RequestBody myEmail email) {
        try {
            String myCode = userservice.getCode(email.getEmail());
            return myResult.success(myCode);
        }
        catch (Exception e) {
            return myResult.error("请输入有效邮箱号码");
        }
    }
}
