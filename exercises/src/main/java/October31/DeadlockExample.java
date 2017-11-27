package October31;

public class DeadlockExample {
    public static void main(String[] args) throws InterruptedException {
        Object sync1 = new Object();
        Object sync2 = new Object();
        Thread thread1 = new Thread(new First(sync1, sync2));
        Thread thread2 = new Thread(new Second(sync1, sync2));
        thread1.start();
        thread2.start();

        Thread.sleep(1000);
        System.out.println(thread1.getState());
        System.out.println(thread2.getState());
    }

    private static class First implements Runnable {

        private final Object sync1;
        private final Object sync2;

        First(Object sync1, Object sync2) {
            this.sync1 = sync1;
            this.sync2 = sync2;
        }

        @Override
        public void run() {
            synchronized (sync1) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (sync2) {
                    System.out.println("First");
                }
            }
        }
    }

    private static class Second implements Runnable {

        private final Object sync1;
        private final Object sync2;

        Second(Object sync1, Object sync2) {
            this.sync1 = sync1;
            this.sync2 = sync2;
        }

        @Override
        public void run() {
            synchronized (sync2) {
                synchronized (sync1) {
                    System.out.println("Second");
                }
            }
        }
    }
}
