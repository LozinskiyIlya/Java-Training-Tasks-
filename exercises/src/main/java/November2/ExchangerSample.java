package November2;

import java.util.concurrent.Exchanger;

public class ExchangerSample {
    public static void main(String[] args) {
        Exchanger<String> exchanger = new Exchanger<>();

        new Thread(new Person("Batman", exchanger)).start();
        new Thread(new Person("SuperMan", exchanger)).start();


    }

    private static class Person implements Runnable {

        private String sticker;
        private Exchanger<String> exchanger;

        Person(String sticker, Exchanger<String> exchanger) {
            this.sticker = sticker;
            this.exchanger = exchanger;
        }

        @Override
        public void run() {
            try {
                System.out.println(Thread.currentThread().getName() + " I have " + sticker);
                sticker = exchanger.exchange(sticker);
                System.out.println(Thread.currentThread().getName() + " Now my sticker is " + sticker);

            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
