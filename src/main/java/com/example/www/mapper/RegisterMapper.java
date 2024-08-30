package com.example.www.mapper;

import com.example.www.Pojo.User;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface RegisterMapper {
    @Insert("insert into user(username,password,avatar,nickname,phone) values (#{username},#{password},#{avatar},#{nickname},#{phone}")
    User register(User user);
}
