package November2;

import java.util.concurrent.CountDownLatch;

public class CountDownLatchSample {
    public static void main(String[] args) throws InterruptedException {
        CountDownLatch latch = new CountDownLatch(8);
        Thread thread1 = new Thread(new User(latch));
        thread1.start();

        latch.await();

        System.out.println("Take your Cola!");
    }
    private static class User implements Runnable{

        private CountDownLatch latch;

        public User(CountDownLatch latch) {
            this.latch = latch;
        }

        @Override
        public void run() {
            for (int i = 0; i <8 ; i++) {
                System.out.println("Throwing coin");
                latch.countDown();
            }
            System.out.println("Give me Cola!");
        }
    }
}
