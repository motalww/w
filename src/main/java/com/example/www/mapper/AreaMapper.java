package com.example.www.mapper;

import com.example.www.Controller.Dto.AreaDao;
import com.example.www.Controller.Dto.AreaShow;
import com.example.www.Pojo.Area;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
public interface AreaMapper {
    @Select("select count(*) from area")
    Integer selectToral();
    @Select("select * from area limit #{pageNum},#{pagesize}")
    List<Area> selectPage(Integer pageNum, Integer pagesize);

    Boolean update(Area area);

    @Insert("insert into area(area,address,image,introduction) values (#{area},#{address},#{image},#{introduction})")
    Boolean insert(Area area);
    @Delete("delete from area where id=#{id}")
    Boolean deleteById(Integer id);

    @Select("select * from area")
    List<AreaDao> select(AreaDao area);
    @Select("select image from area order by rand() limit 3")
    List<String> selectRand();
    @Select("select id,area,image from area order by id")
    List<AreaShow> show();

    @Select("select area,address,image,introduction from area where id=#{id}")
    List<AreaDao> selectById(Integer id);
    @Select("select * from area where area like concat('%',#{areaname},'%')")
    List<AreaDao> selectByName(String areaname);
}
