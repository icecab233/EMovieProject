package com.aiguigu.boot.controller;

import com.aiguigu.boot.entity.Movie;
import com.aiguigu.boot.entity.User;
import com.aiguigu.boot.mapper.MovieMapper;
import com.alibaba.fastjson.JSONObject;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.conditions.update.UpdateWrapper;
//import io.swagger.annotations.Api;
//import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin
//@Api
//@Tag(name = "Movie")
public class MovieController {

    @Autowired
    private MovieMapper movieMapper;

    @GetMapping("/movie/findAll")
    public List<Movie> find(){
        return movieMapper.selectList();
    }

    @GetMapping("/movie/findOne")
    public Movie find1(){
        Movie movie=movieMapper.selectOne();
//        movie.setJbelongsToCollection(movie.getBelongsToCollection());
//        movie.setJspokenLanguages(movie.getSpokenLanguages());
        System.out.println(movie.getSpokenLanguages());
        System.out.println(movie.getBelongsToCollection());
        return movie;
    }

    @GetMapping("/movie/findPage")
    public List<Movie> findPage(){
        return movieMapper.selectPage();
    }

    @PostMapping("/movie")
    public String save(Movie movie){
        QueryWrapper<Movie> queryWrapper = new QueryWrapper();
        queryWrapper.eq("id",movie.getId());
        if(movieMapper.exists(queryWrapper))
            return "插入失败,数据已存在";
        if(movieMapper.insert(movie)!=1)
            return "插入失败";
        return "插入成功";
    }

    @DeleteMapping("/movie")
    public String drop(Movie movie){
        UpdateWrapper<Movie> queryUpdateWrapper = new UpdateWrapper<>();
        queryUpdateWrapper.and(i->i
                .eq("id",movie.getId())
                .eq("original_title",movie.getOriginalTitle()));

        if(!movieMapper.exists(queryUpdateWrapper))
            return "删除失败，数据不存在";
        if(movieMapper.delete(queryUpdateWrapper)!=1)
            return "删除失败";
        return "删除成功";
    }


    @PutMapping("/movie")
    public String modifyOriginalTitleById(
            int id,String originalTitle,String newOriginalTitle){
        Movie movie = new Movie();
        movie.setId(id);
        movie.setOriginalTitle(newOriginalTitle);


        UpdateWrapper<Movie> queryUpdateWrapper = new UpdateWrapper<>();
        queryUpdateWrapper.and(i->i
                .eq("id",id)
                .eq("original_Title",originalTitle));

        if(originalTitle==null||newOriginalTitle==null)
            return "修改失败，传入数据失败";

        if(!movieMapper.exists(queryUpdateWrapper))
            return "修改失败，数据不存在";

        if(movieMapper.update(movie,queryUpdateWrapper)!=1)
            return "修改失败";

        return "修改成功";
    }
}
