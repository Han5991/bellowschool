package com.bellowschool.noti.mapper;

import com.bellowschool.vo.notiVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface notiMapper {
    List<notiVo> notiPagedList();
}
