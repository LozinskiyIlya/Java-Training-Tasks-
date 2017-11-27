package October29;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class ThreadCreationRunnable {
    public static void main(String[] args) throws IOException, InterruptedException {
        Counter counter = new Counter();
        Thread thread = new Thread(new SleppingThread(counter), "Minus one");
        Thread thread1 = new Thread(new SleppingThread1(counter), "Add one");
        thread1.start();
        thread.start();
    }
}

class SleppingThread implements Runnable {
    private Counter counter;
    SleppingThread(Counter count){
        this.counter=count;
    }
    @Override
    public void run() {
        while (true) {
            if (counter.getCount() >0) {
                counter.add(-1);
                System.out.println("removing 2");
            }
            System.out.println(counter);
        }
    }
}

class SleppingThread1 implements Runnable {
    private Counter counter;
        SleppingThread1(Counter count){
            this.counter=count;
        }
    @Override
    public void run() {
        while (true) {
            if (counter.getCount() > 0) {
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                counter.add(-1);
                System.out.println("removing 1");
            }
            System.out.println(counter);
        }
    }
}

class Counter {
    int count;

    public void add(int count) {
      this.count += count;
    }

    public int getCount() {
        return count;
    }

    @Override
    public String toString() {
        return "" + count;
    }
}

