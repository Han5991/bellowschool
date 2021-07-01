package com.bellowschool.user.service;

import com.bellowschool.common.qr.QrUtill;
import com.bellowschool.user.mapper.UserMapper;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;

import java.io.File;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;

    @Override
    public int regUser(Map<String, Object> params) {
        QrUtill qr = new QrUtill();

        int sno = userMapper.cresno();
        String username = (String) params.get("username");
        String qrname = UUID.randomUUID().toString();

        params.put("usernum", sno);
        params.put("qrname", qrname);

        qr.qrCreate(sno, username, qrname);

        return userMapper.regUser(params);
    }

    @Override
    public List<UserVo> userList() {
        return userMapper.userList();
    }

    @Override
    public int userDetele(Map<String, Object> params) {
        String qrname = (String) params.get("qrname");
        File file = new File("C:\\Users\\admin\\IdeaProjects\\bellowschool\\src\\main\\resources\\static\\img\\qrcode\\" + qrname + ".png");
        file.delete();
        return userMapper.userDetele(params);
    }

    @Override
    public UserVo userRead(int usernum) {
        return userMapper.userRead(usernum);
    }

    @Override
    public int updateUser(Map<String, Object> params) {
        QrUtill qr = new QrUtill();
        int sno = (int) params.get("userNum");
        String username = (String) params.get("userName");
        String qrnameEx = (String) params.get("qrName");
        String qrnameNew = UUID.randomUUID().toString();

        params.put("qrName", qrnameNew);
        qr.qrCreate(sno, username, qrnameNew);

        File file = new File("C:\\Users\\admin\\IdeaProjects\\bellowschool\\src\\main\\resources\\static\\img\\qrcode\\" + qrnameEx + ".png");
        file.delete();
        return userMapper.updateUser(params);
    }
}
