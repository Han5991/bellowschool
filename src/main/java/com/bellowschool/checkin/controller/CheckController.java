package com.bellowschool.checkin.controller;

import com.bellowschool.checkin.service.CheckService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.HashMap;
import java.util.Map;


@Log4j2
@Controller
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;

    @GetMapping("/qrcheck")
    public String createnoti(@RequestParam(value = "name") String name, @RequestParam(value = "id") int id) throws IOException {
        Map<String, Object> params = new HashMap<String, Object>();
        params.put("userNum", id);
        params.put("userName", URLDecoder.decode(name, "UTF-8"));
        checkService.regCheckIn(params);
        return "redirect:https://hounjini.cafe24.com/sangwook/index.html";
    }

    @GetMapping("/qrtest")
    public String qrcode() {
        log.info("qrtest");
        return "checkin/qrcheckin";
    }
}
