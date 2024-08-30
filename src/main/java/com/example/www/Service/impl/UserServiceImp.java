package com.example.www.Service.impl;

import com.example.www.Controller.Dto.AdminDto;
import com.example.www.Controller.Dto.UserDao;
import com.example.www.Pojo.Admin;
import com.example.www.Pojo.User;
import com.example.www.Service.UserService;
import com.example.www.mapper.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImp implements UserService {
    @Autowired
    private UserMapper userMapper;

    @Override
    public AdminDto login(AdminDto adminDto) {

        return userMapper.loginByUsernameAndPassword(adminDto);
    }

    @Override
    public List<User> select() {
        return userMapper.selectAll();
    }

    @Override
    public List<User> selectPage(Integer pageNum, Integer pagesize) {
        return userMapper.selectPage(pageNum,pagesize);
    }

    @Override
    public Integer selectTotal() {
        return userMapper.selectTotal();
    }

    @Override
    public Boolean insert(UserDao user) {
        return userMapper.insert(user);
    }

    @Override
    public Boolean update(UserDao user) {
        return userMapper.update(user);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return userMapper.deleteById(id);
    }

    @Override
    public Boolean selectBy(UserDao user) {
        return userMapper.selectBy(user);
    }

    @Override
    public Admin getById(String adminId) {
        return userMapper.getById(adminId);
    }

    @Override
    public UserDao userLogin(UserDao userDao) {
        return userMapper.userLogin(userDao);
    }

    @Override
    public UserDao getByUserId(String userId) {
        return userMapper.getByUserId(userId);
    }
}
