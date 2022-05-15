package data;

import java.io.*;
import java.util.List;

public class DoubleList<E> implements Serializable {
    private Node<E> head = null;
    private Node<E> tail = null;
    private int size = 0;

    public DoubleList(){
    }

    public DoubleList(List<E> list){
        for (E item: list){
            this.addLast(item);
        }
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

    public Node<E> getHead() {
        return this.head;
    }

    public Node<E> getTail() {
        return this.tail;
    }

    public int getSize(){
        return this.size;
    }

    public boolean isEmpty(){
        return this.size == 0;
    }

    public void add(E data){
        this.addLast(data);
    }

    public void remove(E data){
        if (this.head == null){
            return;
        }

        if (this.head.getData().equals(data)) {
            removeFirst();
            return;
        }

        else if (this.tail.getData().equals(data)){
            removeLast();
            return;
        }

        Node<E> headPtr = this.head;
        Node<E> tailPtr = this.tail;
        Node<E> deleteNode = null;

        while (true){
            if (headPtr.getData().equals(data)){
                deleteNode = headPtr;
                break;
            }
            if (tailPtr.getData().equals(data)){
                deleteNode =  tailPtr;
                break;
            }

            if (tailPtr.getData().equals(headPtr.getData())){
                return;
            }

            headPtr = headPtr.getNext();
            tailPtr = tailPtr.getPrev();
            if (headPtr == null || tailPtr == null){
                return;
            }
        }
        deleteNode.getPrev().setNext(deleteNode.getNext());
        deleteNode.getNext().setPrev(deleteNode.getPrev());
    }

    public void addFirst(E data){
        Node<E> first = this.head;
        Node<E> newNode = new Node<>(data);
        newNode.setNext(this.head);
        this.head = newNode;

        if (first == null){
            this.tail = newNode;
        } else{
            first.setPrev(newNode);
        }
        this.size++;
    }

    public void addLast(E data){
        Node<E> last = this.tail;
        Node<E> newNode = new Node<>(data);
        newNode.setPrev(this.tail);
        this.tail = newNode;

        if (last == null){
            this.head = newNode;
        } else{
            last.setNext(newNode);
        }
        this.size++;
    }

    public E removeFirst(){
        if (this.head == null){
            return null;
        }

        Node<E> remove = this.head;
        this.head = this.head.getNext();
        remove.setNext(null);
        if (this.head == null){
            this.tail = null;
        } else {
            this.head.setPrev(null);
        }

        this.size --;
        return remove.getData();
    }

    public E removeLast(){
        if (this.tail == null){
            return null;
        }

        Node<E> remove = this.tail;
        this.tail = this.tail.getPrev();
        remove.setPrev(null);

        if (this.tail == null){
            this.head = null;
        } else{
            this.tail.setNext(null);
        }
        this.size--;
        return remove.getData();
    }

    public E containsValue(Object data){
        Node<E> headPtr = this.head;
        Node<E> tailPtr = this.tail;

        if (headPtr == null){
            return null;
        }

        while (true){
            if (headPtr.getData().equals(data)){
                return headPtr.getData();
            }

            if (tailPtr.getData().equals(data)){
                return tailPtr.getData();
            }

            if (tailPtr.getData().equals(headPtr.getData())){
                break;
            }

            headPtr = headPtr.getNext();
            tailPtr = tailPtr.getPrev();
            if (headPtr == null || tailPtr == null){
                break;
            }

        }
        return null;
    }

    public String print(){
        StringBuilder info  = new StringBuilder();
        for (Node<E> ptr = this.head; ptr != null; ptr = ptr.getNext()){
            info.append(ptr.getData()).append("\n");
        }
        return info.toString();
    }

    public DoubleList<E> copy() {
        try {
            ByteArrayOutputStream bo = new ByteArrayOutputStream();
            ObjectOutputStream o = new ObjectOutputStream(bo);
            o.writeObject(this);

            ByteArrayInputStream bi = new ByteArrayInputStream(bo.toByteArray());
            ObjectInputStream i = new ObjectInputStream(bi);

            return (DoubleList<E>) i.readObject();
        }
        catch(Exception e) {
            return null;
        }
    }

    transient Node first;
    @java.io.Serial
    public void writeObject(java.io.ObjectOutputStream s) throws java.io.IOException {
        // Write out any hidden serialization magic
        first = tail;

        // Write out size
        s.writeInt(size);

        // Write out all elements in the proper order.
        for (first = tail; first.getData() != null; first = first.getPrev()){
            if(first.getPrev() == null){
                s.close();
                return;
            }

            s.writeObject(first.getData());
        }
    }
}
