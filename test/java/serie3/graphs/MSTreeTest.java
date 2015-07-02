package serie3.graphs;

import org.junit.BeforeClass;
import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static serie3.graphs.MSTree.*;

/**
 *
 */
public class MSTreeTest {

    private static Vertex[] graph;

    @BeforeClass
    public static void setUp(){
        graph = new Vertex[9];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new Vertex(i);
        }
        graph[0].adjList = new Edge(graph[1], 4, new Edge(graph[7], 8));
        graph[1].adjList = new Edge(graph[7], 11, new Edge(graph[2], 8, new Edge(graph[0], 4)));
        graph[2].adjList = new Edge(graph[8], 2, new Edge(graph[5], 4, new Edge(graph[3], 7, new Edge(graph[1], 8))));
        graph[3].adjList = new Edge(graph[2], 7, new Edge(graph[4], 9, new Edge(graph[5], 14)));
        graph[4].adjList = new Edge(graph[3], 9, new Edge(graph[5], 10));
        graph[5].adjList = new Edge(graph[3], 14, new Edge(graph[4], 10, new Edge(graph[6], 2, new Edge(graph[2], 4))));
        graph[6].adjList = new Edge(graph[5], 2, new Edge(graph[7], 1, new Edge(graph[8], 6)));
        graph[7].adjList = new Edge(graph[6], 1, new Edge(graph[8], 7, new Edge(graph[1], 11, new Edge(graph[0], 8))));
        graph[8].adjList = new Edge(graph[7], 7, new Edge(graph[6], 6, new Edge(graph[2], 2)));
    }

    @Test
    public void testIsEdgeInAnMSTTrue() throws Exception {
        assertEquals(1, isEdgeInAnMST(graph, 0, 1));

        assertEquals(1, isEdgeInAnMST(graph, 2, 3));
    }

    @Test
    public void testIsEdgeInAnMSTFalse() throws Exception {
        assertEquals(-1, isEdgeInAnMST(graph, 0, 7));

        assertEquals(-1, isEdgeInAnMST(graph, 5, 4));
    }
}