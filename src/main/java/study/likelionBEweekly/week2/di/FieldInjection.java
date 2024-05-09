package study.likelionBEweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.likelionBEweekly.week2.spring.BookRepository;

public class FieldInjection {
    @Service
    public class BookService {
        @Autowired      // 필드 주입
        private BookRepository bookRepository;
    }
}
