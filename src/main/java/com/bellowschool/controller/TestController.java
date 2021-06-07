package com.bellowschool.controller;

import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Controller
@Log4j2
public class TestController {

    @GetMapping("/test")
    public String home(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("name", "Bamdule");
        map.put("date", LocalDateTime.now());
        model.addAttribute("data", map);

        return "home";
    }
}
