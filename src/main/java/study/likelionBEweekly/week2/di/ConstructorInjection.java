package study.likelionBEweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import study.likelionBEweekly.week2.object.Book;
import study.likelionBEweekly.week2.spring.BookRepository;

public class ConstructorInjection {
    @Service
    public class BookService {
        private final BookRepository bookRepository;

//        @Autowired 클래스의 생성자가 1개일 경우, 그 생성자로 주입받을 객체가 빈으로 등록되어 있다면 생략가능
        public  BookService(BookRepository bookRepository) {    // 생성자
            this.bookRepository = bookRepository;
        }
    }
}