package com.example.www.mapper;

import com.example.www.Controller.Dto.HotelShow;
import com.example.www.Pojo.Hotel;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface HotelMapper {
    @Select("select count(*) from hotel")
    Integer selectTotal();
    @Select("select * from hotel limit #{pageNum},#{pagesize}")
    List<Hotel> selectPage(Integer pageNum, Integer pagesize);
    @Select("select id,name,image from hotel order by id")
    List<HotelShow> showHotel();

    Boolean update(Hotel hotel);

    @Insert("insert into hotel(name,price,address,image,room) values (#{name},#{price},#{address},#{image},#{room})")
    Boolean insert(Hotel hotel);
    @Delete("delete from hotel where id=#{id}")
    Boolean deleteById(Integer id);

    @Select("select * from hotel where id=#{id}")
    List<Hotel> selectById(Integer id);
}
