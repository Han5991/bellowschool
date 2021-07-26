package com.bellowschool.common.controller;

import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.http.HttpStatus;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

public class ErrorErrorController implements ErrorController {

    @RequestMapping(value = "/error")
    public String handleError(HttpServletRequest request, Model model) {
        System.out.println("error");
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        if (status != null) {
            int statusCode = Integer.valueOf(status.toString());
            model.addAttribute("error" , statusCode);
            return "error/error";
        }
        return "error";
    }

}
