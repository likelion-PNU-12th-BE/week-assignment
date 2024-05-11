package study.likelionBEweekly.week2.spring;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;

@Configurable   // 스프링 컨테이너에 빈 등록
public class CreateBean01 {
    @Bean   // 스프링 빈 만들기
    public BookRepository bookRepository() {
        return new BookRepository();
    }
}