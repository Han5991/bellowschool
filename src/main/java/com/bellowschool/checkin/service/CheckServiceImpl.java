package com.bellowschool.checkin.service;

import com.bellowschool.checkin.mapper.CheckMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {
    private final CheckMapper checkMapper;
    @Override
    public int regCheckIn(Map<String, Object> params) {
        return checkMapper.regCheckIn(params);
    }
}
