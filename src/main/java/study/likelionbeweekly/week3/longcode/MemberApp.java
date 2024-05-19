package study.likelionbeweekly.week3.longcode;
import java.io.IOException;

public class MemberApp {
    public static void main(String[] args) throws IOException {
        UserView userView = new UserView();
        UserRepository repository = new UserRepository();
        UsersService service = new UsersService(repository);
        UserController userController = new UserController(service, userView);
        userController.run();
    }
}
