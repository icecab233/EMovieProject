package com.aiguigu.boot.mapper;

import com.aiguigu.boot.entity.User;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper extends BaseMapper<User> {

    //   查询用户，根据用户id查询信息   select * from user where id =
    @Select("select * from t_user where id = #{id}")
    User selectById(int id);


    @Select("select * from user")
    List<User> selectList();

//    @Select("select * from user where username = #{username}")
//    boolean exists(String username);

    //   查询用户及其所有的订单
//    @Select("select * from t_user")
//    @Results(
//            {
//                    @Result(column = "id",property = "id"),
//                    @Result(column = "username",property = "username"),
//                    @Result(column = "password",property = "password"),
//                    @Result(column = "birthday",property = "birthday"),
//                    @Result(column = "id",property = "orders",javaType = List.class,
//                            many=@Many(select = "com.aiguigu.boot.mapper.OrderMapper.selectByUid")
//                    )
//            }
//    )
//    List<User> selectAllUserAndOrders();
}
