package study.likelionbeweekly.week3Advanced;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class UserView {
    private BufferedReader bufferedReader;

    public UserView() {
        this.bufferedReader = new BufferedReader(new InputStreamReader(System.in));
    }

    public int displayOptions() throws IOException {
        System.out.println("1. /joinPgage\t2. /loginPage\t3. Exit");
        return Integer.parseInt(bufferedReader.readLine());
    }

    public String getId() throws IOException {
        System.out.print("Enter ID: ");
        return bufferedReader.readLine();
    }

    public String getPassword() throws IOException {
        System.out.print("Enter password: ");
        return bufferedReader.readLine();
    }

    public void displayMessage(String message) {
        System.out.println(message);
    }
}
