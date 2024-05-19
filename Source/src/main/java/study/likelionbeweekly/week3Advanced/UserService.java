package study.likelionbeweekly.week3Advanced;

public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public boolean registerUser(String id, String pw) {
        if (validateDuplicateUser(id)) {
            userRepository.addUser(id, pw);
            return true;
        } else {
            return false;
        }
    }

    private boolean validateDuplicateUser(String id) {
        return !userRepository.findById(id);
    }

    public int loginUser(String id, String pw) {

        if (!checkUser(id)) {
            // 가입되지않은 id
            return 1;
        } else if (!userRepository.getpwById(id).equals(pw)) {
            // id pw 매칭 x
            return 2;
        } else {
            // login 성공
            return 3;
        }
    }

    private boolean checkUser(String id) {
        return userRepository.findById(id);
    }

}
