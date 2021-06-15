package com.bellowschool.common.qr;

import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class QrUtill {

    public boolean qrCreate(int sno, String name, String qrname) {
        try {
            String codeurl = new String((sno + "_" + name).getBytes("UTF-8"), "ISO-8859-1");

            QRCodeWriter qrCodeWriter = new QRCodeWriter();

            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);

            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);

            File file = new File("C:\\Users\\admin\\IdeaProjects\\bellowschool\\src\\main\\resources\\static\\img\\qrcode\\" + qrname + ".png");

            return ImageIO.write(bufferedImage, "png", file);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }
}
