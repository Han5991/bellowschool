package com.bellowschool.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Getter
public class UserVo {
    private int usernum;
    private String username;
    private String usertype;
    private String userclass;
    private String password;
    private String qrname;
    private String userdtime;
    private String addtendance;
}
