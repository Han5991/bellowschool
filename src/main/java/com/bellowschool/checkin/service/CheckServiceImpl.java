package com.bellowschool.checkin.service;

import com.bellowschool.checkin.mapper.CheckMapper;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckServiceImpl implements CheckService {
    private final CheckMapper checkMapper;

    @Override
    public int regCheckIn(Map<String, Object> params) {
        String nowDate = new SimpleDateFormat("yyyyMMdd").format(new Date(System.currentTimeMillis())) + "%";
        params.put("checkTime", nowDate);
        if (checkMapper.duplicateCheck(params) < 1) {
            return checkMapper.regCheckIn(params);
        }
        return 0;
    }

    @Override
    public List<UserVo> userattendanceList() {
        return checkMapper.userattendanceList();
    }
}
