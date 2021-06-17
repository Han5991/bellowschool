package com.bellowschool.checkin.service;

import com.bellowschool.checkin.mapper.CheckMapper;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;

@Log4j2
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
    public List<UserVo> userattendanceList(Map<String, Object> params) {
        if (params.get("dateStart") == null) {
            Calendar mon = Calendar.getInstance();
            mon.add(Calendar.MONTH, -1);
            String dateStart = new SimpleDateFormat("yyyyMM").format(mon.getTime());
            params.put("dateStart", dateStart);
        }
        if (params.get("dateEnd") == null) {
            Calendar mon = Calendar.getInstance();
            mon.add(Calendar.MONTH, +1);
            String dateEnd = new SimpleDateFormat("yyyyMM").format(mon.getTime());
            params.put("dateEnd", dateEnd);
        }
        return checkMapper.userattendanceList(params);
    }
}
