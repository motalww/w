package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Pojo.User;
import com.example.www.Service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
@Controller
public class RegisterController {
    @Autowired
    private RegisterService registerService;
    @PostMapping("/client/register")
    public Result register(@RequestBody User user){
        return Result.success(registerService.register(user));
    }
}
