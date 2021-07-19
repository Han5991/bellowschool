package com.bellowschool.user.service;

import com.bellowschool.vo.UserVo;

import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import java.util.Map;

public interface UserService {
    int regUser(Map<String, Object> params) throws UnsupportedEncodingException, NoSuchAlgorithmException;

    List<UserVo> userList();

    int userDelete(Map<String, Object> params);

    UserVo userRead(int usernum);

    int updateUser(Map<String, Object> params);

    int userCount();
}
