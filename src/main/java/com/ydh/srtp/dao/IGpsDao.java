package com.ydh.srtp.dao;

import com.ydh.srtp.entity.GpsData;
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
public interface IGpsDao {

    @Select("select * from gpsdata")
    ArrayList<GpsData> findAllData();
    @Select("select * from gpsdata where id = #{id}")
    GpsData findDataById(int id);
    @Select("select * from gpsdata where id = (select max(id) from gpsdata)")
    GpsData findDataBylatestTime();
    @Insert("insert into gpsdata (location,modify) value(#{location},#{modify})")
    void saveGpsData(GpsData gpsData);
}
