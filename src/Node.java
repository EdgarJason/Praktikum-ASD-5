public class Node<T>{
    T data;
    Node<T> next;
    Node<T> prev;

    public Node(T data){
        this.data = data;
        this.prev = null;
        this.next = null;
    }

}