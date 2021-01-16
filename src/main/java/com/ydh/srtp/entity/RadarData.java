package com.ydh.srtp.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description:
 **/
@Data
public class RadarData {
    private int id;
    private byte[] radarImg;
    private Date modify;
}
