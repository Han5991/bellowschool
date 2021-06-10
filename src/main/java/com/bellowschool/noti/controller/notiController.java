package com.bellowschool.noti.controller;

import com.bellowschool.noti.service.notiServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class notiController {

    private final notiServiceImpl notiService;

    @GetMapping("/noti")
    public String home3(Model model) {

        Map<String, Object> map = new HashMap<>();
        map.put("date2", notiService.notiPagedList());
        model.addAttribute("data", map);

        return "noti/noti";
    }
}
