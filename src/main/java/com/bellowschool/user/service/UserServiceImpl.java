package com.bellowschool.user.service;

import com.bellowschool.common.StringSecurity.ShaEncoder;
import com.bellowschool.common.qr.QrUtill;
import com.bellowschool.user.mapper.UserMapper;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.File;
import java.io.UnsupportedEncodingException;
import java.security.NoSuchAlgorithmException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.UUID;

@Log4j2
@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserMapper userMapper;
    private final QrUtill qr;
    private final ShaEncoder shaEncoder;

    @Override
    @Transactional
    public int regUser(Map<String, Object> params) throws UnsupportedEncodingException, NoSuchAlgorithmException {
        int sno = userMapper.cresno();
        String username = (String) params.get("username");
        String qrname = UUID.randomUUID().toString();

        params.put("usernum", sno);
        params.put("qrname", qrname);
        params.put("password", shaEncoder.Sha256Encoder((String) params.get("password")));

        qr.qrCreate(sno, username, qrname);

        return userMapper.regUser(params);
    }

    @Override
    @Transactional
    public List<UserVo> userList() {
        return userMapper.userList();
    }

    @Override
    @Transactional
    public int userDelete(Map<String, Object> params) {
        String qrName = (String) params.get("qrname");
        File file = new File(QrUtill.uploadPath + qrName + ".png");
        if (file.delete()) {
            return userMapper.userDelete(params);
        }
        return 0;
    }

    @Override
    @Transactional
    public UserVo userRead(int usernum) {
        return userMapper.userRead(usernum);
    }

    @Override
    @Transactional
    public int updateUser(Map<String, Object> params) {
        ArrayList<Integer> sno = (ArrayList<Integer>) params.get("userNum");
        int snoInt = Integer.parseInt(String.valueOf(sno.get(0)));
        String userName = (String) params.get("userName");
        String qrNameEx = (String) params.get("qrName");
        String qrNameNew = UUID.randomUUID().toString();

        params.put("qrName", qrNameNew);
        params.put("userNum", snoInt);
        qr.qrCreate(snoInt, userName, qrNameNew);

        File file = new File(QrUtill.uploadPath + qrNameEx + ".png");
        file.delete();
        return userMapper.updateUser(params);
    }

    @Override
    @Transactional
    public int userCount() {
        return userMapper.userCount();
    }

    @Override
    @Transactional
    public UserVo findByAccount(String id) {
        return userMapper.findByAccount(id);
    }

    @Override
    public List<Integer> userClassCount() {
        return userMapper.userClassCount();
    }
}
