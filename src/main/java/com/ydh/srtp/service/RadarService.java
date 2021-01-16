package com.ydh.srtp.service;

import com.ydh.srtp.dao.IRadarDao;
import com.ydh.srtp.entity.RadarData;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@Service("radarService")
public class RadarService {
    @Autowired
    private IRadarDao radarDao;

    public ArrayList<RadarData> findAllData(){
        return  radarDao.findAllData();
    }

    public RadarData findDataById(int id){
        return radarDao.findDataById(id);
    }

    public RadarData findDataByLatestTime(){
        return radarDao.findDataByLatestTime();
    }

    public void saveRadarData(RadarData radarData){
        radarDao.saveRadarData(radarData);
    }
}