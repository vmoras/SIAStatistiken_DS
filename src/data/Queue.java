package data;

import java.io.*;

public class Queue<E> implements Serializable {
    private DoubleList<E> queue = new DoubleList<>();

    public Queue(){
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

    public Queue<E> copy() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(bo);
            o.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream i = new ObjectInputStream(bi);

            return (Queue<E>) i.readObject();
        }
        catch(Exception e) {
            return null;
        }
    }
}
