package com.ydh.srtp.dao;

import com.ydh.srtp.entity.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/15
 * @Description:
 **/
@Mapper
@Repository
public interface IUserDao {
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: java.util.ArrayList<com.ydh.srtp.entity.User>
    **/
    @Select("select * from user")
    ArrayList<User> getAllUsers();
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [id]
    * @Return: com.ydh.srtp.entity.User
    **/
    @Select("select * from user where id = #{id}")
    User getUserById(String id);
}
