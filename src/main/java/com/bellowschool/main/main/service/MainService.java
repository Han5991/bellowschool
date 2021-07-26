package com.bellowschool.main.main.service;

import com.bellowschool.vo.ScheduleVo;
import com.bellowschool.vo.UserVo;

import java.util.List;

public interface MainService {
    double attendance ();

    int requestPleaseBuy();

    int userCount();

    int scheduleCount();

    List<ScheduleVo> scheduleToday();

    List<Integer> monthlyAttendanceList();

    List<Integer> userClassCount();
}
