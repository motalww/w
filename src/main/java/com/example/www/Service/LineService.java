package com.example.www.Service;

import com.example.www.Pojo.Line;

import java.util.List;

public interface LineService {

    Integer selectTotal();

    List<Line> selectPage(Integer pageNum, Integer pagesize);
}
