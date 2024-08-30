package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Controller.Dto.AreaDao;
import com.example.www.Pojo.Area;
import com.example.www.Service.AreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/area")
public class AreaController {
    @Autowired
    private AreaService areaService;
        @GetMapping("/admin/area/page")
    public Map<String,Object> page(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
        Integer total=areaService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<Area> data=areaService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return  res;
    }
    @PostMapping("/admin/area/save")
    public Boolean save(@RequestBody Area area){
        if(area.getId()==null){
           return areaService.insert(area);
        }
        else {
            return areaService.update(area);
        }
    }
    @DeleteMapping("/admin/area/{id}")
    public Boolean delete(@PathVariable Integer id){
        return areaService.deleteById(id);
    }

    @GetMapping("/admin/area/select")
    public List<AreaDao> select(AreaDao area){
        return  areaService.select(area);
    }
//--------------------------------------------
    @GetMapping("/client/area/rand")
    public Result selectRand(){
        return Result.success(areaService.selectRand());
    }

    @GetMapping("/client/area/show")
    public Result showArea(){
        return Result.success(areaService.show());
    }

    @GetMapping("/client/area/{id}")
    public Result selectById(@PathVariable Integer id){
        return Result.success(areaService.selectById(id));
    }

    @GetMapping("/client/area/search")
    public Result selectByName(@RequestParam String areaname){
        List<AreaDao> list=areaService.selectByName(areaname);
        if(!list.isEmpty()){
            return Result.success(areaService.selectByName(areaname));
        }else {
            return Result.error(0,"请重新输入查询关键字");
        }
    }
}
