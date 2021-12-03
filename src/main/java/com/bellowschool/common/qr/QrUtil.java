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
public class QrUtil {

    public static String uploadPath = "C:" + File.separatorChar
            + "Users" + File.separatorChar
            + "admin" + File.separatorChar
            + "IdeaProjects" + File.separatorChar
            + "bellowschool" + File.separatorChar
            + "src" + File.separatorChar
            + "main" + File.separatorChar
            + "resources" + File.separatorChar
            + "static" + File.separatorChar
            + "img" + File.separatorChar
            + "qrcode" + File.separatorChar;

    public boolean qrCreate(int sno, String name, String qrName) {
        try {
            String codeUrl = new String((sno + "_" + name).getBytes("UTF-8"));
            String urlEncode = URLEncoder.encode(codeUrl, "UTF-8");
            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(urlEncode, BarcodeFormat.QR_CODE, 200, 200);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            File file = new File(uploadPath + qrName + ".png");

            return ImageIO.write(bufferedImage, "png", file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
