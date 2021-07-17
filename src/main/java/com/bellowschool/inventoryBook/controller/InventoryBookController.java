package com.bellowschool.inventoryBook.controller;

import com.bellowschool.inventoryBook.service.InventoryBookServiceImpl;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.Map;


@Log4j2
@Controller
@RequiredArgsConstructor
public class InventoryBookController {
    private final InventoryBookServiceImpl inventoryBookService;

    @GetMapping("/inventoryBook")
    public String inventoryBook() {
        return "inventoryBook/inventoryBook";
    }

    @PostMapping("/inventoryBookList")
    @ResponseBody
    public HashMap<String, Object> regPleaseBuy() {
        HashMap<String, Object> result = new HashMap<>();
        result.put("inventoryList", inventoryBookService.inventoryList());
        result.put("inventoryBookList", inventoryBookService.inventoryBookList());
        return result;
    }

    @PostMapping("/regInventoryBook")
    @ResponseBody
    public int regPleaseBuy(@RequestBody Map<String, Object> params) {
        return inventoryBookService.regInventoryBook(params);
    }

    @PostMapping("/deleteInventoryBook")
    @ResponseBody
    public int deletePleaseBuy(@RequestBody Map<String, Object> params) {
        return inventoryBookService.deleteInventoryBook(params);
    }

    @PostMapping("/updateInventoryBook")
    @ResponseBody
    public int updatePleaseBuy(@RequestBody Map<String, Object> params) {
        return inventoryBookService.updateInventoryBook(params);
    }
}

