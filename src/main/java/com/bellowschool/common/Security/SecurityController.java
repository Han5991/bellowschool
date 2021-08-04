package com.bellowschool.common.Security;

import com.bellowschool.common.StringSecurity.ShaEncoder;
import com.bellowschool.user.service.UserService;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.PostMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;

@Log4j2
@Controller
@RequiredArgsConstructor
public class SecurityController {
    private final UserService userService;
    private final ShaEncoder shaEncoder;

    @PostMapping("/signup")
    public String signup(HttpServletRequest request, HttpSession httpSession, HttpServletResponse response) throws IOException, NoSuchAlgorithmException {
        UserVo user = userService.findByAccount(request.getParameter("userName"));
        String enPassword = shaEncoder.Sha256Encoder(request.getParameter("password"));
        response.setContentType("text/html; charset=UTF-8");
        PrintWriter out = response.getWriter();

        if (!ObjectUtils.isEmpty(user)) {
            if (user.getPassword().equals(enPassword)) {
                httpSession.setAttribute("user", user);
                return "redirect:/bellowschool";
            } else {
                out.println("<script>alert('아이디/비밀번호가 틀렸습니다.'); location.href='/';</script>");
                out.flush();
            }
        } else {
            out.println("<script>alert('계정이 존재하지 않습니다.'); location.href='/';</script>");
            out.flush();
        }

        return "redirect:/";
    }

    @PostMapping("/logout")
    public String logout(HttpSession httpSession) {
        httpSession.invalidate();
        return "redirect:/";
    }

}
