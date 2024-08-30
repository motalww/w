package com.example.www.Service.impl;

import com.example.www.Pojo.User;
import com.example.www.Service.RegisterService;
import com.example.www.mapper.RegisterMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterImpl implements RegisterService {
    @Autowired
    private RegisterMapper registerMapper;
    @Override
     public User register(User user) {
        return registerMapper.register(user);
    }
}
