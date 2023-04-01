package com.aiguigu.boot.controller;

import com.aiguigu.boot.entity.User;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin
public class HelloController {

    //@RequestMapping("/hello")
    @GetMapping("/hello")
    public String hello(@RequestParam(value = "username", required = false) String nickname)
    {
        System.out.println(nickname);
        return "Spring Boot Hello World! Welcome " + nickname;
    }

    @PostMapping("/postTest1")
    public String postTest1()
    {
        return "POST TEST请求成功";
    }

    @PostMapping("/postTest2")
    public String postTest2(String name,String password)
    {
        System.out.println("username:" + name + "\npassword:" + password);
        return "POST TEST请求成功";
    }

    @PostMapping("/postTest3")
    public String postTest3(User user)
    {
        //System.out.println("name:" + username.getName() + "\npassword:" + user.getPassword());
        System.out.println(user);
        return "POST TEST请求成功";
    }

    @PostMapping("/postTest4")
    public String postTest4(@RequestBody User user)
    {
        //System.out.println("name:" + username.getName() + "\npassword:" + user.getPassword());
        System.out.println(user);
        return "POST TEST请求成功";
    }

    @GetMapping("/test/**")
    public String test()
    {
        return "通配符请求";
    }

    @GetMapping("/user/{id}")
    public String getUserID(@PathVariable int id){
        System.out.println(id);
        return "get请求\n根据id获取用户";
    }

    @PostMapping("/boolean")
    public boolean postBool(){
        boolean isFalseABoolean = Boolean.valueOf("False");
        System.out.println(isFalseABoolean);
        return isFalseABoolean;
    }
}
