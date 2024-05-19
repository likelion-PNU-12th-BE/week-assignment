package study.likelionbeweekly.week3Advanced;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws IOException {

        UserRepository userRepository = new UserRepository();
        UserView userView = new UserView();
        UserService uesrService = new UserService(userRepository);
        UserController userController = new UserController(userRepository, userView,uesrService);

        try{
            userController.processUserRequest();
        }catch(IOException e){
            System.out.println("입력 오류가 발생했습니다: " + e.getMessage());
        }
    }
}
