package com.bellowschool.pleaseBuy.service;

import com.bellowschool.common.page.PageResultVo;
import com.bellowschool.vo.PageRequestVo;
import java.util.Map;

public interface PleaseBuyService {
    int regPleaseBuy(Map<String, Object> params);
    PageResultVo pleaseBuyList(PageRequestVo pageRequestVo);
}
