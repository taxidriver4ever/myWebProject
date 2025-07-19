package com.example.mywebproject.Mapper;

import com.example.mywebproject.Pojo.myUser;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface updateUserMapper {
    public void updateUser(myUser user);
    public Integer selectUserIdByEmail(String userEmail);
}
