package com.bellowschool.checkin.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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
}
