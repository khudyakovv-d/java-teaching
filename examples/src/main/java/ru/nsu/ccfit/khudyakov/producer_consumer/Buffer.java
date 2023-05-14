package ru.nsu.ccfit.khudyakov.producer_consumer;

import java.util.LinkedList;

public class Buffer {

    private final LinkedList<Integer> list = new LinkedList<>();

    private final int maxSize;

    public Buffer(int maxSize) {
        this.maxSize = maxSize;
    }

    void produce(Integer value) {
        synchronized (list) {
            while (list.size() == maxSize) {
                try {
                    if (Thread.currentThread().isInterrupted()) {
                        return;
                    }

                    list.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                }
            }

            list.addFirst(value);
            list.notifyAll();
        }
    }

    public Integer consume() {
        synchronized (list) {
            while (list.isEmpty()) {
                try {
                    if (Thread.currentThread().isInterrupted()) {
                        return null;
                    }

                    list.wait();
                } catch (InterruptedException e) {
                    Thread.currentThread().interrupt();
                    return null;
                }
            }

            Integer last = list.removeLast();
            list.notifyAll();
            return last;
        }
    }

}
