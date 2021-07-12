package com.bellowschool.pleaseBuy.service;

import com.bellowschool.pleaseBuy.mapper.PleaseBuyMapper;
import com.bellowschool.vo.PageRequestVo;
import com.bellowschool.vo.PleaseBuyVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.util.HashMap;
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
    public List<PleaseBuyVo> pleaseBuyList(PageRequestVo pageRequestVo) {
        Map<String, Object> params = new HashMap<>();
        params.put("start", (1 + pageRequestVo.getSize() * (pageRequestVo.getPage() - 1)));
        params.put("end", (pageRequestVo.getPage() * pageRequestVo.getSize()));
        return pleaseBuyMapper.pleaseBuyList(params);
    }
}
