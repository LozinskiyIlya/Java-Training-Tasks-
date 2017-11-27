package October31;

import java.util.ArrayList;

public class Worker implements Runnable {
    private final Object sync;
    private ArrayList<Task> queue;

    Worker(Object sync, ArrayList<Task> queue) {
        this.queue = queue;
        this.sync = sync;
    }

    @Override
    public void run() {
        try {
            while (true) {
                Task task = tryGetTask();
                task.doTask();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private Task tryGetTask() throws InterruptedException {
        synchronized (sync) {
            while (queue.isEmpty()) {
                sync.wait();
            }
            return queue.remove(0);
        }
    }
}
interface Task { // look at Runnable
    void doTask();
}

class ComputeTask implements Task{
    private final int n;

    public ComputeTask(int n) {
        this.n = n;
    }

    @Override
    public void doTask() {
        System.out.println(n*n);
    }
}
class HelloTask implements Task{

    @Override
    public void doTask() {
        System.out.println("Hello!");
    }
}


