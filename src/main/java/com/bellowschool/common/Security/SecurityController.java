package com.bellowschool.common.Security;

import com.bellowschool.common.StringSecurity.ShaEncoder;
import com.bellowschool.user.service.UserService;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SecurityController {
    private final UserService userService;
    private final ShaEncoder shaEncoder;

    @PostMapping("/signup")
    public String signup(HttpServletRequest request, HttpSession httpSession) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        UserVo user = userService.findByAccount(request.getParameter("userName"));
        String enPassword = shaEncoder.Sha256Encoder(request.getParameter("password"));
        if (user != null) {
            if (user.getPassword().equals(enPassword)) {
                httpSession.setAttribute("user", user);
                return "redirect:/bellowschool";
            }
        }
        return "redirect:/";
    }

    @GetMapping("/logout")
    public String logout (HttpSession httpSession) {
        httpSession.setMaxInactiveInterval(0);
        httpSession.invalidate();
        return "redirect:/";
    }

}
