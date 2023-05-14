package ru.nsu.ccfit.khudyakov.producer_consumer;

public class Main {

    public static void main(String[] args) throws InterruptedException {
        Buffer buffer = new Buffer(10);

        Producer producer1 = new Producer(buffer);
        Producer producer2 = new Producer(buffer);

        Consumer consumer1 = new Consumer(buffer);
        Consumer consumer2 = new Consumer(buffer);
        Consumer consumer3 = new Consumer(buffer);

        producer1.start();
        producer2.start();

        consumer1.start();
        consumer2.start();
        consumer3.start();

        Thread.sleep(10000L);

        producer1.interrupt();
        producer2.interrupt();
        consumer1.interrupt();
        consumer2.interrupt();
        consumer3.interrupt();

        producer1.join();
        producer2.join();
        consumer1.join();
        consumer2.join();
        consumer3.join();
    }

}
