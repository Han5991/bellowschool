package com.bellowschool.pleaseBuy.service;

import com.bellowschool.common.page.PageResultVo;
import com.bellowschool.inventoryBook.mapper.InventoryBookMapper;
import com.bellowschool.pleaseBuy.mapper.PleaseBuyMapper;
import com.bellowschool.common.page.PageRequestVo;
import com.bellowschool.vo.PleaseBuyVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class PleaseBuyServiceImpl implements PleaseBuyService {
    private final PleaseBuyMapper pleaseBuyMapper;
    private final InventoryBookMapper inventoryBookMapper;

    @Override
    public int regPleaseBuy(Map<String, Object> params) {
        return pleaseBuyMapper.regPleaseBuy(params);
    }

    @Override
    public PageResultVo pleaseBuyList(PageRequestVo pageRequestVo) {
        List<PleaseBuyVo> result = pleaseBuyMapper.pleaseBuyList(pageRequestVo);
        return new PageResultVo(pageRequestVo, result, (result.size() != 0) ? result.get(0).getTotalcount() : 0);
    }

    @Override
    public int deletePleaseBuy(Map<String, Object> params) {
        return pleaseBuyMapper.deletePleaseBuy(params);
    }

    @Override
    public int updatePleaseBuy(Map<String, Object> params) {
        if (params.get("status").equals("3")) {
            inventoryBookMapper.regInventoryBook(params);
        }
        return pleaseBuyMapper.updatePleaseBuy(params);
    }

    @Override
    public int requestPleaseBuy() {
        return pleaseBuyMapper.requestPleaseBuy();
    }


}
