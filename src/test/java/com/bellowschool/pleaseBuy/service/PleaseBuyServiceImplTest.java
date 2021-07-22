package com.bellowschool.pleaseBuy.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
public class PleaseBuyServiceImplTest {

    @Autowired
    private PleaseBuyServiceImpl pleaseBuyService;

    @Test
    public void test() {
        Map<String, Object> params = new HashMap<>();
        params.put("type", '0');
        params.put("name", "치킨");
        params.put("amount", 2);
        params.put("price", 2);
        params.put("usernum", '0');
        params.put("option", "없음");
        pleaseBuyService.regPleaseBuy(params);
    }
}
