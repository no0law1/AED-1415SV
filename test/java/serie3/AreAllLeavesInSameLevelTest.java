package serie3;

import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import static serie3.TreeUtils.areAllLeavesInSameLevel;

/**
 *
 */
public class AreAllLeavesInSameLevelTest {

    @Test
    public void testAreAllLeavesInSameLevelEmpty(){
        assertTrue(areAllLeavesInSameLevel(null));
    }

    @Test
    public void testAreAllLeavesInSameLevelTrue(){
        Node<Integer> path = new Node<>(30);
        path.left = new Node<>(20);
        path.right = new Node<>(40);

        path.left.left = new Node<>(10);
        path.left.right = new Node<>(25);

        path.right.left = new Node<>(37);
        path.right.right = new Node<>(45);

        assertTrue(areAllLeavesInSameLevel(path));
    }

    @Test
     public void testAreAllLeavesInSameLevelTrueNotPerfect(){
        Node<Integer> path = new Node<>(30);
        path.left = new Node<>(20);
        path.right = new Node<>(40);

        path.left.left = new Node<>(10);
        path.left.right = new Node<>(25);

        path.right.left = new Node<>(37);

        assertTrue(areAllLeavesInSameLevel(path));
    }

    @Test
    public void testAreAllLeavesInSameLevelFalseWithSemiCompleteTree(){
        Node<Integer> path = new Node<>(30);
        path.left = new Node<>(20);
        path.right = new Node<>(40);

        path.left.left = new Node<>(10);
        path.left.right = new Node<>(25);

        assertFalse(areAllLeavesInSameLevel(path));
    }
}
