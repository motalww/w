package com.example.www.Controller.Dto;

import lombok.Data;

@Data
public class UserDao {
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String phone;
    private String nickname;
    private String token;
}
