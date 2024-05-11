package study.likelionbeweekly.week2.Constructor_Injection;

import org.springframework.stereotype.Repository;

@Repository
public class PersonRepository {
    public String getPersonData() {
        return "Minki Sung from Repository";
    }
}
