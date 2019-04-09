package com.company.wait_example;

import java.util.ArrayList;
import java.util.List;

public class Example_3 {

    /**
     * Monitor
     *
     * Low-level multi-threading variable primitives
     * wait()/notify()/synchronized, monitor
     *
     * Middle-level multi-threading primitives
     * Blocking Buffer (BlockingQueue) |
     * Producer-Consumer (заказчик-исполнитель)
     *
     */

    public static void main(String[] args) {
        List<Thread> threads = new ArrayList<>();

        for (int i = 0; i < 10; i++) {
            final int tempIndex = i;

            threads.add(new Thread(new Runnable() {
                @Override
                public void run() {
                    doSomething("thread " + (tempIndex + 1));
                }
            }));
        }

        for (Thread thread : threads) {
            thread.start();
        }


    }


    //isLocked = true
    //owner = thread 2
    private synchronized /*Example_3.class*/ static void doSomething(String threadName) {

        System.out.println(String.format("Phase 1: [%s] - wait - sleep", threadName));
        try {
            //isBlocked = false
            //entering wait-set
            Example_3.class.wait(5000);

            //isBlocked = true

        } catch (InterruptedException ignored) {
        }

        System.out.println(String.format("Phase 2: wait - [%s] - sleep", threadName));


        try {
            Thread.sleep(5000);
        } catch (InterruptedException ignored) {
        }

        System.out.println(String.format("Phase 3: wait - sleep - [%s]", threadName));

    }
    //thread 8
    //thread 2

}
