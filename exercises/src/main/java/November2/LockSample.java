package November2;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class LockSample {
    private static Object sync = new Object();
    private static Thread lockingThread = null;
    private static int lockCount = 0;


    public static void main(String[] args) throws InterruptedException, IOException {
        Thread thread = new Thread(new SomeThread(0));
        Thread thread2 = new Thread(new SomeThread(500));
        Thread thread3 = new Thread(new SomeThread(500));
        thread.start();
        thread2.start();
        thread3.start();
        Lock lock = new ReentrantLock();
        lock.lock();
        lock.lock();
        System.out.println(123);
        lock.unlock();
        lock.unlock();

    }

    public static void lock() throws InterruptedException {
        synchronized (sync) {
            while (lockCount > 0 && Thread.currentThread() != lockingThread) {
                sync.wait();
            }
            lockCount += 1;
            lockingThread = Thread.currentThread();
        }
    }

    public static void unlock() {
        synchronized (sync) {
            if (lockCount > 0 && lockingThread == Thread.currentThread()) {
                lockCount -= 1;
                sync.notifyAll();
            }
        }
    }

    public static void a() throws InterruptedException {
        System.out.println(Thread.currentThread().getName() + " Want Lock");

        lock();
        System.out.println(Thread.currentThread().getName() + " Locked");
    }

    public static void b() {
        System.out.println(Thread.currentThread().getName() + " Still Locked");
        unlock();
        System.out.println(Thread.currentThread().getName() + " Resource Unlock!");
    }

    private static class SomeThread implements Runnable {
        private long timeToSleep;

        SomeThread(long timeToSleep) {

            this.timeToSleep = timeToSleep;
        }

        @Override
        public void run() {
            try {
                Thread.sleep(timeToSleep);
                a();
                Thread.sleep(1000);
                b();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }
}
