package serie3.graphs;

/**
 *  Vertice
 */
public class Vertex {

    public int id;

    public Edge adjList;

    public Vertex(int id){
        this(id, null);
    }

    public Vertex(int id, Edge adjList){
        this.id = id;
        this.adjList = adjList;
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
