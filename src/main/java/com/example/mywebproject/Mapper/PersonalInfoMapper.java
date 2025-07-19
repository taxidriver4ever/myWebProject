package com.example.mywebproject.Mapper;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface PersonalInfoMapper {
    public Integer selectByEmailAndId(String userEmail,Integer id);
}
