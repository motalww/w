package com.example.www.Controller;

import cn.hutool.core.date.DateUtil;
import com.example.www.Common.Result;
import com.example.www.Pojo.Area;
import com.example.www.Pojo.Comment;
import com.example.www.Service.CommentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/comment")
public class CommentController {
    @Autowired
    private CommentService commentService;
    @GetMapping("/all")
    public Map<String,Object> aComment(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
        Integer total=commentService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<Comment> data=commentService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return  res;
    }
    @GetMapping("/area/{areaId}")
    public Result selectAreaCom(@PathVariable Integer areaId){
        List<Comment> list=commentService.selectAreaCom(areaId);
        return Result.success(list);
    }
    @GetMapping("/hotel/{hotelId}")
    public Result selectHotelCom(@PathVariable Integer hotelId){
        List<Comment> list=commentService.selectHotelCom(hotelId);
        return Result.success(list);
    }
    @GetMapping("/restaurant/{restaurantId}")
    public Result selectRestCom(@PathVariable Integer restaurantId){
        List<Comment> list=commentService.selectRestCom(restaurantId);
        return Result.success(list);
    }


    @PostMapping("/send")
    public Result send(@RequestBody Comment comment){
        if(comment.getId()==null){
            comment.setTime(DateUtil.now());
        }
        commentService.send(comment);
        return Result.success();
    }
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable Integer id){
        commentService.deleteById(id);
        return Result.success();
    }
}
