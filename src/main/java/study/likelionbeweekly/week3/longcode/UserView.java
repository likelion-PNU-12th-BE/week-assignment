package study.likelionbeweekly.week3.longcode;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {

    private BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));

    public int displayMenu() throws IOException {
        System.out.println("1. /joinPage\t2. /loginPage\t3. 종료");
        return Integer.parseInt(bufferedReader.readLine());
    }

    public String getInput(String prompt) throws IOException {
        System.out.print(prompt);
        return bufferedReader.readLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
