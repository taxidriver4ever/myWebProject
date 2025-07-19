package com.example.mywebproject.Mapper;

import com.example.mywebproject.Pojo.myUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface loginMapper {
    public Integer selectUserNamePassword(String userName, String userPassword);
    public Integer findByUserEmail(String userEmail);
}
