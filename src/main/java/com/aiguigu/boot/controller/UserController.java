package com.aiguigu.boot.controller;

import com.aiguigu.boot.entity.User;
import com.aiguigu.boot.mapper.UserMapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

//import io.swagger.annotations.Api;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@Api
//@Tag(name = "User")
public class UserController {

    @Autowired
    private UserMapper userMapper;

    @GetMapping("/user/findAll")
    public List<User> find(){
        return userMapper.selectList();
    }

    //  条件查询
    @GetMapping("/user/find")
    public List<User> findByCond(){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username","zhangsan");
        return userMapper.selectList(queryWrapper);
    }

    //  分页查询
    @GetMapping("/user/findByPage")
    public IPage findByPage(){
        //设置起始值及每页条数
        Page<User> page = new Page<>(0,2);
        IPage iPage = userMapper.selectPage(page,null);
        return iPage;
    }

//    @GetMapping("/user/findById")
//    public User findById(@RequestParam(value = "id") int id){
//        return userMapper.selectById(id);
//    }

    //  插入数据
    @PostMapping("/user")
    public String save(User user){
        QueryWrapper<User> queryWrapper = new QueryWrapper<>();
        queryWrapper.eq("username",user.getUsername());
        if(userMapper.exists(queryWrapper))
            return "插入失败,数据已存在";
        if(userMapper.insert(user)!=1)
            return "插入失败";
        return "插入成功";
    }

    @DeleteMapping("/user")
    public String drop(User user){
        UpdateWrapper<User> queryUpdateWrapper = new UpdateWrapper<>();
        queryUpdateWrapper.and(i->i
                .eq("username",user.getUsername())
                .eq("password",user.getPassword()));

        if(!userMapper.exists(queryUpdateWrapper))
            return "删除失败，数据不存在";
        if(userMapper.delete(queryUpdateWrapper)!=1)
            return "删除失败";
        return "删除成功";
    }

    @PutMapping("/user")
    public String modifyPasswordByUsernameAndPassword(
            String username,String password,String newPassword){
        User user = new User();
        user.setUsername(username);
        user.setPassword(newPassword);

        UpdateWrapper<User> queryUpdateWrapper = new UpdateWrapper<>();
        queryUpdateWrapper.and(i->i
                .eq("username",username)
                .eq("password",password));

        if(username==null||password==null||newPassword==null)
            return "修改失败，传入数据失败";

        if(!userMapper.exists(queryUpdateWrapper))
            return "修改失败，数据不存在";

        if(userMapper.update(user,queryUpdateWrapper)!=1)
            return "修改失败";

        return "修改成功";
    }
}
