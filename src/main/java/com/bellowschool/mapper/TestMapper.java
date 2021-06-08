package com.bellowschool.mapper;

import com.bellowschool.vo.oracleTestVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;
import java.util.List;

@Repository
@Mapper
public interface TestMapper {
    List<oracleTestVo> selectTest();
}
