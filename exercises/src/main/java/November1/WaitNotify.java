package November1;

public class WaitNotify {
    static boolean event = false;

    public static void main(String[] args) throws InterruptedException {
        final Object sync = new Object();
        Thread thread = new Thread(new Waiter(sync));
        thread.start();

        Thread.sleep(1000);
        synchronized (sync) {
            sync.notify();
            event=true;
            System.out.println("notified");
        }
        System.out.println("main finished");
    }


    private static class Waiter implements Runnable {

        private final Object sync;

        Waiter(Object sync) {
            this.sync = sync;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + " Waiter started");
            synchronized (sync) {
                try {
                    while(!event) {
                        sync.wait();
                    }
                    System.out.println(Thread.currentThread().getName() + " waiting stopped");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + " Waiter finished");
        }
    }
}
