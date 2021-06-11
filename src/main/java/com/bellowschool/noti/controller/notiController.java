package com.bellowschool.noti.controller;

import com.bellowschool.noti.service.notiServiceImpl;
import com.bellowschool.vo.notiVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class notiController {

    private final notiServiceImpl notiService;

    @GetMapping("/noti")
    public String noti(Model model) {
        return "noti/notiPagedListFM";
    }

    @PostMapping("/notiList")
    @ResponseBody
    public List<notiVo> notiList() {
        return notiService.notiPagedList();
    }

    @GetMapping("/notiRegPageWin")
    public String regnoti() {
        return "noti/notiRegPageWin.html";
    }

    @PostMapping("/createnoti")
    @ResponseBody
    public int createnoti(@RequestBody Map<String, Object> params) {
        return notiService.regNoti(params);
    }
}
