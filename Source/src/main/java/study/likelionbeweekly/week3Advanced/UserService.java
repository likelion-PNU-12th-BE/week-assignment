package study.likelionbeweekly.week3Advanced;

import study.likelionbeweekly.week3Advanced.exception.*;


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

    public LoginStatus loginUser(String id, String pw) {

        if (!checkUser(id)) {
            return LoginStatus.USER_NOT_FOUND;
        } else if (!userRepository.getpwById(id).equals(pw)) {
            return LoginStatus.PASSWORD_MISMATCH;
        } else {
            return LoginStatus.SUCCESS;
        }
    }

    public void loginUser_errorVersion (String id,String pw) throws UserNotFoundException,PasswordMismatchException{
        if(!checkUser(id)){
            throw new UserNotFoundException("가입되지 않은 ID입니다");
        } else if(!userRepository.getpwById(id).equals(pw)){
            throw new PasswordMismatchException("ID와 비밀번호가 일치하지 않습니다");
        }
    }

    private boolean checkUser(String id) {
        return userRepository.findById(id);
    }


}
