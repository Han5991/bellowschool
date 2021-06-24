package com.bellowschool.schedule.service;

import com.bellowschool.noti.mapper.NotiMapper;
import com.bellowschool.schedule.mapper.ScheduleMapper;
import com.bellowschool.vo.ClassVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class ScheduleServiceImpl implements ScheduleService{
    private final ScheduleMapper scheduleMapper;

    @Override
    public int regClass(Map<String, Object> params) {
        return scheduleMapper.regClass(params);
    }

    @Override
    public List<ClassVo> classList() {
        return scheduleMapper.classList();
    }
}
