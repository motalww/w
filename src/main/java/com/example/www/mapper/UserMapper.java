package com.example.www.mapper;

import com.example.www.Controller.Dto.AdminDto;
import com.example.www.Controller.Dto.UserDao;
import com.example.www.Pojo.Admin;
import com.example.www.Pojo.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface UserMapper {
    @Select("select * from admin where username=#{username} and password=#{password}")
    AdminDto loginByUsernameAndPassword(AdminDto admin);
    @Select("select * from user")
    List<User> selectAll();
    @Select("select * from user limit #{pageNum},#{pagesize}")
    List<User> selectPage(Integer pageNum, Integer pagesize);
    @Select("select count(*) from user")
    Integer selectTotal();
    @Insert("insert into user(username, password, nickname, phone)  values (#{username},#{password},#{nickname},#{phone})")
    Boolean insert(UserDao user);

    Boolean update(UserDao user);
    @Delete("delete from user where id=#{id}")
    Boolean deleteById(Integer id);
    @Select("select * from user where username=#{username} and password=#{password}")
    Boolean selectBy(UserDao user);
    @Select("select * from admin where id=#{adminId}")
    Admin getById(String adminId);
    @Select("select * from user where username=#{username} and password=#{password}")
    UserDao userLogin(UserDao userDao);
    @Select("select * from user where id=#{userId}")
    UserDao getByUserId(String userId);
}
