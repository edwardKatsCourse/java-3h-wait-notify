package com.company.blocking_queue;

public class MainApplication {

    public static void main(String[] args) {
        Buffer buffer = new Buffer();

//        new Thread(new Producer(1, 1000, buffer)).start();
        new Thread(new Producer(100, 1000, buffer)).start();

        for (int i = 0; i < 10; i++) {
            new Thread(new Consumer(buffer, i + 1)).start();
        }
    }
}
