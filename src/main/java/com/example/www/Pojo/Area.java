package com.example.www.Pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Area {
    Integer id;
    String area;
    String address;
    String lnglat;
    String image;
    String introduction;
}
