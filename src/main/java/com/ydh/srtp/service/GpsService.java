package com.ydh.srtp.service;

import com.ydh.srtp.dao.IGpsDao;
import com.ydh.srtp.entity.GpsData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@Service("gpsService")
public class GpsService {
    @Autowired
    private IGpsDao gpsDao;
    public ArrayList<GpsData> findAllData(){
        return gpsDao.findAllData();
    }

    public GpsData findDataById(int id){
        return gpsDao.findDataById(id);
    }

    public GpsData findDataBylatestTime(){
        return gpsDao.findDataBylatestTime();
    }

    public void saveGpsData(GpsData gpsData){
        gpsDao.saveGpsData(gpsData);
    }
}
