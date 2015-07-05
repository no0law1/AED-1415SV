package serie3;

import org.junit.BeforeClass;
import org.junit.Test;

import static junit.framework.Assert.assertNull;
import static org.junit.Assert.assertEquals;
import static serie3.TreeUtils.lowestCommonAncestor;

/**
 *
 */
public class LowestCommonAncestorTest {

    private static Node<Integer> path;

    @BeforeClass
    public static void setUp(){
        path = new Node<>(17);
        path.left = new Node<>(9);
        path.right = new Node<>(20);

        path.left.left = new Node<>(3);
        path.left.right = new Node<>(11);

        path.right.left = new Node<>(19);
        path.right.right = new Node<>(22);

        path.left.left.left = new Node<>(-3);
        path.left.left.right = new Node<>(8);
    }

    @Test
    public void testLowestCommonAncestorFromPdf(){
        assertEquals(path.right, lowestCommonAncestor(path, 19, 20));
    }

    @Test
    public void testLowestCommonAncestorFirstNode(){
        assertEquals(path, lowestCommonAncestor(path, 22, -3));
    }

    @Test
    public void testLowestCommonAncestorNull(){
        assertNull(lowestCommonAncestor(path, 23, -4));
    }
}
