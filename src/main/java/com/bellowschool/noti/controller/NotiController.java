package com.bellowschool.noti.controller;

import com.bellowschool.noti.service.NotiService;
import com.bellowschool.vo.NotiVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class NotiController {

    private final NotiService notiService;

    @GetMapping("/noti")
    public String noti() {
        return "noti/notiPagedListFM";
    }

    @PostMapping("/notiList")
    @ResponseBody
    public List<NotiVo> notiList() {
        return notiService.notiPagedList();
    }

    @GetMapping("/notiRegPageWin")
    public String regnoti() {
        return "noti/notiRegPageWin";
    }

    @PostMapping("/createnoti")
    @ResponseBody
    public int createnoti(@RequestBody Map<String, Object> params) {
        return notiService.regNoti(params);
    }

    @PostMapping("/detelenoti")
    @ResponseBody
    public int detelenoti(@RequestBody Map<String, Object> params) {
        return notiService.notiDetele(params);
    }

    @GetMapping("/notiRead")
    public String readNotiPage(@RequestParam int sno, Model model) {
        model.addAttribute("noti", notiService.notiReadPage(sno));
        return "noti/notiReadPageWin";
    }

    @GetMapping("/updatenoti")
    public String updatenoti(@RequestParam int sno, Model model) {
        model.addAttribute("noti", notiService.notiReadPage(sno));
        return "noti/notiUpdatePageWin";
    }

    @PostMapping("/updateNotiPage")
    @ResponseBody
    public int updateNotiPage(@RequestBody Map<String, Object> params) {
        return notiService.updateNoti(params);
    }
}
