package com.bellowschool.schedule.service;

import com.bellowschool.vo.ClassVo;
import com.bellowschool.vo.ScheduleVo;

import java.util.List;
import java.util.Map;

public interface ScheduleService {
    int regClass(Map<String, Object> params);

    List<ClassVo> classList();

    int regSchedule(Map<String, Object> params);

    List<ScheduleVo> scheduleList();

    int deleteSchedule(Map<String, Object> params);

    int updateSchedule(Map<String, Object> params);

    int scheduleCount();

    List<ScheduleVo> scheduleToday();

}
