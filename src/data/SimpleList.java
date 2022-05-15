package data;

import java.io.*;
import java.util.List;

public class SimpleList<E> implements Serializable {
    private Node<E> head = null;
    private int size = 0;

    public SimpleList(){
    }

    public SimpleList(List<E> list){
        for (E item: list){
            this.addLast(item);
        }
    }

    public Node<E> getHead() {
        return this.head;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public E get(int index){
        if (index > this.size-1){
            return null;
        }
        Node<E> ptr = this.head;
        for (int i = 0; i < index; i++){
            ptr = ptr.getNext();
        }
        return ptr.getData();
    }

    public void add(E data){
        this.addLast(data);
    }

    public void addFirst(E data){
        Node<E> newNode = new Node<>(data);
        if (this.head == null){
            this.head = newNode;
            this.size++;
            return;
        }
        newNode.setNext(this.head);
        this.head = newNode;
        this.size++;
    }

    public void addLast(E data){
        Node<E> newNode = new Node<>(data);
        if (this.head == null){
            this.head = newNode;
            this.size ++;
            return;
        }

        Node<E> ptr = this.head;
        while (ptr.getNext() != null) {
            ptr = ptr.getNext();
        }
        ptr.setNext(newNode);
        newNode.setNext(null);
        this.size++;
    }

    public void remove(E data){
        if (this.head == null){
            return;
        }

        if (this.head.getData().equals(data)) {
            removeFirst();
            return;
        }

        Node<E> deleteNode = null;
        Node<E> prev = null;
        for (Node<E> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            if (data.equals(ptr.getData())){
                deleteNode = ptr;
                break;
            }
            prev = ptr;
        }
        if (deleteNode == null){
            return;
        }
        prev.setNext(deleteNode.getNext());
        this.size --;
    }

    public E removeFirst(){
        if (this.head == null){
            return null;
        }
        Node<E> remove = this.head;
        this.head = this.head.getNext();
        remove.setNext(null);
        this.size --;
        return remove.getData();
    }

    public E removeLast(){
        if (this.head == null || this.head.getNext() == null){
            this.head = null;
            this.size --;
            return null;
        }

        Node<E> ptr = this.head;
        while (ptr.getNext().getNext() != null){
            ptr = ptr.getNext();
        }

        Node<E> remove = ptr.getNext();
        ptr.setNext(null);
        this.size--;
        return remove.getData();
    }

    public E containsValue(Object data){
        for (Node<E> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            if (data.equals(ptr.getData())){
                return ptr.getData();
            }
        }
        return null;
    }

    public String print(){
        StringBuilder info  = new StringBuilder();
        for (Node<E> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            info.append(ptr.getData()).append(" ");
        }
        return info.toString();
    }

    public SimpleList<E> copy() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(bo);
            o.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream i = new ObjectInputStream(bi);

            return (SimpleList<E>) i.readObject();
        }
        catch(Exception e) {
            return null;
        }
    }

    transient Node first;
    @java.io.Serial
    // FIXME
    private void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        // Write out any hidden serialization magic
        s.defaultWriteObject();

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (head  = first; first != null; first = first.getNext())
            s.writeObject(first.getData());
    }
}
