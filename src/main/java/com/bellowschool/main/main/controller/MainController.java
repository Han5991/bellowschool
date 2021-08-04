package com.bellowschool.main.main.controller;

import com.bellowschool.main.main.service.MainServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Log4j2
@Controller
@RequiredArgsConstructor
public class MainController {
    private final MainServiceImpl mainService;

    @GetMapping("/bellowschool")
    public String mainIndex(Model model) {
        model.addAttribute("attendance", mainService.attendance());
        model.addAttribute("requestPleaseBuy", mainService.requestPleaseBuy());
        model.addAttribute("userCount", mainService.userCount());
        model.addAttribute("scheduleCount", mainService.scheduleCount());
        model.addAttribute("scheduleToday", mainService.scheduleToday());
        return "index";
    }

    @GetMapping("/")
    public String login (){
        return "longinout/login";
    }


    @PostMapping("/monthlyAttendanceList")
    @ResponseBody
    public List<Integer> userAttendanceList() {
        return mainService.monthlyAttendanceList();
    }

    @PostMapping("/userClassCount")
    @ResponseBody
    public List<Integer> userClassCount() {
        return mainService.userClassCount();
    }
}
