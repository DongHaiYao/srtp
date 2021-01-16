package com.ydh.srtp.dao;

import com.ydh.srtp.entity.Admin;
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
public interface IAdminDao {
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: java.util.ArrayList<com.ydh.srtp.entity.Admin>
    **/
    @Select("select * from admin")
    ArrayList<Admin> getAllAdmins();
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [id]
    * @Return: com.ydh.srtp.entity.Admin
    **/
    @Select("select * from admin where id = #{id}")
    Admin getAdminById(String id);

}
