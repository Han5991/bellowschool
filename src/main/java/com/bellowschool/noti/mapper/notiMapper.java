package com.bellowschool.noti.mapper;

import com.bellowschool.vo.notiVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface notiMapper {
    List<notiVo> notiPagedList();

    int regNoti(Map<String, Object> params);

    int updateNoti(Map<String, Object> params);

    notiVo notiReadPage(int sno);

    int notiDetele(Map<String, Object> params);

}
