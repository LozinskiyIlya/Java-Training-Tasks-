package November1;

public class WaitNotifyRefactoring {
    static Event event = new Event();

    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new Waiter());
        thread.start();

        Thread.sleep(1000);
        event.happen();
        System.out.println("notified");

        System.out.println("main finished");
    }


    private static class Waiter implements Runnable {

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
                event.await();
                System.out.println(Thread.currentThread().getName() + " waiting stopped");
                System.out.println(Thread.currentThread().getName() + " Waiter finished");
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}

class Event {
    private volatile boolean isHappened = false;
    private final Object sync = new Object();

    public boolean isHappened() {
        return isHappened;
    }

    public void happen() {
        synchronized (sync) {
            this.isHappened = true;
            sync.notifyAll();
        }
    }

    public void await() throws InterruptedException {
        synchronized (sync) {
            while (!isHappened) {
                sync.wait();
            }
        }
    }
}