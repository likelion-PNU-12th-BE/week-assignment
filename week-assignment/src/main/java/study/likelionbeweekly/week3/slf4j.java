package study.likelionbeweekly.week3;

import lombok.extern.slf4j.Slf4j;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

//@Slf4j 애노테이션으로 로그 출력해보기 실습

@Slf4j
@RestController
public class slf4j {

    @RequestMapping("/home")
    public String logTest() {

        //private final Logger log = LoggerFactory.getLogger(getClass());

        String name = "logTest";

                log.trace("trace log = {}", name);
                log.debug("debug log = {}", name);
                log.info("info log = {}", name);
                log.warn("warn log = {}", name);
                log.error("error log = {}", name);

                return "ok";
    }
}
