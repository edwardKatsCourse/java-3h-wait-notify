package com.company.blocking_queue_multiple_elements;

public class MainApplication {

    public static void main(String[] args) {
        Buffer<String> buffer = new Buffer<>(10);

        new Thread(new Producer(0, buffer)).start();
        new Thread(new Producer(0, buffer)).start();

        for (int i = 0; i < 1; i++) {
            new Thread(new Consumer<String>(buffer, i + 1)).start();
        }
    }
}
