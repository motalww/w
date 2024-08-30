package com.example.www.Service.impl;

import com.example.www.Pojo.Area;
import com.example.www.Pojo.Comment;
import com.example.www.Service.CommentService;
import com.example.www.mapper.CommentMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CommentImpl implements CommentService {
    @Autowired
    private CommentMapper commentMapper;
    @Override
    public List<Comment> selectAreaCom(Integer areaId) {
        return commentMapper.selectAreaCom(areaId);
    }

    @Override
    public Integer send(Comment comment) {
        return commentMapper.send(comment);
    }

    @Override
    public Integer deleteById(Integer id) {
        return commentMapper.deleteById(id);
    }

    @Override
    public List<Comment> selectHotelCom(Integer hotelId) {
        return commentMapper.selectHotelCom(hotelId);
    }

    @Override
    public List<Comment> selectRestCom(Integer restaurantId) {
        return commentMapper.selectRestCom(restaurantId);
    }

    @Override
    public Integer selectTotal() {
        return commentMapper.selectTotal();
    }

    @Override
    public List<Comment> selectPage(Integer pageNum, Integer pagesize) {
        return commentMapper.selectPage(pageNum,pagesize);
    }
}
