package study.likelionBEweekly.week2.di;

import org.springframework.beans.factory.annotation.Autowired;
import study.likelionBEweekly.week2.spring.BookRepository;

public class SetterInjection {
    private class BookService {
        private BookRepository bookRepository;
        @Autowired
        public void setBookRepository(BookRepository bookRepository) {  // setter, 주입받는 객체가 변경될 가능성이 있는 경우에 사용한다.
            this.bookRepository = bookRepository;
        }
    }
}
