package com.bellowschool.pleaseBuy.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Log4j2
@Controller
@RequiredArgsConstructor
public class PleaseBuyController {

    @GetMapping("/PleaseBuy")
    public String noti() {
        return "pleaseBuy/pleaseBuy";
    }
}
