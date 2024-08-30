package com.example.www.Service;

import com.example.www.Controller.Dto.AdminDto;
import com.example.www.Controller.Dto.UserDao;
import com.example.www.Pojo.Admin;
import com.example.www.Pojo.User;

import java.util.List;


public interface UserService {

    AdminDto login(AdminDto admin);

    List<User> select();

    List<User> selectPage(Integer pageNum, Integer pagesize);

    Integer selectTotal();

    Boolean insert(UserDao user);

    Boolean update(UserDao user);

    Boolean deleteById(Integer id);

    Boolean selectBy(UserDao user);

    Admin getById(String adminId);

    UserDao userLogin(UserDao userDao);

    UserDao getByUserId(String userId);

}
