package com.bellowschool.user.mapper;

import com.bellowschool.vo.notiVo;
import com.bellowschool.vo.userVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface userMapper {
    int regUser(Map<String, Object> params);
    int cresno ();
    List<userVo> userList();
    int userDetele(Map<String, Object> params);
    userVo userRead(int usernum);
}
