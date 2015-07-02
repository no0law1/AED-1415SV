package serie3.graphs;

import java.util.PriorityQueue;

/**
 * Minimum Spanning Tree
 */
public class MSTree {

    private static class Pair<K, V>{
        public K key;
        public V value;

        public Pair(K key, V value){
            this.key =key;
            this.value = value;
        }

        @Override
        public String toString() {
            return key.toString()+": "+(value == null ? "null" : value.toString());
        }
    }

    /**
     * Priority Queue of java util used,
     * because our Priority Queue used in series 2 was not usable in this circumstances.
     *
     * @param graph     Graph.
     * @param origId    Vertex id from origin
     * @param destId    Vertex id from end
     * @return  Don't know yet.
     */
    public static int isEdgeInAnMST(Vertex[] graph, int origId, int destId){
        PriorityQueue<Edge> queue = new PriorityQueue<>((Edge e1, Edge e2) -> Double.compare(e1.weight, e2.weight));

        Pair<Double, Vertex>[] dist = new Pair[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = new Pair<>(Double.MAX_VALUE, null);
        }

        dist[origId].key = (double) 0;

        Vertex last = graph[origId];
        Edge edge = graph[origId].adjList;
        do {
            while (edge != null) {
                if (dist[edge.adjacent.id].key > edge.weight) {
                    dist[edge.adjacent.id].key = edge.weight;
                    dist[edge.adjacent.id].value = last;
                    queue.add(edge);
                }
                edge = edge.next;
            }
            edge = queue.poll();
            last = edge.adjacent;
            edge = edge.adjacent.adjList;
        }while(!queue.isEmpty());

        if (dist[destId].value != null && dist[destId].value.id == origId) {
            return 1;
        }
        return -1;
    }
}
