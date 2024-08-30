package com.example.www.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Hotel {
    private Integer id;
    private String name;
    private String price;
    private String address;
    private String image;
    private String room;
}
