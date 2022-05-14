package data;

public class Node<E> implements java.io.Serializable{
    private E data;
    private Node<E> next = null;
    private Node<E> prev = null;

    public Node(E data){
        this.data = data;
    }

    public Node<E> getNext(){
      return this.next;
    }

    public Node<E> getPrev(){
        return this.prev;
    }

    public E getData() {
        return this.data;
    }

    public void setNext(Node<E> next) {
        this.next = next;
    }

    public void setPrev(Node<E> prev) {
        this.prev = prev;
    }

    public void setData(E data) {
        this.data = data;
    }
}
