package com.bellowschool.inventoryBook.service;

import com.bellowschool.inventoryBook.mapper.InventoryBookMapper;
import com.bellowschool.vo.InventoryBookVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class InventoryBookServiceImpl implements InventoryBookService{
    private final InventoryBookMapper inventoryBookMapper;

    @Override
    public List<InventoryBookVo> inventoryList() {
        return inventoryBookMapper.inventoryList();
    }

    @Override
    public List<InventoryBookVo> inventoryBookList() {
        return inventoryBookMapper.inventoryBookList();
    }

    @Override
    public int regInventoryBook(Map<String, Object> params) {
        return inventoryBookMapper.regInventoryBook(params);
    }
}
