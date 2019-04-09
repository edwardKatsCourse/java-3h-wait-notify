package com.company.blocking_queue_multiple_elements;

public class Consumer<T> implements Runnable {

    private Buffer<T> buffer;
    private Integer id;

    public Consumer(Buffer<T> buffer, Integer id) {
        this.buffer = buffer;
        this.id = id;
    }

    @Override
    public void run() {
        while (true) {
            try {
                T data = buffer.get();
                System.out.printf("Data consumed by %s: [%s]\n", this.id, data);
            } catch (InterruptedException e) {}
        }
    }
}
