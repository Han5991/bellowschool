package com.bellowschool.common.Security;

import com.bellowschool.vo.UserVo;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.lang.Nullable;
import org.springframework.stereotype.Component;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.Enumeration;

@Log4j2
@Component
public class LoginInterceptor implements HandlerInterceptor{

    //컨트롤러에 도착전 호출 되는 메서드
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("Request URL : " + request.getRequestURL().toString());
        Enumeration<String> paramKeys = request.getParameterNames();
        while (paramKeys.hasMoreElements()) {
            String key = paramKeys.nextElement();
            log.info("key (" + key + ") : " + request.getParameter(key));
        }
        HttpSession httpSession = request.getSession();
        UserVo user = (UserVo) httpSession.getAttribute("user");
        if (ObjectUtils.isEmpty(user)) {
            response.sendRedirect("/");
            return false;
        } else {
            httpSession.setMaxInactiveInterval(24 * 60 * 60);
            return true;
        }
    }

    //view가 그려지기 전에 호출되는 메서드
    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
    }

    //view가 그려지고 난 뒤 호출 되는 매서드드
    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
    }
}
