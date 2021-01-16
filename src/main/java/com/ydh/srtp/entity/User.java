package com.ydh.srtp.entity;

import lombok.Data;

import java.sql.Date;

/**
 * @Author：DongHai
 * @Date：2021/1/15
 * @Description:
 **/
@Data
public class User {
    private String id;
    private String username;
    private String password;
    private Date createTime;
    private String phoneNum;
}
