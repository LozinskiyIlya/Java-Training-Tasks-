package October29;

import static October29.Syncronized.counter;

public class Syncronized {
    static int counter=1;
    public static void main(String[] args) {

    }
}
class SleppingThread2 implements Runnable {

    @Override
    public void run() {
        while (true) {
            if (counter > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter-=1;
                System.out.println("removing 1");
            }
            System.out.println(counter);
        }
    }
}
