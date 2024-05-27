package study.likelionbeweekly.week3.domain;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.ToString;

@Getter
//@Builder
@ToString
@EqualsAndHashCode
@RequiredArgsConstructor
public class User {
    private String id;

    private String password;

    public User(String id,
                String password){
        this.id = id;
        this.password = password;
    }
}