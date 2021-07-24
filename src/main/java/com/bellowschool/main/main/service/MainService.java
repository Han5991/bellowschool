package com.bellowschool.main.main.service;

import com.bellowschool.vo.ScheduleVo;

import java.util.List;
import java.util.Map;

public interface MainService {
    double attendance ();

    int requestPleaseBuy();

    int userCount();

    int scheduleCount();

    List<ScheduleVo> scheduleToday();

}
