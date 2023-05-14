package ru.nsu.ccfit.khudyakov.producer_consumer;

import java.util.logging.Level;
import java.util.logging.Logger;

public class Consumer extends Thread {

    private static final Logger log = Logger.getLogger(Consumer.class.getName());
    private static final long DELAY = 1000L;

    private final Buffer buffer;

    public Consumer(Buffer buffer) {
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (!Thread.currentThread().isInterrupted()) {
            Integer value = buffer.consume();
            if (value != null) {
                log.log(Level.INFO, String.format("Thread %s. Value was consumed from buffer %d",
                    Thread.currentThread().getName(), value));
            }

            try {
                Thread.sleep(DELAY);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
    }

}
