package com.example.www.Service.impl;

import com.example.www.Pojo.Restaurant;
import com.example.www.Service.RestaurantService;
import com.example.www.mapper.RestaurantMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RestaurantServiceImp implements RestaurantService {
    @Autowired
    private RestaurantMapper restaurantMapper;
    @Override
    public Integer selectTotal() {
        return restaurantMapper.selectTotal();
    }

    @Override
    public List<Restaurant> selectPage(Integer pageNum, Integer pagesize) {
        return restaurantMapper.selectPage(pageNum,pagesize);
    }

    @Override
    public Boolean insert(Restaurant restaurant) {
        return restaurantMapper.insert(restaurant);
    }

    @Override
    public Boolean update(Restaurant restaurant) {
        return restaurantMapper.update(restaurant);
    }

    @Override
    public Boolean delete(Integer id) {
        return restaurantMapper.delete(id);
    }

    @Override
    public List<Restaurant> show() {
        return restaurantMapper.show();
    }

    @Override
    public List<Restaurant> selectById(Integer id) {
        return restaurantMapper.selectById(id);
    }
}
