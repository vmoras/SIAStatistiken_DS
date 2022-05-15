package data;

import java.io.*;

public class Queue<E> implements Serializable {
    private DoubleList<E> queue = new DoubleList<>();

    public Queue(){
    }

    public Queue(DoubleList<E> doubleList){
        this.queue = doubleList;
    }

    public void enqueue(E item){
        queue.addLast(item);
    }

    public E dequeue(){
        return queue.removeFirst();
    }

    public boolean isEmpty(){
        return queue.isEmpty();
    }

    public E containsValue(Object item){
        return queue.containsValue(item);
    }

    public int getSize(){
        return queue.getSize();
    }

    public void remove(E data){
        queue.remove(data);
    }

    public void get(int index){
        queue.get(index);
    }

    public Queue<E> copy() {
        return new Queue<>(queue.copy());
    }
}
