package serie3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static serie3.TreeUtils.hasPathWithAtLeastSum;

/**
 *
 */
public class HasPathWithAtLeastSumTest {

    @Test
    public void testHasPathWithAtLeastSumTrue() throws Exception {

        Node<Integer> path = new Node<>(8);
        path.left = new Node<>(3);
        path.right = new Node<>(10);

        path.left.left = new Node<>(1);
        path.left.right = new Node<>(6);

        path.left.right.left = new Node<>(4);
        path.left.right.right = new Node<>(7);

        path.right.right = new Node<>(14);
        path.right.right.left = new Node<>(13);

        assertTrue(hasPathWithAtLeastSum(path, 8));

        assertTrue(hasPathWithAtLeastSum(path, 32));

        assertTrue(hasPathWithAtLeastSum(path, 12));

        assertTrue(hasPathWithAtLeastSum(path, 4));
    }

    @Test
    public void testHasPathWithAtLeastSumFalse() throws Exception {

        Node<Integer> path = new Node<>(8);
        path.left = new Node<>(3);
        path.right = new Node<>(10);

        path.left.left = new Node<>(1);
        path.left.right = new Node<>(6);

        path.left.right.left = new Node<>(4);
        path.left.right.right = new Node<>(7);

        path.right.right = new Node<>(14);
        path.right.right.left = new Node<>(13);

        assertFalse(hasPathWithAtLeastSum(path, 99));
    }
}