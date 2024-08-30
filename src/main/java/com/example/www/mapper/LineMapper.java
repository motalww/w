package com.example.www.mapper;

import com.example.www.Pojo.Line;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface LineMapper {
    @Select("select count(*) from line")
    Integer selectToal();
    @Select("select * from line limit #{pageNum},#{pagesize}")
    List<Line> selectPage(Integer pageNum, Integer pagesize);
}
