package mylibrary.structures;

/**
 *
 */
public class QueueNode<E> implements Queue<E> {

    private class Node<E>{
        E item;
        Node<E> next;
        Node<E> previous;

        public Node(){}
        public Node(E item){ this.item = item;}
    }

    private Node<E> queue;

    public QueueNode(){
        queue = new Node<>(null);
        queue.next = queue.previous = queue;
    }

    @Override
    public boolean isEmpty() {
        return queue.next == queue;
    }

    @Override
    public E enqueue(E item) {
        Node<E> toAdd = new Node<>(item);

        toAdd.next = queue;
        toAdd.previous = queue.previous;

        queue.previous.next = toAdd;
        queue.previous = toAdd;
        return item;
    }

    @Override
    public E dequeue() {
        E item = peek();

        queue.next = queue.next.next;
        queue.next.next.previous = queue;

        return item;
    }

    @Override
    public E peek() {
        return queue.next.item;
    }
}
