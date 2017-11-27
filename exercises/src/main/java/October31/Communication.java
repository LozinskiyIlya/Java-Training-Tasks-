package October31;


import java.util.ArrayList;

public class Communication {
    static volatile ArrayList<Task> queue = new ArrayList<>();

    public static void main(String[] args) throws InterruptedException {
        Object sync = new Object();
        Thread workerThread = new Thread(new Worker(sync,queue));
        workerThread.start();
        Thread workerThread2 = new Thread(new Worker(sync,queue));
        workerThread2.start();
        Thread workerThread3 = new Thread(new Worker(sync,queue));
        workerThread3.start();
        int i = 0;
        while (true) {
            synchronized (sync) {
                queue.add(new ComputeTask(i));
                queue.add(new HelloTask());
                queue.add(new HelloTask());
                queue.add(new HelloTask());
                queue.add(new HelloTask());
                queue.add(new HelloTask());

                sync.notify();
                System.out.println(queue);
            }
            i += 1;
            Thread.sleep(1000);
        }
    }
}



