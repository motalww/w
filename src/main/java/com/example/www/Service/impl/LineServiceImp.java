package com.example.www.Service.impl;

import com.example.www.Pojo.Line;
import com.example.www.Service.LineService;
import com.example.www.mapper.LineMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LineServiceImp implements LineService {
    @Autowired
    private LineMapper lineMapper;

    @Override
    public Integer selectTotal() {
        return lineMapper.selectToal();
    }

    @Override
    public List<Line> selectPage(Integer pageNum, Integer pagesize) {
        return lineMapper.selectPage(pageNum,pagesize);
    }
}
