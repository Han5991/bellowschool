package com.bellowschool.noti.service;

import com.bellowschool.noti.mapper.NotiMapper;
import com.bellowschool.vo.NotiVo;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class NotiServiceImpl implements NotiService {
    private final NotiMapper notiMapper;

    @Override
    public List<NotiVo> notiPagedList() {
        return notiMapper.notiPagedList();
    }

    @Override
    @Transactional
    public int regNoti(Map<String, Object> params) {
        return notiMapper.regNoti(params);
    }

    @Override
    @Transactional
    public NotiVo notiReadPage(int sno) {
        notiMapper.updateNotiHitcnt(sno);
        return notiMapper.notiReadPage(sno);
    }

    @Override
    @Transactional
    public int notiDetele(Map<String, Object> params) {
        return notiMapper.notiDetele(params);
    }

    @Override
    @Transactional
    public int updateNoti(Map<String, Object> params) {
        return notiMapper.updateNoti(params);
    }

}
