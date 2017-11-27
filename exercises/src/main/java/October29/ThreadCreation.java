package October29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadCreation {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        Thread thread = new MyThread();
        thread.start();

        reader.readLine();
        System.out.println("Bye!");
        System.exit(0);
    }
}

class MyThread extends Thread {
    @Override
    public void run() {
        while (true) {
            System.out.println("Hello from other thread!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
        }
    }
}