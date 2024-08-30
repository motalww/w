package com.example.www.Controller.Dto;

import lombok.Data;

@Data
public class AdminDto {
    private Integer id;
    private String username;
    private String password;
    private String avatar;
    private String token;
}
