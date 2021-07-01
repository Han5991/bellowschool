package com.bellowschool.noti.service;

import com.bellowschool.vo.NotiVo;

import java.util.List;
import java.util.Map;

public interface NotiService {
    List<NotiVo> notiPagedList();

    int regNoti(Map<String, Object> params);

    NotiVo notiReadPage(int sno);

    int notiDetele(Map<String, Object> params);

    int updateNoti(Map<String, Object> params);

}
