package study.likelionbeweekly.week3.domain;

import lombok.*;

@Getter
@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {

    private final String id;
    private final String password;

//    public String getId() {
//        return id;
//    }
//
//    public String getPassword() {
//        return password;
//    }
}
