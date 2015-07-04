package mylibrary.structures.graphs;

/**
 *  Aresta
 */
public class Edge {

    public Edge next;

    public Vertex adjacent;

    public double weight;

    public Edge(Vertex adj, double weight){
        this(adj, weight, null);
    }

    public Edge(Vertex adj, double weight, Edge next){
        this.adjacent = adj;
        this.weight = weight;
        this.next = next;
    }
}
