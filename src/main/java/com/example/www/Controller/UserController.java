package com.example.www.Controller;

import com.example.www.Common.Result;
import com.example.www.Controller.Dto.UserDao;
import com.example.www.Pojo.User;
import com.example.www.Service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;
    @GetMapping("/user")
    public List<User> all(){
        List<User> list=userService.select();
        return list;
    }
    @PostMapping("/select")
    public Result select(@RequestBody UserDao user){
        return Result.success(userService.selectBy(user)) ;
    }
    //分页查询
    @GetMapping("/admin/user/page")
    public Map<String,Object> page(@RequestParam Integer pageNum,@RequestParam Integer pagesize){
        Integer total=userService.selectTotal();
        Map<String,Object> res=new HashMap<>();
        pageNum=(pageNum-1)*pagesize;
        List<User> data=userService.selectPage(pageNum,pagesize);
        res.put("data",data);
        res.put("total",total);
        return  res;
    }
    //插入或更新
    @PostMapping("/admin/user/save")
    public Boolean save(@RequestBody UserDao user){
        if(user.getId()==null){//没输入id代表新增
            return userService.insert(user);
        }else {//否则为更新
           return userService.update(user);
        }
    }
    @DeleteMapping("/admin/user/{id}")
    public Boolean delete(@PathVariable Integer id){
            return userService.deleteById(id);
    }

    //-------------------------
    @PostMapping("/client/user/update")
    public Result updateAndShow(@RequestBody UserDao user){
        if(userService.update(user)){
            return Result.success(userService.getByUserId(user.getId().toString()));
        }
        return Result.error(0,"修改失败");
    }
}
