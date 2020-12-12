/**
* class that manages Node objects.
* @param <T> type of data to store in Node
* @author Sahit Kavukuntla
* @version 1.0
*/
public class Node<T> {
    private T data;
    private Node next;

    /**
    * method that creates Node objects.
    * @param data data to store in Node
    * @param next the next Node
    */
    public Node(T data, Node next) {
        this.data = data;
        this.next = next;
    }

    /**
    * method that creates Node objects.
    * @param data data to store in Node
    */
    public Node(T data) {
        this(data, null);
    }

    /**
    * method that returns Node data.
    * @return T data
    */
    public T getData() {
        return data;
    }

    /**
    * method that sets Node data.
    * @param data data to store in Node
    */
    public void setData(T data) {
        this.data = data;
    }

    /**
    * method that returns the next Node.
    * @return Node next
    */
    public Node getNext() {
        return next;
    }

    /**
    * method that sets the next Node.
    * @param next the next Node
    */
    public void setNext(Node next) {
        this.next = next;
    }
}