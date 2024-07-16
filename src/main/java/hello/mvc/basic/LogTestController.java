package hello.mvc.basic;

import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@Slf4j
@RestController
public class LogTestController {
    @RequestMapping("/log-test")

    public String logTest() {
        String name = "Spring";

        log.trace("trace log=" + name); log.trace("trace log={}", name);
       // 위의 둘의 가장큰 차이는 연산 -> 첫번째는 연산을 하기 때문에 불필요한 메모리를 소요 하나 두번째 껏은
        // 파라미터라 레벨단위에서 막히면 연산과 같은 불필요한 메모리 소요가 없다 따라서 두번째 방법을 지향 하는 것 이 좋다.

        log.debug("debug log={}", name);
        log.info(" info log={}", name);
        log.warn(" warn log={}", name);
        log.error("error log={}", name);
        //로그를 사용하지 않아도 a+b 계산 로직이 먼저 실행됨, 이런 방식으로 사용하면 X
        log.debug("String concat log=" + name);
        return "ok";
    }
}