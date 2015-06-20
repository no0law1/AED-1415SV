package mylibrary.structures;

import org.junit.Test;
import problemserie2.Product;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.core.IsEqual.equalTo;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotSame;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class PriorityQueueTest {

    @Test
    public void testAdd() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 10);
        queue.add("Primeiro", 0);

        assertThat(queue.peek(), is(equalTo("Primeiro")));
        queue.poll();
        queue.poll();
    }

    @Test
    public void testPeek() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 1);
        queue.add("Primeiro", 0);

        assertThat(queue.peek(), is(equalTo("Primeiro")));
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Segundo")));
        queue.poll();
    }

    @Test
    public void testPoll() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Segundo", 10);
        queue.add("Primeiro", 0);

        String str = queue.poll();

        assertNotSame(queue.peek(), str);
    }

    @Test
    public void testUpdate() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Primeiro", 1);
        queue.add("Segundo", 2);
        queue.add("Terceiro", 3);
        queue.add("Quarto", 4);
        queue.add("Quinto", 5);
        int key = queue.add("Sexto", 6);

        queue.update(key, 0);

        assertThat(queue.peek(), is(equalTo("Sexto")));

    }

    @Test
    public void testUpdateMiddle() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Primeiro", 0);
        queue.add("Segundo", 1);
        queue.add("Terceiro", 2);
        queue.add("Quarto", 4);
        queue.add("Quinto", 5);
        int key = queue.add("Sexto", 6);

        queue.update(key, 3);

        queue.poll();
        queue.poll();
        queue.poll();
        assertThat(queue.peek(), is(equalTo("Sexto")));

    }

    @Test
    public void testRemove() throws Exception {
        PriorityQueue<String> queue = new PriorityQueue<>();
        queue.add("Quarto", 3);
        int key = queue.add("Terceiro", 2);
        queue.add("Segundo", 1);
        queue.add("Primeiro", 0);

        queue.remove(key);

        assertThat(queue.poll(), is(equalTo("Primeiro")));
        assertThat(queue.poll(), is(equalTo("Segundo")));
        assertThat(queue.poll(), is(equalTo("Quarto")));
        assertThat(queue.peek(), is(equalTo(null)));
    }

    @Test
    public void testMeld() throws Exception {
        Product[] products = setUpForMeld();

        PriorityQueue<Product> queue1 = new PriorityQueue<>();
        queue1.add(products[0], (int) products[0].getLossValue());
        queue1.add(products[1], (int) products[1].getLossValue());
        queue1.add(products[2], (int) products[2].getLossValue());
        queue1.add(products[3], (int) products[3].getLossValue());

        PriorityQueue<Product> queue2 = new PriorityQueue<>();
        queue2.add(products[4], (int) products[4].getLossValue());
        queue2.add(products[5], (int) products[5].getLossValue());
        queue2.add(products[6], (int) products[6].getLossValue());

        PriorityQueue<Product> result = PriorityQueue.meld(queue1, queue2, "XML", Product::getCategory);

        assertEquals(result.poll(), products[5]);
        assertEquals(result.poll(), products[0]);
        assertEquals(result.poll(), products[4]);
        assertEquals(result.poll(), products[3]);
    }

    private Product[] setUpForMeld() {
        return new Product[]{
                new Product("XML", "Not Matter", 10.0f, 20.0f),
                new Product("XML1", "Not Matter", 10.0f, 20.0f),
                new Product("XML2", "Not Matter", 10.0f, 20.0f),
                new Product("XML", "Not Matter", 15.0f, 20.0f),
                new Product("XML", "Not Matter", 10.0f, 18.0f),
                new Product("XML", "Not Matter", 10.0f, 25.0f),
                new Product("XML3", "Not Matter", 10.0f, 25.0f)
        };
    }
}