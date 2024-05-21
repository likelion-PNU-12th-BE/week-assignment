package study.likelionbeweekly.week3.longcode;
import java.io.IOException;

public class UserController {

    private final UsersService service;
    private final UserView userView;

    public UserController(UsersService service, UserView userView) {
        this.service = service;
        this.userView = userView;
    }

    public void run() throws IOException {
        while (true) {
            int choice = userView.displayMenu();

            switch (choice) {
                case 1 -> // Join Page
                        joinHandler();
                case 2 -> // Login Page
                        loginHandler();
                case 3 -> { // Exit
                    exitHandler();
                    return;
                }
            }
        }
    }

    private void joinHandler() throws IOException {
        String id = userView.getInput("가입할 아이디 입력: ");
        String password = userView.getInput("가입할 비밀번호 입력: ");
        if (service.join(id, password)) {
            userView.displayMessage("회원 가입 완료");
        } else {
            userView.displayMessage("중복 아이디 가입");
        }
    }

    private void loginHandler() throws IOException {
        String id = userView.getInput("로그인 아이디 입력: ");
        String password = userView.getInput("로그인 비밀번호 입력: ");
        if (service.login(id, password)) {
            userView.displayMessage("로그인 성공");
            userView.displayMessage("당신의 아이디는 " + id + " 입니다.");
        } else {
            userView.displayMessage("존재하지않는 멤버이거나, 아이디 또는 비밀번호 불일치");
        }
    }

    private void exitHandler() {
        userView.displayMessage("프로그램을 종료합니다.");
    }

}
