package com.example.www.mapper;

import com.example.www.Pojo.Restaurant;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface RestaurantMapper {
    @Select("select count(*) from restaurant")
    Integer selectTotal();

    @Select("select * from restaurant limit #{pageNum},#{pagesize}")
    List<Restaurant> selectPage(Integer pageNum, Integer pagesize);

    @Insert("insert into restaurant(name,price,address,image) values(#{name},#{price},#{address},#{image})")
    Boolean insert(Restaurant restaurant);

    Boolean update(Restaurant restaurant);

    @Delete("delete from restaurant where id=#{id}")
    Boolean delete(Integer id);
    @Select("select id,name,image from restaurant")
    List<Restaurant> show();
    @Select("select * from restaurant where id=#{id}")
    List<Restaurant> selectById(Integer id);
}
