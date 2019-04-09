package com.company.wait_example;

public class Example_2 {

    public static void main(String[] args) throws InterruptedException {

        Object monitor = new Object();
        synchronized (monitor) {
            monitor.wait(3000);
        }

        System.out.println("Done");

    }
}
