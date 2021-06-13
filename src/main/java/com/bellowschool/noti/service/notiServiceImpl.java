package com.bellowschool.noti.service;

import com.bellowschool.noti.mapper.notiMapper;
import com.bellowschool.vo.notiVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class notiServiceImpl implements notiService {

    private final notiMapper notiMapper;

    @Override
    public List<notiVo> notiPagedList() {
        return notiMapper.notiPagedList();
    }

    @Override
    public int regNoti(Map<String, Object> params) {
        return notiMapper.regNoti(params);
    }

    @Override
    public notiVo notiReadPage(int sno) {
        notiMapper.updateNotiHitcnt(sno);
        return notiMapper.notiReadPage(sno);
    }

    @Override
    public int notiDetele(Map<String, Object> params) {
        return notiMapper.notiDetele(params);
    }

    @Override
    public int updateNoti(Map<String, Object> params) {
        return notiMapper.updateNoti(params);
    }

}
