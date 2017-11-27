package October31;

import com.sun.org.apache.xpath.internal.SourceTree;

public class Synchro {
    public static class Sample {
        public void saySmth() {
            synchronized (Synchro.class) {
                System.out.println(Thread.currentThread().getName() + " in method");
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " giving up");

            }
        }
    }

    public static void main(String[] args) {

        Sample sample = new Sample();
        Thread thread1 = new Thread(new Mythread(sample), "THREAD1");
        Thread thread2 = new Thread(new Mythread(sample), "THREAD2");
        synchronized (Synchro.class) {
            thread1.start();
            thread2.start();
            while(true){
                System.out.println(thread1.getState());
                System.out.println(thread2.getState());
            }
        }
    }

    private static class Mythread implements Runnable {
        private Sample sample;

        public Mythread(Sample sample) {
            this.sample = sample;
        }

        @Override
        public void run() {
            sample.saySmth();
        }
    }
}
