package com.ydh.srtp.dao;


import com.ydh.srtp.entity.LaserData;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@Mapper
@Repository
public interface ILaserDao {
    @Select("select * from laserdata")
    ArrayList<LaserData> findAllData();
    @Select("select * from laserdata where id = #{id}")
    LaserData findDataById(int id);

    @Select("select * from laserdata where id = (select max(id) from laserdata)")
    LaserData findDataBylatestTime();

    @Insert("insert into laserdata (id,distance,modify) value(#{id},#{distance},#{modify})")
    void saveLaserData(LaserData laserData);
}
