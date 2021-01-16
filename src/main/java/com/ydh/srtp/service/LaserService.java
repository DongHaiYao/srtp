package com.ydh.srtp.service;

import com.ydh.srtp.dao.ILaserDao;
import com.ydh.srtp.entity.LaserData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@Service("laserService")
public class LaserService {
    @Autowired
    private ILaserDao laserDao;
    public ArrayList<LaserData> findAllData(){
        return  laserDao.findAllData();
    }

    public LaserData findDataById(int id){
        return laserDao.findDataById(id);
    }


    public LaserData findDataBylatestTime(){
        return laserDao.findDataBylatestTime();
    }


    public void saveLaserData(LaserData laserData){
        laserDao.saveLaserData(laserData);
    }
}
