package com.ydh.srtp;

import cn.hutool.core.date.DateUtil;
import cn.hutool.http.HttpRequest;
import cn.hutool.http.HttpResponse;
import cn.hutool.json.JSONUtil;
import com.ydh.srtp.entity.GpsData;
import com.ydh.srtp.entity.LaserData;
import com.ydh.srtp.entity.RadarData;
import com.ydh.srtp.service.LaserService;
import com.ydh.srtp.service.RadarService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.sql.Date;

@SpringBootTest
class SrtpApplicationTests {

    @Test
    void contextLoads() {

        HttpResponse response = HttpRequest.get("http://localhost:8081/gps/1").execute();
        if(!"".equals(response.body())){
            System.out.println(response.body());
            GpsData gpsData = JSONUtil.toBean(response.body(),GpsData.class);
            System.out.println(gpsData);
        }

    }
    @Test
    void testShit(){
        HttpResponse response = HttpRequest.get("http://localhost:8081/laser/1").execute();
        System.out.println(response.body());
    }
}
