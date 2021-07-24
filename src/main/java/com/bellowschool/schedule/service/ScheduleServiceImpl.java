package com.bellowschool.schedule.service;

import com.bellowschool.schedule.mapper.ScheduleMapper;
import com.bellowschool.vo.*;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Override
    @Transactional
    public int regClass(Map<String, Object> params) {
        return scheduleMapper.regClass(params);
    }

    @Override
    public List<ClassVo> classList() {
        return scheduleMapper.classList();
    }

    @Override
    @Transactional
    public int regSchedule(Map<String, Object> params) {
        return scheduleMapper.regSchedule(params);
    }

    @Override
    public List<ScheduleVo> scheduleList() {
        return scheduleMapper.scheduleList();
    }

    @Override
    @Transactional
    public int deleteSchedule(Map<String, Object> params) {
        return scheduleMapper.deleteSchedule(params);
    }

    @Override
    @Transactional
    public int updateSchedule(Map<String, Object> params) {
        return scheduleMapper.updateSchedule(params);
    }

    @Override
    public int scheduleCount() {
        Map<String, Object> params = new HashMap<>();
        if (params.get("dateStart") == null || params.get("dateStart") == "") {
            Calendar mon = Calendar.getInstance();
            mon.add(Calendar.MONTH, -2);
            String dateStart = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
            params.put("dateStart", dateStart);
        }

        if (params.get("dateEnd") == null || params.get("dateEnd") == "") {
            Calendar mon = Calendar.getInstance();
            String dateEnd = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
            params.put("dateEnd", dateEnd);
        }
        return scheduleMapper.scheduleCount(params);
    }

    @Override
    public List<ScheduleVo> scheduleToday() {
        Map<String, Object> params = new HashMap<>();
        Calendar mon = Calendar.getInstance();
        String dateEnd = new SimpleDateFormat("yyyy-MM-dd").format(mon.getTime());
        params.put("dateStart", dateEnd + "%");
        return scheduleMapper.scheduleToday(params);
    }

}
