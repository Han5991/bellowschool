package com.bellowschool.common.StringSecurity;

import org.springframework.stereotype.Service;

import java.io.UnsupportedEncodingException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

@Service
public class ShaEncoder {

    public String Sha256Encoder(String str) throws UnsupportedEncodingException, NoSuchAlgorithmException {

        MessageDigest digest = MessageDigest.getInstance("SHA-256");
        byte[] hash = digest.digest(str.getBytes("UTF-8"));
        StringBuffer hexString = new StringBuffer();

        for (byte b : hash) {
            String hex = Integer.toHexString(0xff & b);
            if (hex.length() == 1) {
                hexString.append('0');
            }
            hexString.append(hex);
        }

        return hexString.toString();

    }
}
