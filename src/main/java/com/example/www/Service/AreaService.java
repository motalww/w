package com.example.www.Service;

import com.example.www.Controller.Dto.AreaDao;
import com.example.www.Controller.Dto.AreaShow;
import com.example.www.Pojo.Area;

import java.util.List;

public interface AreaService {
    Integer selectTotal();

    List<Area> selectPage(Integer pageNum, Integer pagesize);

    Boolean insert(Area area);

    Boolean update(Area area);

    Boolean deleteById(Integer id);

    List<AreaDao> select(AreaDao area);

    List<String> selectRand();

    List<AreaShow> show();

    List<AreaDao> selectById(Integer id);

    List<AreaDao> selectByName(String areaname);

}
