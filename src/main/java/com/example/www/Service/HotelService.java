package com.example.www.Service;

import com.example.www.Controller.Dto.HotelShow;
import com.example.www.Pojo.Hotel;

import java.util.List;

public interface HotelService {
    Integer selectTotal();

    List<Hotel> selectPage(Integer pageNum, Integer pagesize);

    List<HotelShow> showHotel();

    Boolean insert(Hotel hotel);

    Boolean update(Hotel hotel);

    Boolean deleteById(Integer id);

    List<Hotel> selectById(Integer id);
}
