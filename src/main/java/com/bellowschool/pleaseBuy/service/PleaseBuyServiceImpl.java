package com.bellowschool.pleaseBuy.service;

import com.bellowschool.common.page.PageResultVo;
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

    @Override
    public int regPleaseBuy(Map<String, Object> params) {
        return pleaseBuyMapper.regPleaseBuy(params);
    }

    @Override
    public PageResultVo pleaseBuyList(PageRequestVo pageRequestVo) {
        List<PleaseBuyVo> result = pleaseBuyMapper.pleaseBuyList(pageRequestVo);
        return new PageResultVo(pageRequestVo, result, (result.size() != 0) ? result.get(0).getTotalcount() : 0);
    }
}
