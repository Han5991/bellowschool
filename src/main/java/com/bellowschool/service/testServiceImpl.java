package com.bellowschool.service;

import com.bellowschool.mapper.TestMapper;
import com.bellowschool.vo.oracleTestVo;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class testServiceImpl implements testService{
    private final TestMapper mapper;

    @Override
    public List<oracleTestVo> selectTest() {
        return mapper.selectTest();
    }
}
