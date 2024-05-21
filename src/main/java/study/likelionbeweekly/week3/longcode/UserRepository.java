package study.likelionbeweekly.week3.longcode;

import java.util.HashMap;
import java.util.Map;

public class UserRepository {

    private final Map<String, Member> users = new HashMap<>();

    public boolean join(String id, String password) {
        if (isExsistMember(id)) {
            return false;
        } else {
            Member member = new Member(id, password);
            users.put(id, member);
            return true;
        }
    }

    public boolean login(String id, String password) {
        if (!isExsistMember(id)) {
            return false;
        } else {
            Member user = findById(id);
            return user.checkSameMember(id, password);
        }
    }


    private Member findById(String id) {
        return users.get(id);
    }

    private boolean isExsistMember(String id) {
        return (users.containsKey(id));
    }
}
