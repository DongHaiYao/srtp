package com.ydh.srtp.controller;

import cn.hutool.core.date.DateUtil;
import com.ydh.srtp.entity.RadarData;
import com.ydh.srtp.service.RadarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;
import java.util.ArrayList;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@RestController
@RequestMapping("/radar")
public class RadarController {
    @Autowired
    private RadarService radarService;
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: java.util.ArrayList<com.ydh.srtp.entity.RadarData>         
    **/
    @GetMapping("/all")
    public ArrayList<RadarData> findAllData(){
        return  radarService.findAllData();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [id]
    * @Return: com.ydh.srtp.entity.RadarData         
    **/
    @GetMapping("/{id}")
    public RadarData findDataById(@PathVariable int id){
        return radarService.findDataById(id);
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: []
    * @Return: com.ydh.srtp.entity.RadarData         
    **/
    @GetMapping("/latest")
    public RadarData findDataBylatestTime(){
        return radarService.findDataByLatestTime();
    }
    /**
    * @Author: DongHai
    * @Date: 2021/1/15
    * @Param: [image]
    * @Return: com.ydh.srtp.entity.RadarData         
    **/
    @PostMapping("/update")
    public RadarData saveRadarData(MultipartFile image) {
        RadarData radarData = new RadarData();
        try {
            radarData.setRadarImg(image.getBytes());
            radarData.setModify(DateUtil.date().toSqlDate());
            radarService.saveRadarData(radarData);
        }catch (Exception e){
            throw new NullPointerException();
        }
       return radarData;
    }
}
