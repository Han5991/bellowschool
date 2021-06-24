package com.bellowschool.schedule.controller;

import com.bellowschool.schedule.service.ScheduleService;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public String schedule(){
        return "schedule/scheduleMF";
    }

    @GetMapping("/scheduleReg2")
    public String schedule2Reg(Model model){
        model.addAttribute("classList",scheduleService.classList());
        return "schedule/scheduleReg2";
    }

    @GetMapping("/scheduleReg")
    public String schedule2Reg2(){
        return "schedule/scheduleReg3";
    }

    @PostMapping("/regclass")
    @ResponseBody
    public int createnoti(@RequestBody Map<String, Object> params) {
        return scheduleService.regClass(params);
    }
}
