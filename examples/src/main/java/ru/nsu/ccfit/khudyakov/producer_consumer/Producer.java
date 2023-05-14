package ru.nsu.ccfit.khudyakov.producer_consumer;

import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Producer extends Thread {

    private static final Logger log = Logger.getLogger(Producer.class.getName());
    private static final long DELAY = 1000L;

    private final Buffer buffer;
    private final Random random = new Random();

    public Producer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            int value = random.nextInt(100);
            buffer.produce(value);

            log.log(Level.INFO, String.format("Thread %s. Produce value %d",
                Thread.currentThread().getName(), value));

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
