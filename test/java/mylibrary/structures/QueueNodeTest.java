package mylibrary.structures;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

/**
 *
 */
public class QueueNodeTest {

    @Test
    public void testIsEmptyFalse() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals((Integer)1, queue.enqueue(1));

        assertEquals(false, queue.isEmpty());
    }

    @Test
    public void testIsEmptyTrue() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testEnqueue() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals((Integer)1, queue.enqueue(1));
        assertEquals((Integer)2, queue.enqueue(2));
        assertEquals((Integer)3, queue.enqueue(3));
        assertEquals((Integer)4, queue.enqueue(4));
        assertEquals((Integer)5, queue.enqueue(5));

        assertEquals(false, queue.isEmpty());
        assertEquals((Integer)1, queue.peek());

        assertEquals((Integer)1, queue.dequeue());
        assertEquals((Integer)2, queue.dequeue());
        assertEquals((Integer)3, queue.dequeue());
        assertEquals((Integer)4, queue.dequeue());
        assertEquals((Integer)5, queue.dequeue());

        assertEquals(null, queue.peek());

        assertEquals(true, queue.isEmpty());
    }

    @Test
    public void testDequeue() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals((Integer)1, queue.enqueue(1));
        assertEquals((Integer)2, queue.enqueue(2));
        assertEquals((Integer)3, queue.enqueue(3));

        assertEquals((Integer)1, queue.dequeue());
        assertEquals((Integer)2, queue.dequeue());
        assertEquals((Integer)3, queue.dequeue());

        assertEquals(null, queue.dequeue());
    }

    @Test
    public void testPeekNotNull() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals((Integer)1, queue.enqueue(1));
        assertEquals((Integer)2, queue.enqueue(2));
        assertEquals((Integer)3, queue.enqueue(3));

        assertEquals((Integer)1, queue.peek());
        queue.dequeue();
        assertEquals((Integer)2, queue.peek());

    }

    @Test
    public void testPeekNull() throws Exception {
        QueueNode<Integer> queue = new QueueNode<>();

        assertEquals((Integer)1, queue.enqueue(1));
        assertEquals((Integer)2, queue.enqueue(2));
        assertEquals((Integer)3, queue.enqueue(3));

        assertEquals((Integer)1, queue.dequeue());
        assertEquals((Integer)2, queue.dequeue());
        assertEquals((Integer)3, queue.dequeue());

        assertEquals(null, queue.peek());
    }
}