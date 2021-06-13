package com.bellowschool.user.controller;

import com.bellowschool.noti.service.notiService;
import com.bellowschool.user.service.userServiceImpl;
import com.bellowschool.vo.notiVo;
import com.bellowschool.vo.userVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.util.List;
import java.util.Map;

@Log4j2
@Controller
@RequiredArgsConstructor
public class userController {

    private final userServiceImpl userService;

    @GetMapping("/user")
    public String user() {
        return "user/userMF";
    }

    @GetMapping("/userListWin")
    public String userlist() {
        return "user/userList";
    }

    @PostMapping("/userList")
    @ResponseBody
    public List<userVo> notiList() {
        return userService.userList();
    }

    @PostMapping("/reguser")
    @ResponseBody
    public int createnoti(@RequestBody Map<String, Object> params) {
        return userService.regUser(params);
    }

    @PostMapping("/deteleuser")
    @ResponseBody
    public int detelenoti(@RequestBody Map<String, Object> params) {
        return userService.userDetele(params);
    }

    @GetMapping("/userRead")
    public String userRead(@RequestParam int usernum, Model model) {
        model.addAttribute("user", userService.userRead(usernum));
        return "user/userRead";
    }
}
