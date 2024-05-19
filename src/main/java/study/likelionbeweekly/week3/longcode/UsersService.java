package study.likelionbeweekly.week3.longcode;

public class UsersService {

    private final UserRepository userRepository;

    public UsersService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean join(String id, String password) {
        return userRepository.join(id, password);
    }

    public boolean login(String id, String password) {
        return userRepository.login(id, password);
    }
}
