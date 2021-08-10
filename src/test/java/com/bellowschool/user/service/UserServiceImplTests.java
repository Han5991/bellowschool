package com.bellowschool.user.service;

import com.bellowschool.vo.UserVo;
import lombok.extern.log4j.Log4j2;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootTest
@Log4j2
public class UserServiceImplTests {
    @Autowired
    private UserServiceImpl userService;

    @Test
    public void userTest() {
    }
}
