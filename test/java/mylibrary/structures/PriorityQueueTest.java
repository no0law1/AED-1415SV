package mylibrary.structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class PriorityQueueTest {

    @Test
    public void testAdd() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 0);
        queue.add("Primeiro", 10);

        assertThat(queue.peek(), is(equalTo("Primeiro")));
        queue.poll();
        queue.poll();
    }

    @Test
    public void testPeek() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 0);
        queue.add("Primeiro", 1);

        assertThat(queue.peek(), is(equalTo("Primeiro")));
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Segundo")));
        queue.poll();
    }

    @Test
    public void testPoll() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 0);
        queue.add("Primeiro", 10);

        String str = queue.poll();

        assertNotSame(queue.peek(), str);
    }

    @Test
    public void testUpdate() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Primeiro", 5);
        queue.add("Segundo", 4);
        queue.add("Terceiro", 3);
        queue.add("Quarto", 2);
        queue.add("Quinto", 1);
        int key = queue.add("Sexto", 0);

        queue.update(key, 6);

        assertThat(queue.peek(), is(equalTo("Sexto")));

    }

    @Test
    public void testUpdateMiddle() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Primeiro", 5);
        queue.add("Segundo", 4);
        queue.add("Terceiro", 2);
        queue.add("Quarto", 1);
        queue.add("Quinto", 0);
        int key = queue.add("Sexto", -1);

        queue.update(key, 3);

        queue.poll();
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Sexto")));

    }

    @Test
    public void testRemove() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Quarto", 0);
        int key = queue.add("Terceiro", 1);
        queue.add("Segundo", 2);
        queue.add("Primeiro", 3);

        queue.remove(key);

        assertThat(queue.peek(), is(equalTo("Primeiro")));
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Segundo")));
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Quarto")));
        queue.poll();
        assertThat(queue.peek(), is(equalTo(null)));
    }

    @Test
    public void testMeld() throws Exception {
        PriorityQueue<String> queue1 = new PriorityQueue<>();
        PriorityQueue<String> queue2 = new PriorityQueue<>();
    }
}