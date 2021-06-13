import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class qrtest {
    public static void main(String ar[]) {
        int sno = 0;
        String name = "관리자";
        try {
            File file = null;
            // 큐알이미지를 저장할 디렉토리 지정
            file = new File("D:\\qrtest");
            if (!file.exists()) {
                file.mkdirs();
            }
            // 코드인식시 링크걸 URL주소
            String codeurl = new String((sno + name).getBytes("UTF-8"), "ISO-8859-1");
            // 큐알코드 바코드 생성값
            int qrcodeColor = 0xFF2e4e96;
            // 큐알코드 배경색상값
            int backgroundColor = 0xFFFFFFFF;

            QRCodeWriter qrCodeWriter = new QRCodeWriter();
            // 3,4번째 parameter값 : width/height값 지정
            BitMatrix bitMatrix = qrCodeWriter.encode(codeurl, BarcodeFormat.QR_CODE, 200, 200);
            //
//            MatrixToImageConfig matrixToImageConfig = new MatrixToImageConfig(qrcodeColor, backgroundColor);
            BufferedImage bufferedImage = MatrixToImageWriter.toBufferedImage(bitMatrix);
            // ImageIO를 사용한 바코드 파일쓰기\

            System.out.println("D:\\qrtest\\0관리자.png");
            ImageIO.write(bufferedImage, "png", new File("D:\\qrtest\\" + sno + name + ".png"));

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
