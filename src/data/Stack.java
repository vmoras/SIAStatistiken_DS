package data;

import java.io.Serializable;

public class Stack<E> implements Serializable {
    private DoubleList<E> stack  = new DoubleList<>();

    public Stack(){
    }

    public Stack(DoubleList<E> doubleList){
        this.stack = doubleList;
    }

    public void push(E item){
        stack.addFirst(item);
    }

    public E pop(){
        return stack.removeFirst();
    }

    public boolean isEmpty(){
        return stack.isEmpty();
    }

    public E containsValue(Object item){
        return stack.containsValue(item);
    }

    public int getSize(){
        return stack.getSize();
    }

    public void remove(E data){
        stack.remove(data);
    }

    public void get(int index){
        stack.get(index);
    }

    public Stack<E> copy() {
        return new Stack<>(stack.copy());
    }
}
