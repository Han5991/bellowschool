package com.bellowschool.noti.service;

import com.bellowschool.vo.notiVo;

import java.util.List;
import java.util.Map;

public interface notiService {
    List<notiVo> notiPagedList();

    int regNoti(Map<String, Object> params);
    notiVo notiReadPage(int sno);
    int notiDetele(Map<String, Object> params);
    int updateNoti(Map<String, Object> params);
}
