package com.bellowschool.user.mapper;

import com.bellowschool.vo.UserVo;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Mapper
@Repository
public interface UserMapper {
    int regUser(Map<String, Object> params);

    int cresno();

    List<UserVo> userList();

    int userDelete(Map<String, Object> params);

    UserVo userRead(int usernum);

    int updateUser(Map<String, Object> params);

    int userCount();

    UserVo findByAccount(String id);
}
