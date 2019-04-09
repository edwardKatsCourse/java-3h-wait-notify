package com.company.blocking_queue;

public class Buffer {

    //LinkedList
    private Integer bufferElement;

    //Заказчик
    public synchronized void put(Integer newElement) throws InterruptedException {

        while (bufferElement != null) {
            //wait-set
            this.wait(); //ждет notify от исполнителя
        }

        this.bufferElement = newElement;
        this.notifyAll(); //wait() у исполнителя
    }

    //Исполнитель
    public synchronized Integer get() throws InterruptedException {

        while (bufferElement == null) { //заказов нет
            this.wait(); //жди пока появятся
        }

        Integer elementToReturn = this.bufferElement;
        this.bufferElement = null;
        this.notifyAll();

        return elementToReturn;
    }
}
