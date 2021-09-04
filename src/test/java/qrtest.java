import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;

import java.net.URLDecoder;
import java.net.URLEncoder;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@SpringBootTest
public class qrtest {
    public static void main(String[] args) throws Exception {


        String codeurl = new String((27 + "_" + "테스트").getBytes("UTF-8"));
        String urlencode = URLEncoder.encode(codeurl, "UTF-8");

        System.out.println(URLDecoder.decode(urlencode, "UTF-8"));

    }

    public List<Map<String, Object>> a(List arr) {
        List<Map<String, Object>> returnArray = new ArrayList<>();
        for (int i = 0; i < arr.size(); i++) {
            Map<String, Object> map = (Map) arr.get(i);
            map.put("stationId", ((Map<String, Object>) arr.get(i)).get("stationId"));
            map.put("stationName", ((Map<String, Object>) arr.get(i)).get("stationName"));
            map.put("localInfo", ((Map<String, Object>) arr.get(i)).get("localInfo"));
            map.put("kakaoId", (Integer.parseInt((String) ((Map<String, Object>) arr.get(i)).get("stationId"))) - 404961106);
            returnArray.add(map);
        }
        if (returnArray.size() < 5) {
            for (int i = 0; i < 5 - returnArray.size(); i++) {
                Map<String, Object> map = (Map) arr.get(i);
                map.put("stationId", "빈 값입니다.");
                map.put("stationName", "빈 값입니다.");
                map.put("localInfo", "빈 값입니다.");
                map.put("kakaoId", 0);
                returnArray.add(map);
            }
        }
        return returnArray;
    }
}
