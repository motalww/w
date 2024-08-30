package com.example.www.Controller;

import com.example.www.Pojo.Line;
import com.example.www.Service.LineService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/line")
public class LineController {
    @Autowired
    private LineService lineService;
    @GetMapping("/admin/line/page")
    public Map<String,Object> page(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
        Integer total=lineService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<Line> data=lineService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return  res;
    }
}
