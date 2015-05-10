package mylibrary.structures;

/**
 *
 */
public interface Queue<E> {
    public boolean isEmpty();
    public E enqueue(E item);
    public E dequeue();
    public E peek();
}
