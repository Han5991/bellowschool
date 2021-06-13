package com.bellowschool.user.service;

import com.bellowschool.vo.userVo;

import java.util.List;
import java.util.Map;

public interface userService {
    int regUser(Map<String, Object> params);
    List<userVo> userList();
    int userDetele(Map<String, Object> params);
    userVo userRead(int usernum);
}
