package com.ydh.srtp.controller;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import com.sun.deploy.net.HttpResponse;
import com.ydh.srtp.Utils.IsDistance;
import com.ydh.srtp.entity.LaserData;;
import com.ydh.srtp.service.LaserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@RestController
@RequestMapping("/laser")
public class LaserController {
    @Autowired
    private LaserService laserService;
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: java.util.ArrayList<com.ydh.srtp.entity.LaserData>         
    **/
    @GetMapping("/all")
    public ArrayList<LaserData> findAllData(){
        return  laserService.findAllData();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [id]
    * @Return: com.ydh.srtp.entity.LaserData         
    **/
    @GetMapping("/{id}")
    public LaserData findDataById(@PathVariable int id) {
        return laserService.findDataById(id);
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: com.ydh.srtp.entity.LaserData         
    **/
    @GetMapping("/latest")
    public LaserData findDataBylatestTime(){
        return laserService.findDataBylatestTime();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [distance]
    * @Return: void         
    **/
    @PostMapping("/{distance}")
    public void saveLaserData(@PathVariable String distance){
        LaserData laserData =new LaserData();
        if (IsDistance.isDistance(distance)){
            laserData.setDistance(distance);
            laserData.setModify(DateUtil.date().toSqlDate());
            laserService.saveLaserData(laserData);
        }
    }
}
