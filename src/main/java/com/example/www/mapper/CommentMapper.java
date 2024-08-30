package com.example.www.mapper;

import com.example.www.Pojo.Area;
import com.example.www.Pojo.Comment;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface CommentMapper {
    @Select("select com.*,user.nickname,user.avatar from comment com left join user on com.userId=user.id where com.areaId=#{areaId}")
    List<Comment> selectAreaCom(Integer areaId);
    @Insert("insert into comment(content,userId,time,areaId,hotelId,restaurantId) values (#{content},#{userId},#{time},#{areaId},#{hotelId},#{restaurantId})")
    Integer send(Comment comment);
    @Delete("delete from comment where id=#{id}")
    Integer deleteById(Integer id);
    @Select("select com.*,user.nickname,user.avatar from comment com left join user on com.userId=user.id where com.restaurantId=#{restaurantId}")
    List<Comment> selectRestCom(Integer restaurantId);
    @Select("select com.*,user.nickname,user.avatar from comment com left join user on com.userId=user.id where com.hotelId=#{hotelId}")
    List<Comment> selectHotelCom(Integer hotelId);

    @Select("select * from comment limit #{pageNum},#{pagesize} ")
    List<Comment> selectPage(Integer pageNum, Integer pagesize);
    @Select("select count(*) from comment")
    Integer selectTotal();
}
