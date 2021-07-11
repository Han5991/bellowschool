package com.bellowschool.pleaseBuy.controller;

import com.bellowschool.pleaseBuy.service.PleaseBuyService;
import com.bellowschool.vo.PageRequestVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class PleaseBuyController {
    private final PleaseBuyService pleaseBuyService;

    @GetMapping("/PleaseBuy")
    public String PleaseBuy(PageRequestVo pageRequestVo, Model model) {
        Map<String, Object> params = new HashMap<>();
        params.put("page", pageRequestVo.getPage());
        params.put("size", pageRequestVo.getSize());
        log.info(params);
        model.addAttribute("result", pleaseBuyService.pleaseBuyList(params));
        return "pleaseBuy/pleaseBuy";
    }

    @PostMapping("/regPleaseBuy")
    @ResponseBody
    public int regPleaseBuy(@RequestBody Map<String, Object> params){
        return pleaseBuyService.regPleaseBuy(params);
    }
}
