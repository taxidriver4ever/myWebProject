package com.example.mywebproject.Mapper;

import com.example.mywebproject.Pojo.myUser;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface userMapper {
    public void addMyUser(myUser user);
    public String findByUserName(String userName);
    public String findByUserEmail(String userEmail);
}
