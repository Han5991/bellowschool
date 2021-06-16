package com.bellowschool.checkin.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Mapper
@Repository
public interface CheckMapper {
    int regCheckIn(Map<String, Object> params);

}
