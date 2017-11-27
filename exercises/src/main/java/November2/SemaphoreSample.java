package November2;

import java.util.concurrent.Semaphore;

public class SemaphoreSample {
    public static void main(String[] args) {
        Semaphore semaphore = new Semaphore(0,true);
        semaphore.release();
        semaphore.release();
        semaphore.release();
        semaphore.release();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();
        new Thread(new User(semaphore)).start();

    }


    private static class User implements Runnable {

        private Semaphore semaphore;

        public User(Semaphore semaphore) {

            this.semaphore = semaphore;
        }

        private void say(String toSay) {
            System.out.println(Thread.currentThread().getName() + ": " + toSay);
        }

        @Override
        public void run() {
            try {
                say("Give me ticket!");
                semaphore.acquire();
                say("I have ticket!");
                Thread.sleep(2000);
                say("Giving ticket back");
                semaphore.release();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }
}
