package com.example.www.Controller.Dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AreaDao {
    private String area;
    private String address;
    private String lnglat;
    private String image;
    private String introduction;
}
