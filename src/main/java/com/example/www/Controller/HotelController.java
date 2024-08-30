package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Pojo.Hotel;
import com.example.www.Service.HotelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/hotel")
public class HotelController {
    @Autowired
    private HotelService hotelService;
    @GetMapping("/admin/hotel/page")
    public Map<String,Object> hPage(@RequestParam Integer pageNum, @RequestParam Integer pagesize){
        Integer total=hotelService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<Hotel> data=hotelService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return res;
    }
    @PostMapping("/admin/hotel/save")
    public Boolean save(@RequestBody Hotel hotel){
        if(hotel.getId()==null){
            return hotelService.insert(hotel);
        }
        else {
            return hotelService.update(hotel);
        }
    }
    @DeleteMapping("/admin/hotel/{id}")
    public Boolean deleteById(@PathVariable Integer id){
        return hotelService.deleteById(id);
    }
    //-----------------------------------
    @GetMapping("/client/hotel/show")
    public Result showHotel(){
        return Result.success(hotelService.showHotel());
    }
    @GetMapping("/client/hotel/{id}")
    public Result selectById(@PathVariable Integer id){
        return Result.success(hotelService.selectById(id));
    }
}
