package com.bellowschool.checkin.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@Log4j2
@Controller
@RequiredArgsConstructor
public class CheckController {

    @GetMapping("/qrcheck")
    public String createnoti(@RequestParam(value = "name") String name, @RequestParam(value = "id") int id) {
        log.info(name + id);
        return "redirect:https://hounjini.cafe24.com/sangwook/index.html";
    }

    @GetMapping("/qrtest")
    public String qrcode (){
        log.info("qrtest");
        return "checkin/qrcheckin";
    }
}
