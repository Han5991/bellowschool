package com.bellowschool.inventoryBook.controller;

import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


@Log4j2
@Controller
@RequiredArgsConstructor
public class inventoryBookController {
    @GetMapping("/inventoryBook")
    public String inventoryBook(@RequestParam Map<String, Object> params) {
        log.info(params);
        return "inventoryBook/inventoryBook";
    }
}
