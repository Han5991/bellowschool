package com.bellowschool.main.main.service;

import com.bellowschool.checkin.service.CheckService;
import com.bellowschool.pleaseBuy.service.PleaseBuyService;
import com.bellowschool.schedule.service.ScheduleService;
import com.bellowschool.user.service.UserService;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class MainServiceImpl implements MainService {
    private final CheckService checkService;
    private final PleaseBuyService pleaseBuyService;
    private final UserService userService;
    private final ScheduleService scheduleService;

    @Override
    public double attendance() {
        Map<String, Object> params = new HashMap<>();
        List<UserVo> result = checkService.userAttendanceList(params);
        double attendance = 0;
        for (UserVo user : result) {
            attendance += Integer.parseInt(user.getAddtendance());
        }
        return Math.ceil((attendance / result.size()) * 100.0) / 100.0;
    }

    @Override
    public int requestPleaseBuy() {
        return pleaseBuyService.requestPleaseBuy();
    }

    @Override
    public int userCount() {
        return userService.userCount();
    }

    @Override
    public int scheduleCount() {
        return scheduleService.scheduleCount();
    }
}
