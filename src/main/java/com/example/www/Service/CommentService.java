package com.example.www.Service;

import com.example.www.Pojo.Area;
import com.example.www.Pojo.Comment;

import java.util.List;

public interface CommentService {
    List<Comment> selectAreaCom(Integer areaId);

    Integer send(Comment comment);

    Integer deleteById(Integer id);

    List<Comment> selectHotelCom(Integer hotelId);

    List<Comment> selectRestCom(Integer restaurantId);

    Integer selectTotal();

    List<Comment> selectPage(Integer pageNum, Integer pagesize);

}
