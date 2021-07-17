package com.bellowschool.inventoryBook.service;

import com.bellowschool.vo.InventoryBookVo;

import java.util.List;
import java.util.Map;

public interface InventoryBookService {
    List<InventoryBookVo> inventoryList();

    List<InventoryBookVo> inventoryBookList();

    int regInventoryBook(Map<String, Object> params);

    int deleteInventoryBook(Map<String, Object> params);

    int updateInventoryBook(Map<String, Object> params);

}
