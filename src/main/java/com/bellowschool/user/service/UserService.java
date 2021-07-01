package com.bellowschool.user.service;

import com.bellowschool.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface UserService {
    int regUser(Map<String, Object> params);

    List<UserVo> userList();

    int userDetele(Map<String, Object> params);

    UserVo userRead(int usernum);

    int updateUser(Map<String, Object> params);
}
