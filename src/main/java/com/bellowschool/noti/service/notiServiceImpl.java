package com.bellowschool.noti.service;

import com.bellowschool.noti.mapper.notiMapper;
import com.bellowschool.vo.notiVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class notiServiceImpl implements notiService{

    private final notiMapper notiMapper;

    @Override
    public List<notiVo> notiPagedList() {
        return notiMapper.notiPagedList();
    }

    @Override
    public int regNoti(Map<String, Object> params) {
        return notiMapper.regNoti(params);
    }

}
