package com.example.mywebproject.Controller;

import com.example.mywebproject.Pojo.myResult;
import com.example.mywebproject.Pojo.myUser;
import com.example.mywebproject.Service.updateUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class updateUserController {

    @Autowired
    updateUserService userService;

    @PostMapping("/getUpdateCode")
    public myResult getUpdateCode(@RequestBody myUser user) {
        String code = userService.getCode(user.getUserEmail());
        if (code == null)
            return myResult.error("找不到该邮箱");
        return myResult.success(code);
    }

    @PostMapping("/updateUserInfo")
    public myResult updateUserInfo(@RequestBody myUser user) {
        userService.updateUser(user);
        return myResult.success();
    }

}
