package com.bellowschool.checkin.service;

import com.bellowschool.vo.UserVo;

import java.util.List;
import java.util.Map;

public interface CheckService {
    int regCheckIn(Map<String, Object> params);
    List<UserVo> userattendanceList();
}
