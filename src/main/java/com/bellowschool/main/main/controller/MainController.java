package com.bellowschool.main.main.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MainController {

    @GetMapping("/bellowschool")
    public String mainindex(){
        return "index";
    }

    @GetMapping("/test4")
    public String test2(){
        return "charts";
    }

}
