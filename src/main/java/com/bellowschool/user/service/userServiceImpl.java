package com.bellowschool.user.service;

import com.bellowschool.common.qr.qrUtill;
import com.bellowschool.user.mapper.userMapper;
import com.bellowschool.vo.userVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;

@Log4j2
@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final userMapper userMapper;

    @Override
    public int regUser(Map<String, Object> params) {
        qrUtill qr = new qrUtill();

        int sno = userMapper.cresno();
        String username = (String) params.get("username");

        params.put("usernum", sno);
        params.put("qrname", sno);
        params.put("qrpath", "img\\qrcode\\" + sno + ".png");
        qr.qrCreate(sno, username);

        return userMapper.regUser(params);
    }

    @Override
    public List<userVo> userList() {
        return userMapper.userList();
    }

    @Override
    public int userDetele(Map<String, Object> params) {
        int usernum = (int) params.get("usernum");
        File file = new File("C:\\Users\\admin\\IdeaProjects\\bellowschool\\src\\main\\resources\\static\\img\\qrcode\\" + usernum + ".png");
        file.delete();
        return userMapper.userDetele(params);
    }

    @Override
    public userVo userRead(int usernum) {
        return userMapper.userRead(usernum);
    }
}
