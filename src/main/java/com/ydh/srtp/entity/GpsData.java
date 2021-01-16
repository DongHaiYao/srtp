package com.ydh.srtp.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author：DongHai
 * @Date：2021/1/13
 * @Description: modify: 修改时间
 *               location: 位置信息
 **/
@Data
public class GpsData {
    private int id;
    private String location;
    private Date modify;
}
