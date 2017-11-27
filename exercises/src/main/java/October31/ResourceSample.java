package October31;

public class ResourceSample {


    public static void main(String[] args) {
        ResourceHolder res = new ResourceHolder(100);
        Thread thread1 = new Thread(new MyThread(res,1000), "THREAD1");
        Thread thread2 = new Thread(new MyThread(res,2000), "THREAD2");
        thread2.start();
        thread1.start();

    }

    private static class MyThread implements Runnable {
        private ResourceHolder resourceHolder;
        private long delay;

        public MyThread(ResourceHolder res, long delay) {
            this.resourceHolder = res;
            this.delay = delay;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(delay);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() +  " " + resourceHolder.settings);
//            resourceHolder.settings += 1;
        }
    }

    private static class ResourceHolder {
      final int settings;

        private ResourceHolder( int settings) {
            this.settings=settings;
        }
    }
}
