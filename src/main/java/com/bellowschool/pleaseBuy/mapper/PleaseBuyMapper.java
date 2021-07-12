package com.bellowschool.pleaseBuy.mapper;

import com.bellowschool.common.page.PageRequestVo;
import com.bellowschool.vo.PleaseBuyVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface PleaseBuyMapper {
    int regPleaseBuy(Map<String, Object> params);
    List<PleaseBuyVo> pleaseBuyList(PageRequestVo pageRequestVo);
}
