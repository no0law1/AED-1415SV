package mylibrary.structures.graphs;

import mylibrary.structures.graphs.Edge;

/**
 *  Vertice
 */
public class Vertex {

    public int id;

    public Edge adjList;

    public boolean visited;

    public Vertex(int id){
        this(id, null);
    }

    public Vertex(int id, Edge adjList){
        this.id = id;
        this.adjList = adjList;
        visited = false;
    }

    public void addEdge(Vertex v){
        if(adjList == null){
            adjList = new Edge(v, 1);
            return;
        }
        Edge aux = adjList;

        if(aux.adjacent == v) return;

        while(aux.next!=null){
            aux = aux.next;
            if(aux.adjacent == v) return;
        }
        aux.next = new Edge(v, 1);
    }

    @Override
    public String toString() {
        return Integer.toString(id);
    }
}
