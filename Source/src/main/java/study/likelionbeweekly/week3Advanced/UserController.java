package study.likelionbeweekly.week3Advanced;

import java.io.IOException;
import study.likelionbeweekly.week3Advanced.exception.PasswordMismatchException;
import study.likelionbeweekly.week3Advanced.exception.UserNotFoundException;

public class UserController {


    private UserView userView;
    private UserService userService;

    public UserController(UserView userView, UserService userService) {
        this.userView = userView;
        this.userService = userService;
    }

    public void processUserRequest() throws IOException {
        int number;
        do {

            number = userView.displayOptions();
            switch (number) {
                case 1:
                    register();
                    break;
                case 2:
                    login_version2();
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private void register() throws IOException {
        String id = userView.getId();
        String password = userView.getPassword();
        boolean result = userService.registerUser(id, password);
        if (result) {
            userView.displayMessage("회원 가입 완료");
        } else {
            userView.displayMessage("존재하는 id");
        }
    }

    private void login() throws IOException {
        String id = userView.getId();
        String password = userView.getPassword();
        LoginStatus result = userService.loginUser(id, password);
        switch (result) {
            case USER_NOT_FOUND -> userView.displayMessage("가입되지 않은 ID");
            case PASSWORD_MISMATCH-> userView.displayMessage("비밀 번호 불일치");
            case SUCCESS-> userView.displayMessage(String.format("당신의 ID는 %s 입니다", id));
        }
    }

    private void login_version2() throws IOException{
        String id = userView.getId();
        String password = userView.getPassword();
        try {
            userService.loginUser_errorVersion(id, password);
            userView.displayMessage(String.format("당신의 ID는 %s 입니다", id));
        }catch (UserNotFoundException e){
            userView.displayMessage("가입되지 않은 ID");
        }catch (PasswordMismatchException e){
            userView.displayMessage("비밀 번호 불일치");
        }
    }
}
