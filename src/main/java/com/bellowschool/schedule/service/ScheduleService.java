package com.bellowschool.schedule.service;

import com.bellowschool.vo.ClassVo;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    int regClass(Map<String, Object> params);
    List<ClassVo> classList();
}
