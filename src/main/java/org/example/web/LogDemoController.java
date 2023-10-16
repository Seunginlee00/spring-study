package org.example.web;


import lombok.RequiredArgsConstructor;
import org.example.common.MyLogger;
import org.example.logdemo.LogDemoService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import javax.servlet.http.HttpServletRequest;
@Controller
@RequiredArgsConstructor
public class LogDemoController {
    // 의존관계 주입읇 받고 있음
    // 고객 요청이 나와서 나갈때 까지인데 리퀘스트가 아직 안들어옴

    private final LogDemoService logDemoService;
    private final MyLogger myLogger;


    @RequestMapping("log-demo")
    @ResponseBody
    public String logDemo(HttpServletRequest request) {
        String requestURL = request.getRequestURL().toString(); // 고객이 어떤 url로 요청했는지 알수 있음
        myLogger.setRequestURL(requestURL);
        myLogger.log("controller test");
        logDemoService.logic("testId");
        return "OK";
    }
}