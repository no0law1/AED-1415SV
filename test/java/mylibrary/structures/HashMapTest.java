package mylibrary.structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

/**
 *
 */
public class HashMapTest {

    @Test
    public void testPut() throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Primeiro");

        assertThat(map.get(1), is(equalTo("Primeiro")));
        assertThat(map.get(2), is(equalTo(null)));

    }

    @Test
    public void testGet() throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Primeiro");
        map.put(2, "Segundo");
        map.put(3, "Terceiro");
        map.put(4, "Quarto");

        assertThat(map.get(3), is(equalTo("Terceiro")));
    }

    @Test
    public void testRemove() throws Exception {
        HashMap<Integer, String> map = new HashMap<>();
        map.put(1, "Primeiro");
        map.put(2, "Segundo");
        map.put(3, "Terceiro");
        map.put(4, "Quarto");

        assertThat(map.remove(4), is(equalTo("Quarto")));
        assertThat(map.remove(2), is(equalTo("Segundo")));
    }
}