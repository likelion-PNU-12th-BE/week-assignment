import java.io.PrintStream;

class TV {
    boolean power;
    int channel;

    void power() {
        power = !power;
    }

    void ChannelUp() {
        ++channel;
    }

    void ChannelDown(){
        --channel;
    }
}


public class Main {
    public static void main(String[] args) {
        for(int i = 0; i < 100; i ++){
            TV tv = new TV();
            System.out.println("Intance " + i + ": " + tv.toString());
        }

    }
}