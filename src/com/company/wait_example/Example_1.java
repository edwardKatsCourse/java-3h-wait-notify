package com.company.wait_example;

public class Example_1 {

    public static void main(String[] args) throws InterruptedException {
        /**
         * 1. monitor internals
         * - blocked-set
         * - wait-set
         * - lock (boolean, owner)
         *
         * 2. wait() - notify()/notifyAll()
         * 3. Blocking Queue
         */

        synchronized (Example_1.class) {
            new Object().wait(3000);
        }

        System.out.println("Done!");

    }
}
