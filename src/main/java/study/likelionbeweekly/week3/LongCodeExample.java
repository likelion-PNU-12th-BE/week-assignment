package study.likelionbeweekly.week3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class LongCodeExample {

    private static final Map<String, String> users = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

        do {
            System.out.println("1. /joinPage\t"
                             + "2. /loginPage\t"
                             + "3. 종료");

            int number = Integer.parseInt(bufferedReader.readLine());
            String id;
            String password;
            String requestMapping;
            switch (number) {
                case 1:
                    System.out.print("가입할 아이디 입력: ");
                    id = bufferedReader.readLine();
                    System.out.print("가입할 비밀번호 입력: ");
                    password = bufferedReader.readLine();
                    requestMapping = "/join";
                    logic(id, password, requestMapping);
                    break;
                case 2:
                    System.out.print("로그인 아이디 입력: ");
                    id = bufferedReader.readLine();
                    System.out.print("로그인 비밀번호 입력: ");
                    password = bufferedReader.readLine();
                    requestMapping = "/login";
                    logic(id, password, requestMapping);
                    break;
                case 3:
                    return;
            }
        } while (true);
    }

    private static void logic(String id, String password, String requestMapping) {
        switch (requestMapping) {
            case "/join":
                if (users.containsKey(id)) {
                    System.out.println("중복 아이디 가입");
                    return;
                }
                users.put(id, password);
                System.out.println("회원 가입 완료");
                break;

            case "/login":
                if (!users.containsKey(id)) {
                    System.out.println("가입되지 않은 아이디");
                    return;
                }

                String findUserPassword = users.get(id);
                if (!password.equals(findUserPassword)) {
                    System.out.println("비밀번호 불일치");
                    return;
                }

                System.out.println("로그인 성공");
                System.out.println("당신의 아이디는 " + id + " 입니다.");
                break;
        }
    }
}
