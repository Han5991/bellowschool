package com.bellowschool.controller;

import com.bellowschool.service.testServiceImpl;
import com.bellowschool.vo.TestVo;
import com.bellowschool.vo.oracleTestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class TestController {

    private final testServiceImpl service;

    @GetMapping("/test")
    public String home(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Bamdule");
        map.put("date", LocalDateTime.now());
        map.put("date2", service.selectTest());
        model.addAttribute("data", map);

        return "home";
    }

    @GetMapping("/test2")
    public String test(){
        return "index";
    }

    @GetMapping("/test3")
    public String home3(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Bamdule");
        map.put("date", LocalDateTime.now());
        map.put("date2", service.selectTest());
        model.addAttribute("data", map);

        return "tables";
    }
}
