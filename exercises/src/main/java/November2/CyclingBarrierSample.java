package November2;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

public class CyclingBarrierSample {
    public static void main(String[] args) {
        CyclicBarrier barrier = new CyclicBarrier(3);
        new Thread(new Friend(0, barrier)).start();
        new Thread(new Friend(1000, barrier)).start();
        new Thread(new Friend(2000, barrier)).start();
    }

    private static class Friend implements Runnable {

        private long timeToArrive;
        private CyclicBarrier barrier;

        public Friend(long timeToArrive, CyclicBarrier barrier) {
            this.timeToArrive = timeToArrive;
            this.barrier = barrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("Get out home");
                Thread.sleep(timeToArrive);
                System.out.println("Come");
                barrier.await();
                System.out.println("Lets go!");

            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }

        }
    }
}
