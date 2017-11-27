package November1;


public class StopThread {


    public static void main(String[] args) throws InterruptedException {
        Thread thread = new Thread(new SomeThread());
        thread.start();

        Thread.sleep(1000);

        thread.interrupt();
    }
}

class SomeThread implements Runnable {

    @Override
    public void run() {
        while (!Thread.interrupted()) {
            System.out.println("Hello!");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                System.out.println("okaaaay");
                break;
            }
        }

    }
}


