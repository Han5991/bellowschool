package com.bellowschool.schedule.controller;

import com.bellowschool.schedule.service.ScheduleService;
import com.bellowschool.vo.ScheduleVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class ScheduleController {
    private final ScheduleService scheduleService;

    @GetMapping("/schedule")
    public String schedule2Reg(Model model) {
        model.addAttribute("classList", scheduleService.classList());
        return "schedule/schedule";
    }

    @GetMapping("/classReg")
    public String schedule2Reg2() {
        return "schedule/classReg";
    }

    @PostMapping("/regclass")
    @ResponseBody
    public int createnoti(@RequestBody Map<String, Object> params) {
        return scheduleService.regClass(params);
    }

    @PostMapping("/regschedule")
    @ResponseBody
    public int regschedule(@RequestBody Map<String, Object> params) {
        return scheduleService.regSchedule(params);
    }

    @PostMapping("/scheduleList")
    @ResponseBody
    public List<ScheduleVo> scheduleList() {
        return scheduleService.scheduleList();
    }

    @PostMapping("/deleteschedule")
    @ResponseBody
    public int detelenoti(@RequestBody Map<String, Object> params) {
        return scheduleService.deleteSchedule(params);
    }

    @PostMapping("/updateschedule")
    @ResponseBody
    public int updateschedule(@RequestBody Map<String, Object> params) {
        return scheduleService.updateSchedule(params);
    }
}
