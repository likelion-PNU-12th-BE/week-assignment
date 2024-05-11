package study.likelionbeweekly.week2.Field_Injection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonService {
    @Autowired
    private PersonRepository personRepository;

    public String getPersonName() {
        return personRepository.getPersonData();
    }
}
