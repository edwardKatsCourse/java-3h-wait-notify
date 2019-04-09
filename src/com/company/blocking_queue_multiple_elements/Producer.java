package com.company.blocking_queue_multiple_elements;

import java.nio.charset.Charset;
import java.util.Random;
import java.util.UUID;

public class Producer implements Runnable {

    //заказ
    private int delay;
    private Buffer<String> buffer;

    public Producer(int delay, Buffer<String> buffer) {
        this.delay = delay;
        this.buffer = buffer;
    }

    @Override
    public void run() {
        while (true) {
            try {
                //Internet call
                //File read/Search
                String getRandomUUID = UUID.randomUUID().toString().substring(0, 5);

                System.out.printf("Generated data: [%s]\n", getRandomUUID);
                buffer.put(getRandomUUID);
                Thread.sleep(delay);
            } catch (InterruptedException ignored) {}
        }
    }

    private static String getRandomString() {
        byte [] array = new byte[7];
        new Random().nextBytes(array);

        return new String(array, Charset.defaultCharset());
    }

    public static void main(String[] args) {
        System.out.println(getRandomString());
    }
}
