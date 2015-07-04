package serie3.graphs;

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
     *
     * @param graph     Graph.
     * @param origId    Vertex id from origin
     * @param destId    Vertex id from end
     * @return  Don't know yet.
     */
    public static int isEdgeInAnMST(Vertex[] graph, int origId, int destId){
        PriorityQueue<Edge, Double> queue = new PriorityQueue<>();
        boolean[] visited = new boolean[graph.length];

        Pair<Double, Vertex>[] dist = new Pair[graph.length];
        for (int i = 0; i < dist.length; i++) {
            dist[i] = new Pair<>(Double.MAX_VALUE, null);
        }

        dist[origId].key = (double) 0;

        Vertex last = graph[origId];
        Edge edge = graph[origId].adjList;
        do {
            visited[last.id] = true;
            while (edge != null) {
                if (!visited[edge.adjacent.id] && dist[edge.adjacent.id].key > edge.weight) {
                    dist[edge.adjacent.id].key = edge.weight;
                    dist[edge.adjacent.id].value = last;
                    queue.add(edge, edge.weight);
                }
                edge = edge.next;
            }

            do {
                edge = queue.poll();
                if(edge == null){
                    break;
                }
                last = edge.adjacent;
                edge = edge.adjacent.adjList;
            } while (visited[last.id]);
        }while(!queue.isEmpty());

        if (dist[destId].value.id == origId) {
            return 1;
        }
        return -1;
    }
}
