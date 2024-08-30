package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Controller.Dto.AdminDto;
import com.example.www.Controller.Dto.UserDao;
import com.example.www.Service.UserService;
import com.example.www.utils.TokenUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("/login")
public class LoginController {
    @Autowired
    private UserService userService;
    @PostMapping("/admin")
    public Result login(@RequestBody AdminDto adminDto){
//        String username= adminDto.getUsername();
//        String password=adminDto.getPassword();
        AdminDto dto=userService.login(adminDto);
        if(dto!=null){
            String token= TokenUtil.getToken(dto.getId().toString(),dto.getPassword());
            dto.setToken(token);
            return Result.success(dto);
        }
        return Result.error(0,"");
    }
    @PostMapping("/user")
    public Result userLogin(@RequestBody UserDao userDao){
        UserDao dto=userService.userLogin(userDao);
        if(dto!=null){
            String token= TokenUtil.getToken(dto.getId().toString(),dto.getPassword());
            dto.setToken(token);
            return Result.success(dto);
        }
        return Result.error(0,"");
    }
}
