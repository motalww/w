package com.example.www.Service.impl;

import com.example.www.Controller.Dto.HotelShow;
import com.example.www.Pojo.Hotel;
import com.example.www.Service.HotelService;
import com.example.www.mapper.HotelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class HotelServiceImp implements HotelService {
    @Autowired
    private HotelMapper hotelMapper;
    @Override
    public Integer selectTotal() {
        return hotelMapper.selectTotal();
    }

    @Override
    public List<Hotel> selectPage(Integer pageNum, Integer pagesize) {
        return hotelMapper.selectPage(pageNum,pagesize);
    }
    @Override
    public List<HotelShow> showHotel() {
        return hotelMapper.showHotel();
    }

    @Override
    public Boolean insert(Hotel hotel) {
        return hotelMapper.insert(hotel);
    }

    @Override
    public Boolean update(Hotel hotel) {
        return hotelMapper.update(hotel);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return hotelMapper.deleteById(id);
    }

    @Override
    public List<Hotel> selectById(Integer id) {
        return hotelMapper.selectById(id);
    }
}
