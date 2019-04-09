package com.company.blocking_queue;

public class Producer implements Runnable {

    //заказ
    private int initialData;
    private int delay;
    private Buffer buffer;

    public Producer(int initialData, int delay, Buffer buffer) {
        this.initialData = initialData;
        this.delay = delay;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                System.out.printf("Generated data: [%s]\n", initialData);
                buffer.put(initialData++);
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {}
        }

    }
}
