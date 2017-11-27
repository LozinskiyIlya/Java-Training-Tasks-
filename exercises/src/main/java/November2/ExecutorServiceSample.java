package November2;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class ExecutorServiceSample {
    public static void main(String[] args) throws Exception {
        ExecutorService executor = Executors.newFixedThreadPool(4);


        Future<Integer> future = executor.submit(new GetCube(3));
        if (!future.isDone()) {
            System.out.println("Cube is still been counting");
        }
        System.out.println("Cube now has been counted and it equals:" + future.get());
        executor.shutdown();


    }

    private static class GetCube implements Callable<Integer> {

        private final int number;

        GetCube(int i) {
            this.number = i;
        }

        @Override
        public Integer call() throws Exception {
            Thread.sleep(1000);
            return number * number * number;
        }
    }

    private static class SquareTask implements Runnable {
        private final int number;

        SquareTask(int number) {
            this.number = number;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName());
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(this.number * this.number);
        }
    }
}
