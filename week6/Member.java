package study.likelionbeweekly.week6;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class Member {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long User_id;

    private String nick;
    private String email;
    private String password;
    private LocalDateTime JoinDate;
}
