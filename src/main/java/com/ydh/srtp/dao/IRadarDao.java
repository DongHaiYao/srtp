package com.ydh.srtp.dao;

import com.ydh.srtp.entity.RadarData;
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
public interface IRadarDao {
    @Select("select * from radardata")
    ArrayList<RadarData> findAllData();
    @Select("select * from radardata where id = #{id}")
    RadarData findDataById(int id);

    @Select("select * from radardata where id = (select max(id) from radardata)")
    RadarData findDataByLatestTime();

    @Insert("insert into radardata (id,radarImg,modify) value(#{id},#{radarImg},#{modify})")
    void saveRadarData(RadarData radarData);
}
