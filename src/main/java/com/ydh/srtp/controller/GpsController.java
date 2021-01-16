package com.ydh.srtp.controller;

import cn.hutool.core.date.DateUtil;
import com.ydh.srtp.Utils.IsLocation;
import com.ydh.srtp.entity.GpsData;
import com.ydh.srtp.service.GpsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@RestController
@RequestMapping("/gps")
public class GpsController {
    @Autowired
    private GpsService gpsService;
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: java.util.ArrayList<com.ydh.srtp.entity.GpsData>         
    **/
    @GetMapping("/all")
    public ArrayList<GpsData> findAllData(){
        return gpsService.findAllData();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [id]
    * @Return: com.ydh.srtp.entity.GpsData         
    **/
    @GetMapping("/{id}")
    public GpsData findDataById(@PathVariable int id){
        return gpsService.findDataById(id);
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: com.ydh.srtp.entity.GpsData         
    **/
    @GetMapping("/latest")
    public GpsData findDataBylatestTime(){
        return gpsService.findDataBylatestTime();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [location]
    * @Return: com.ydh.srtp.entity.GpsData         
    **/
    @PostMapping("/{location}")
    public GpsData  saveGpsData(@PathVariable String location){
        GpsData gpsData = new GpsData();
        if (IsLocation.isLocation(location)){
            gpsData.setLocation(location);
            gpsData.setModify(DateUtil.date().toSqlDate());
            gpsService.saveGpsData(gpsData);
        }
        return gpsData;
    }
}
