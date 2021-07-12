package com.bellowschool.pleaseBuy.service;

import lombok.RequiredArgsConstructor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.Map;

@SpringBootTest
@RequiredArgsConstructor
public class PleaseBuyServiceImplTest {
    private final PleaseBuyService pleaseBuyService;

    @Test
    public void test() {
        Map<String, Object> params = new HashMap<>();
        params.put("goodstype", '0');
        params.put("goods", "치킨");
        params.put("goodscount", 2);
        params.put("goodsprice", 2);
        params.put("usernum", '0');
        params.put("option", "없음");
        pleaseBuyService.regPleaseBuy(params);
    }
}
