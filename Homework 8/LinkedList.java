//In order to help learn course concepts, I worked on the homework with Robert Pigue and
//discussed homework topics and issues with Robert Pigue, but did not consult any related material.

/**
* class that manages LinkedList objects.
* @param <E> type of data to store in LinkedList
* @author Sahit Kavukuntla
* @version 1.0
*/
public class LinkedList<E> implements List<E>, Stack<E> {
    private Node<E> head;

    /**
    * method that creates LinkedLists.
    */
    public LinkedList() {
        head = null;
    }

    /**
    * method that returns Node head.
    * @return Node head Node
    */
    public Node<E> getHead() {
        return head;
    }

    @Override
    public void add(int index, E element) {
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is invalid");
        }
        if (element == null) {
            throw new NullPointerException("Cannot add null data to list");
        }

        //loop through code then do below

        Node<E> newNode = new Node(element, null);

        if (this.size() == 0) {
            head = newNode;
        } else {
            if (index == 0) {
                newNode.setNext(head);
                head = newNode;
            } else if (index == this.size() - 1) {
                this.getNode(this.size() - 1).setNext(newNode);
            } else {
                Node<E> current = head;
                for (int i = 0; i < index; i++) {
                    current = current.getNext();
                }
                newNode.setNext(current);
                this.getNode(index - 1).setNext(newNode);

            }
        }

        // Node<E> newNode = new Node(element, this.getNode(index - 1));
        // this.getNode(index - 1).setNext(newNode);

        // if (index == this.size() - 1) {
        //     Node<E> newNode = new Node(element, null);
        //     this.getNode(index - 1).setNext(newNode);
        // } else if (this.size() == 0) {
        //     Node<E> newNode = new Node(element, null);
        //     head = newNode;
        // } else if (this.size() == 1) {
        //     if (index == 0) {
        //         Node<E> newNode = new Node(element, head);
        //         head = newNode;
        //     } else {
        //         Node<E> newNode = new Node(element, null);
        //         head.setNext(newNode);
        //     }
        // } else if (index > 0 || index < this.size() - 1) {
        //     Node<E> newNode = new Node(element, this.getNode(index + 1));
        //     this.getNode(index - 1).setNext(newNode);
        // }


        // Node<E> n = new Node(element, this.getNode(index + 1));
        // if (this.size() == 1) {
        //     head = n;
        // }
        // this.getNode(index - 1).setNext(n);
    }

    @Override
    public boolean remove(E element) {
        if (!this.contains(element)) {
            return false;
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.getNode(i).getData().equals(element)) {
                this.remove(i);
                return true;
            }
        }
        return false;
    }

    @Override
    public E remove(int index) {
        //check if head is null
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is invalid");
        }
        E el = this.getNode(index).getData();
        if (this.size() == 1) {
            head = null;
            return el;
        }
        if (index > 0 && index < this.size() - 2) {
            this.getNode(index - 1).setNext(this.getNode(index + 1));
            return el;
        }
        if (index == 0) {
            head = this.getNode(1);
            return el;
        }
        if (index == this.size() - 1) {
            this.getNode(index - 1).setNext(null);
            return el;
        }
        return el;
    }

    @Override
    public E get(int index) {
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is invalid");
        }
        Node<E> current = this.getHead();
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current.getData();
            }
            i++;
            current = current.getNext();
        }
        return null;
    }

    @Override
    public E set(int index, E element) {
        if (index < 0 || index > this.size() - 1) {
            throw new IllegalArgumentException("Your index is invalid");
        }
        if (element == null) {
            throw new NullPointerException("Cannot add null data to list");
        }
        E el = this.getNode(index).getData();
        this.getNode(index).setData(element);
        return el;
    }

    @Override
    public boolean contains(E element) {
        if (element == null) {
            throw new NullPointerException("Null data cannot be in list");
        }
        for (int i = 0; i < this.size(); i++) {
            if (this.getNode(i).getData().equals(element)) {
                return true;
            }
        }
        return false;
    }

    @Override
    public void clear() {
        Node<E> current = new Node(this.getHead());
        while (current != null) {
            this.remove(0);
            current = this.getHead();
        }
    }

    @Override
    public boolean isEmpty() {
        return this.getHead() == null;
    }

    @Override
    public int size() {
        Node<E> current = this.getHead();
        int count = 0;
        while (current != null) {
            count++;
            current = current.getNext();
        }
        return count;
    }

    @Override
    public E push(E element) {
        if (element == null) {
            throw new NullPointerException("Cannot add null data to stack");
        }
        Node<E> n = new Node(element, this.getHead());
        head = n;
        return n.getData();
    }

    @Override
    public E pop() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Empty stack");
        }
        E el = this.getNode(0).getData();
        head = this.getNode(1);
        return el;
    }

    @Override
    public E peek() {
        if (this.isEmpty()) {
            throw new IllegalArgumentException("Empty stack");
        }
        return this.get(0);
    }

    /**
    * method that returns Node from LinkedList.
    * @param index the index of Node to get from LinkedList
    * @return Node node at index
    */
    public Node<E> getNode(int index) {
        if (index > this.size() - 1) {
            return null;
        }
        Node<E> current = this.getHead();
        int i = 0;
        while (current != null) {
            if (i == index) {
                return current;
            }
            i++;
            current = current.getNext();
        }
        return null;
    }
}