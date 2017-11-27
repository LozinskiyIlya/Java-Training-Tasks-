package October31;

public class EarlyExitSample {
    public static void main(String[] args) {
        Object sync = new Object();
        Thread one = new Thread(new Runnable1(sync));
        one.start();
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        synchronized (sync) {
            System.out.println("Im Alive!");
        }
    }

    private static class Runnable1 implements Runnable {

        private Object sync;

        public Runnable1(Object sync) {
            this.sync = sync;
        }

        @Override
        public void run() {
            synchronized (sync) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }
    }
}
