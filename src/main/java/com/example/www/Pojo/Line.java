package com.example.www.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Line {
    private Integer id;
    private String name;
    private String type;
    private String area;
    private String hotel;
    private String restaurant;
    private String num;
    private String price;
    private  String image;
}
