package study.likelionbeweekly.week3Advanced;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {
    private final Map<String, String> users = new HashMap<>();

    public boolean findById(String id) {
        return users.containsKey(id);
    }

    public void addUser(String id, String pw) {
        users.put(id, pw);
    }

    public String getpwById(String id){
        return users.get(id);
    }
}
