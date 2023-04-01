package com.aiguigu.boot.mapper;

import com.aiguigu.boot.entity.Movie;
import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;

import java.util.List;

@Mapper
@TableName("movies")
public interface MovieMapper extends BaseMapper<Movie> {

    @Select("select * from movies")
    List<Movie> selectList();

    @Select("select * from movies limit 1")
    Movie selectOne();

    @Select("select * from movies limit 1000")
    List<Movie> selectPage();

//    @Select("select * from movies where id = #{id}")
//    boolean exists(int id);
}
