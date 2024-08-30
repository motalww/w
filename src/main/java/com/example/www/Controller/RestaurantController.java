package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Pojo.Restaurant;
import com.example.www.Service.RestaurantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@RestController
//@RequestMapping("/restaurant")
public class RestaurantController {
    @Autowired
    private RestaurantService restaurantService;
    @GetMapping("/admin/restaurant/page")
    public Map<String,Object> rPage(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
        Integer total=restaurantService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<Restaurant> data=restaurantService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return res;
    }
    @PostMapping("/admin/restaurant/save")
    public Boolean save(@RequestBody Restaurant restaurant){
        if(restaurant.getId()==null){//没输入id代表新增
            return restaurantService.insert(restaurant);
        }else {//否则为更新
            return restaurantService.update(restaurant);
        }
    }
    @DeleteMapping("/admin/restaurant/{id}")
    public Boolean delete(@PathVariable Integer id){
        return restaurantService.delete(id);
    }
    //-------------------------------
    @GetMapping("/client/restaurant/show")
    public Result showArea(){
        return Result.success(restaurantService.show());
    }
    @GetMapping("/client/restaurant/{id}")
    public Result selectById(@PathVariable Integer id){
        return Result.success(restaurantService.selectById(id));
    }

}
