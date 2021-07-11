package com.bellowschool.pleaseBuy.service;

import com.bellowschool.vo.PleaseBuyVo;

import java.util.List;
import java.util.Map;

public interface PleaseBuyService {
    int regPleaseBuy(Map<String, Object> params);
    List<PleaseBuyVo> pleaseBuyList(Map<String, Object> params);

}
