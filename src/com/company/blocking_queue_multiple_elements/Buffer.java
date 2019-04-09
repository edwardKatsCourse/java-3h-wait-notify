package com.company.blocking_queue_multiple_elements;

import java.util.LinkedList;

public class Buffer<E> {

    private int maxCapacity;
    private LinkedList<E> elements;

    public Buffer(int maxCapacity) {
        this.maxCapacity = maxCapacity;
        this.elements = new LinkedList<>();
    }

    //Заказчик
    public synchronized void put(E newElement) throws InterruptedException {

        //0     10
        while (elements.size() >= maxCapacity) {
//            System.out.println("Maximum capacity reached");
            //wait-set
            this.wait(); //ждет notify от исполнителя
        }

        this.elements.add(newElement);
        this.notifyAll(); //wait() у исполнителя
    }

    //Исполнитель
    public synchronized E get() throws InterruptedException {

        while (this.elements.size() == 0) { //заказов нет
//            System.out.println("Minimal capacity reached");
            this.wait(); //жди пока появятся
        }

        //9
        //get (size - 1)
        //remove(size - 1) -> 8

        //poll
        E elementToReturn = elements.poll();

        this.notifyAll();

        return elementToReturn;
    }
}
