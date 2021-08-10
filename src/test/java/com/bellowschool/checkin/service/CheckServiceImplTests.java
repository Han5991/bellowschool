package com.bellowschool.checkin.service;

import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@SpringBootTest
public class CheckServiceImplTests {

    @Autowired
    private CheckServiceImpl checkService;

    @Test
    public void test() {
        for (int a : checkService.monthlyAttendanceList()) {
            System.out.println(a);
        }
    }

    @Test
    public void userTest() {
        Map<String, Object> params = new HashMap<>();
        params.put("dateStart", "20210701");
        params.put("dateEnd", "20210810");
        params.put("userNum", "4");
        checkService.findUserCheckTime(params);
    }
}
