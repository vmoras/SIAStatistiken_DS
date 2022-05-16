package data;

import java.io.*;

public class Queue<E> implements Serializable {
    private DoubleList<E> queue = new DoubleList<>();

    public Queue(){
    }

    public Queue(Queue<E> copy){
        this.queue = new DoubleList<>(copy.queue);
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
}
