package com.bellowschool.noti.mapper;

import com.bellowschool.vo.NotiVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface NotiMapper {
    List<NotiVo> notiPagedList();

    int regNoti(Map<String, Object> params);

    int updateNoti(Map<String, Object> params);

    NotiVo notiReadPage(int sno);

    int notiDetele(Map<String, Object> params);

    void updateNotiHitcnt(int sno);

}
