package com.bellowschool.user.controller;

import com.bellowschool.user.service.UserServiceImpl;
import com.bellowschool.vo.UserVo;
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
public class UserController {
    private final UserServiceImpl userService;

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
    public List<UserVo> notiList() {
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
        return userService.userDelete(params);
    }

    @GetMapping("/userRead")
    public String userRead(@RequestParam int usernum, Model model) {
        model.addAttribute("user", userService.userRead(usernum));
        return "user/userRead";
    }

    @GetMapping("/userUpdateWin")
    public String userUpdate(@RequestParam(value = "usernum", required = false) int usernum, Model model) {
        model.addAttribute("user", userService.userRead(usernum));
        return "user/userUpdate";
    }

    @PostMapping("/userUpdate")
    @ResponseBody
    public int userUpdate(@RequestBody Map<String, Object> params) {
        return userService.updateUser(params);
    }
}
