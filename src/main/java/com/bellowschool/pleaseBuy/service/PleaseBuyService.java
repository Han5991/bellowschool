package com.bellowschool.pleaseBuy.service;

import com.bellowschool.common.page.PageRequestVo;
import com.bellowschool.common.page.PageResultVo;

import java.util.Map;

public interface PleaseBuyService {
    int regPleaseBuy(Map<String, Object> params);

    PageResultVo pleaseBuyList(PageRequestVo pageRequestVo);

    int deletePleaseBuy(Map<String, Object> params);

    int updatePleaseBuy(Map<String, Object> params);

    int requestPleaseBuy();
}
