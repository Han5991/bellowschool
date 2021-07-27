package com.bellowschool.common.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.springframework.stereotype.Service;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLEncoder;

@Service
public class QrUtill {

    public boolean qrCreate(int sno, String name, String qrname) {
        try {
            String codeurl = new String((sno + "_" + name).getBytes("UTF-8"));
            String urlencode = URLEncoder.encode(codeurl,"UTF-8");

            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(urlencode, BarcodeFormat.QR_CODE, 200, 200);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            String a = File.separator;
            File file = new File("C:\\Users\\admin\\IdeaProjects\\bellowschool\\src\\main\\resources\\static\\img\\qrcode\\" + qrname + ".png");

            return ImageIO.write(bufferedImage, "png", file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
