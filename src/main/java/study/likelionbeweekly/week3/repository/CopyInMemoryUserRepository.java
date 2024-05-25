/*package study.likelionbeweekly.week3.repository;

import org.springframework.stereotype.Repository;
import study.likelionbeweekly.week3.domain.User;

import java.util.HashMap;
import java.util.Map;


InMemoryUserRepository 따라 해보기
public class CopyInMemoryUserRepository {

    @Repository
    public InMemoryUserRepository implements UserRepository { //UserRepository 인터페이스 구현

        //메모리 내에서 사용자 데이터를 저장, 검색
        private static final Map<String, User> users = new HashMap<>();

        @Override //메서드 재정의
        public void save(User user) {   //객체를 user맵에 저장하는 메서드
            final String id = user.getId();
            users.put(id,user);
        }


        @Override
        public User findById(String id) {   //user맵에서 해당 Id로 저장된 User 객체를 반환
            return users.get(id);
        }
    }
}
*/