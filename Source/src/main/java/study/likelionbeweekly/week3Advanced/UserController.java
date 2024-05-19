package study.likelionbeweekly.week3Advanced;

import java.io.IOException;

public class UserController {

    private UserRepository userRepository;
    private UserView userView;
    private UserService userService;

    public UserController(UserRepository userRepository, UserView userView,
        UserService userService) {
        this.userRepository = userRepository;
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
                    login();
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
        int result = userService.loginUser(id, password);
        switch (result) {
            case 1 -> userView.displayMessage("가입되지 않은 ID");
            case 2 -> userView.displayMessage("비밀 번호 불일치");
            case 3 -> userView.displayMessage(String.format("당신의 ID는 %s 입니다", id));
        }
    }
}
