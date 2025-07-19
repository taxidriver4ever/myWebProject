package com.example.mywebproject.Controller;

import com.example.mywebproject.Dao.loginRedis;
import com.example.mywebproject.Pojo.*;
import com.example.mywebproject.Service.loginService;
import com.example.mywebproject.Service.userService;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.catalina.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin
@RestController
public class loginController {

    @Autowired
    private loginService loginservice;

    @PostMapping("/login")
    public myResult toLogin(@RequestBody myUser user) {
        IdWithUUID userWithUUID = loginservice.login(user.getUserName(), user.getUserPassword());
        if(userWithUUID.getId() != null) {
            String s = loginservice.getLoginUUID(userWithUUID.getId());
            userWithUUID.setIsLoggedIn(s);
            return myResult.success(userWithUUID);
        }
        return myResult.error(null);
    }

    @PostMapping("/sendCode2")
    public myResult toLoginByEmail(@RequestBody myUser user) {
        String email = user.getUserEmail();
        IdWithUUID userByEmail = loginservice.findByUserEmail(email);
        if(userByEmail.getId() != null){
            try {
                String myCode = loginservice.getLoginCode(email);
                return myResult.success(myCode);
            }
            catch (Exception e) {
                return myResult.error("请输入有效邮箱号码");
            }
        }
        else return myResult.error("找不到该邮箱");
    }

    @PostMapping("/loginByEmail")
    public myResult LoginByEmail(@RequestBody myUser user) {
        String email = user.getUserEmail();
        IdWithUUID byUserEmail = loginservice.findByUserEmail(email);
        if(byUserEmail.getId() != null){
            try {
                String s = loginservice.getLoginUUID(byUserEmail.getId());
                byUserEmail.setIsLoggedIn(s);
                return myResult.success(byUserEmail);
            }
            catch (Exception e) {
                return myResult.error("请输入有效邮箱号码");
            }
        }
        else return myResult.error("找不到该邮箱");
    }
}
