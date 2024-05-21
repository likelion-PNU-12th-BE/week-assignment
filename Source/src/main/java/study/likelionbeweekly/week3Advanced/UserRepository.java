package study.likelionbeweekly.week3Advanced;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, User> users = new HashMap<>();

    public boolean findById(String id) {return users.containsKey(id);}

    public void addUser(String id, String pw) {
        User user = new User(id,pw);
        users.put(id, user);
    }

    public String getpwById(String id) {
        User user = users.get(id);
        return user.getPassword();
    }
}
