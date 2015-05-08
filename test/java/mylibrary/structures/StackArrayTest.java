package mylibrary.structures;

import org.junit.Test;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

/**
 *
 */
public class StackArrayTest {

    @Test
    public void testIsEmpty() throws Exception {
        StackArray<Integer> stack = new StackArray<>();
        assertTrue(stack.isEmpty());

        stack.push(1);
        assertFalse(stack.isEmpty());
    }

    @Test
    public void testPush() throws Exception {
        StackArray<Integer> stack = new StackArray<>();
        Integer i = new Integer(24);

        assertEquals(i, stack.push(i));
    }

    @Test (expected = IllegalStateException.class)
    public void testPushException(){
        StackArray<Integer> stack = new StackArray<>(2);
        stack.push(1);
        stack.push(2);
        stack.push(3);
    }

    @Test
    public void testPop() throws Exception {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);

        assertThat(3, is(equalTo(stack.pop())));
        assertThat(2, is(equalTo(stack.pop())));
        assertThat(1, is(equalTo(stack.pop())));

    }

    @Test (expected = IllegalStateException.class)
    public void testPopException() throws Exception {
        StackArray<Integer> stack = new StackArray<>();
        stack.push(1);

        stack.pop();
        stack.pop();
    }

    @Test
    public void testPeek() throws Exception {
        StackArray<Integer> stack = new StackArray<>();

    }

    @Test
    public void testMaxSize() throws Exception {
        StackArray<Integer> stack = new StackArray<>(2);
        stack.push(1);
        stack.push(2);

        assertTrue(stack.isFull());
    }
}