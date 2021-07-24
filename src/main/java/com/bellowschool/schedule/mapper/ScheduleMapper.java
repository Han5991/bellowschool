package com.bellowschool.schedule.mapper;

import com.bellowschool.vo.ClassVo;
import com.bellowschool.vo.NotiVo;
import com.bellowschool.vo.ScheduleVo;
import com.bellowschool.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface ScheduleMapper {

    int regClass(Map<String, Object> params);

    List<ClassVo> classList();

    int regSchedule(Map<String, Object> params);

    List<ScheduleVo> scheduleList();

    int deleteSchedule(Map<String, Object> params);

    int updateSchedule(Map<String, Object> params);

    int scheduleCount(Map<String, Object> params);

    List<ScheduleVo> scheduleToday(Map<String, Object> params);

}
