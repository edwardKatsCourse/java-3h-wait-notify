package com.company.blocking_queue;

public class Consumer implements Runnable {

    private Buffer buffer;
    private Integer id;

    public Consumer(Buffer buffer, Integer id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                Integer data = buffer.get();
                System.out.printf("Data consumed by %s: [%s]\n", this.id, data);
            } catch (InterruptedException e) {}
        }
    }
}
