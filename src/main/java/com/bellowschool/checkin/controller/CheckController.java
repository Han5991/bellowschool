package com.bellowschool.checkin.controller;

import com.bellowschool.checkin.service.CheckService;
import com.bellowschool.vo.UserVo;
import lombok.RequiredArgsConstructor;
import lombok.extern.log4j.Log4j2;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


@Log4j2
@Controller
@RequiredArgsConstructor
public class CheckController {
    private final CheckService checkService;

    @GetMapping("/qrcheck")
    public String createnoti(@RequestParam(value = "name") String name, @RequestParam(value = "id") int id) throws IOException {
        Map<String, Object> params = new HashMap<>();
        params.put("userNum", id);
        params.put("userName", URLDecoder.decode(name, StandardCharsets.UTF_8));
        checkService.regCheckIn(params);
        return "redirect:https://hounjini.cafe24.com/sangwook/index.html";
    }

    @GetMapping("/attendance")
    public String qrcode() {
        return "checkin/userAttendanceList";
    }

    @PostMapping("/userattendanceList")
    @ResponseBody
    public List<UserVo> userAttendanceList(Map<String, Object> params) {
        return checkService.userAttendanceList(params);
    }

    @PostMapping("/userattendanceList2")
    @ResponseBody
    public List<UserVo> userAttendanceList2(@RequestBody Map<String, Object> params) {
        return checkService.userAttendanceList(params);
    }

//    public static void main(String[] args) {
//        File checkin = new File("C:\\Users\\admin\\Desktop\\데이터 입력.txt");
//        String line = "";
//        FileReader filereader = null;
//        ArrayList<String> result = new ArrayList<String>();
//        try {
//            filereader = new FileReader(checkin);
//        } catch (FileNotFoundException e) {
//            e.printStackTrace();
//        }
//        // 입력 버퍼 생성
//        BufferedReader bufReader = new BufferedReader(filereader);
//
//        bufReader = new BufferedReader(filereader);
//
//        while (true) {
//            try {
//                if (!((line = bufReader.readLine()) != null)) break;
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//            result.add(line);
//        }
//        for(String a : result){
//            Map<String, Object> params = new HashMap<>();
//            params.put("userNum", a.split(" ")[2]);
//            params.put("userName", a.split(" ")[1]);
//            params.put("time", a.split(" ")[0]);
//            checkService.regCheckIn(params);
//        }
//    }
}
