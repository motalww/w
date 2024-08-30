package com.example.www.Service;

import com.example.www.Pojo.Restaurant;

import java.util.List;

public interface RestaurantService {
    Integer selectTotal();

    List<Restaurant> selectPage(Integer pageNum, Integer pagesize);

    Boolean insert(Restaurant restaurant);

    Boolean update(Restaurant restaurant);

    Boolean delete(Integer id);

    List<Restaurant> show();

    List<Restaurant> selectById(Integer id);
}
