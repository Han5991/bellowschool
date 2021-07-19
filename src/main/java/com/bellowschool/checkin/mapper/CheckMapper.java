package com.bellowschool.checkin.mapper;

import com.bellowschool.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface CheckMapper {
    int regCheckIn(Map<String, Object> params);

    List<UserVo> userAttendanceList(Map<String, Object> params);

    int duplicateCheck(Map<String, Object> params);

    int scheduleClassCount(Map<String, Object> params);
}
