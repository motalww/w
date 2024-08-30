package com.example.www.Service.impl;

import com.example.www.Controller.Dto.AreaDao;
import com.example.www.Controller.Dto.AreaShow;
import com.example.www.Pojo.Area;
import com.example.www.Service.AreaService;
import com.example.www.mapper.AreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AreaServiceImp implements AreaService {
    @Autowired
    private AreaMapper areaMapper;
    @Override
    public Integer selectTotal() {
        return areaMapper.selectToral();
    }

    @Override
    public List<Area> selectPage(Integer pageNum, Integer pagesize) {
        return areaMapper.selectPage(pageNum,pagesize);
    }

    @Override
    public Boolean insert(Area area) {
        return areaMapper.insert(area);
    }

    @Override
    public Boolean update(Area area) {
        return areaMapper.update(area);
    }

    @Override
    public Boolean deleteById(Integer id) {
        return areaMapper.deleteById(id);
    }

    @Override
    public List<AreaDao> select(AreaDao area) {
        return areaMapper.select(area);
    }

    @Override
    public List<String> selectRand() {
        return areaMapper.selectRand();
    }

    @Override
    public List<AreaShow> show() {
        return areaMapper.show();
    }

    @Override
    public List<AreaDao> selectById(Integer id) {
        return areaMapper.selectById(id);
    }

    @Override
    public List<AreaDao> selectByName(String areaname) {
        return areaMapper.selectByName(areaname);
    }


}
