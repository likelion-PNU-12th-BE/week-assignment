package study.likelionbeweekly.week3.longcode;

import java.util.Objects;

public class Member {
    private final String id;
    private final String password;

    public Member(String id, String password) {
        this.id = id;
        this.password = password;
    }

//    public String getId() {
//        return id;
//    }
//
//    public String getPassword() {
//        return password;
//    }

    public boolean checkSameMember(String id,
                                   String password) {
        return (Objects.equals(this.id, id)) && (Objects.equals(this.password, password));
    }
}
