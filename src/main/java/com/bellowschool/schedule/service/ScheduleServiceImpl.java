package com.bellowschool.schedule.service;

import com.bellowschool.schedule.mapper.ScheduleMapper;
import com.bellowschool.vo.ClassVo;
import com.bellowschool.vo.ScheduleVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService {
    private final ScheduleMapper scheduleMapper;

    @Override
    public int regClass(Map<String, Object> params) {
        return scheduleMapper.regClass(params);
    }

    @Override
    public List<ClassVo> classList() {
        return scheduleMapper.classList();
    }

    @Override
    public int regSchedule(Map<String, Object> params) {
        log.info(params);
        return scheduleMapper.regSchedule(params);
    }

    @Override
    public List<ScheduleVo> scheduleList() {
        return scheduleMapper.scheduleList();
    }

    @Override
    public int deleteSchedule(Map<String, Object> params) {
        return scheduleMapper.deleteSchedule(params);
    }

    @Override
    public int updateSchedule(Map<String, Object> params) {
        return scheduleMapper.updateSchedule(params);
    }
}
