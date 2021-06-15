import com.google.zxing.BarcodeFormat;
import com.google.zxing.client.j2se.MatrixToImageConfig;
import com.google.zxing.client.j2se.MatrixToImageWriter;
import com.google.zxing.common.BitMatrix;
import com.google.zxing.qrcode.QRCodeWriter;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertAll;

@SpringBootTest
public class qrtest {
    @Value("${property.test.name}") // depth가 존재하는 값은 .으로 구분해서 값을 매핑
    private static String propertyTestName;

    @Value("${propertyTest}") // 단일 값을 매핑
    private String propertyTest;

    @Value("${noKey:default value}") // 키 값이 존재하지 않은 경우 default 값을 설정하여 매핑
    private String defaultValue;

    @Value("${propertyTestArray}") // 배열형으로 매핑
    private String[] propertyTestArray;

    @Value("#{'${propertyTestList}' .split(',')}") // ,을 기준으로 리스트형으로 매핑
    private List<String> propertyTestList;

    public static void main(String[] args) throws Exception {


        String codeurl = new String((27 + "_" + "테스트").getBytes("UTF-8"));
        String urlencode = URLEncoder.encode(codeurl,"UTF-8");

        System.out.println(URLDecoder.decode(urlencode,"UTF-8"));

    }
}
