package com.bellowschool.checkin.service;

import com.bellowschool.checkin.mapper.CheckMapper;
import com.bellowschool.schedule.service.ScheduleService;
import com.bellowschool.vo.ClassVo;
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
    private final ScheduleService scheduleService;

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
    public List<UserVo> userAttendanceList(Map<String, Object> params) {
        if (params.get("dateStart") == null || params.get("dateStart") == "") {
            Calendar mon = Calendar.getInstance();
            mon.add(Calendar.MONTH, -2);
            String dateStart = new SimpleDateFormat("yyyyMMdd").format(mon.getTime());
            params.put("dateStart", dateStart);
        }

        if (params.get("dateEnd") == null || params.get("dateEnd") == "") {
            Calendar mon = Calendar.getInstance();
            String dateEnd = new SimpleDateFormat("yyyyMMdd").format(mon.getTime());
            params.put("dateEnd", dateEnd);
        }

        List<ClassVo> classList = scheduleService.classList();

        for (int i = 0; i < classList.size(); i++) {
            params.put("class", classList.get(i).getClasstype());
            params.put("class" + i, checkMapper.scheduleClassCount(params));
        }

        return checkMapper.userAttendanceList(params);
    }
}
