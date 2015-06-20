package mylibrary.structures;

/**
 * Queue interface.
 */
public interface Queue<E> {

    /**
     *
     * @return if queue is empty
     */
    public boolean isEmpty();

    /**
     *
     * @param item to add to queue.
     * @return {@code item}
     */
    public E enqueue(E item);

    /**
     * As queue is FIFO, the dequeue returns the first elment added.
     *
     * @return first in queue.
     */
    public E dequeue();

    /**
     *
     * @return first in queue, but does not remove it.
     */
    public E peek();
}
