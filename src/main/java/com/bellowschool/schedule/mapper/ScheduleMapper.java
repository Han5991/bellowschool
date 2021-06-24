package com.bellowschool.schedule.mapper;

import com.bellowschool.vo.ClassVo;
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
}
