package mylibrary.structures.graphs;

import mylibrary.exception.SortException;
import mylibrary.structures.LinkedList;

/**
 *
 */
public class Graph {

    /**
     * Array of vertexes
     */
    private LinkedList<Vertex> vertexes;

    public Graph(){
        vertexes = new LinkedList<>();
    }

    public void addVertex(int id){
        vertexes.add(new Vertex(id));
    }

    public void addEdge(int src, int dst){
        Vertex vertexSrc = null;
        Vertex vertexDst = null;

        for (Vertex v : vertexes) {
            if(src == v.id){
                vertexSrc = v;
            }
            if(dst == v.id){
                vertexDst = v;
            }
        }

        if(vertexSrc == null || vertexDst == null){
            throw new IllegalArgumentException("Any of the vertexes not found");
        }
        vertexSrc.addEdge(vertexDst);
    }

    private boolean hasCircuit(Vertex src, Vertex test){
        if(test == src) return true;
        for(Edge edge = test.adjList; edge != null; edge=edge.next){
            if(hasCircuit(src, edge.adjacent))
                return true;
        }
        return false;
    }

    private boolean hasCircuit(Vertex v){
        if(v.adjList == null) return false;
        for(Edge edge = v.adjList; edge != null; edge=edge.next){
            if(hasCircuit(v, edge.adjacent))
                return true;
        }
        return false;
    }

    public LinkedList<Vertex> topologicalSort() throws SortException {
        LinkedList<Vertex> sorted = new LinkedList<>();
        for (Vertex v : vertexes) {
            if(hasCircuit(v))
                throw new SortException("graph with circuits can't be sorted");
            v.visited = false;
        }

        for (Vertex v : vertexes) {
            if(!v.visited){
                topologicalSort(sorted, v);
            }
        }

        return sorted;
    }

    private void topologicalSort(LinkedList<Vertex> sorted, Vertex v) {
        v.visited = true;

        for(Edge edge = v.adjList; edge != null; edge=edge.next){
            if(!edge.adjacent.visited) {
                topologicalSort(sorted, edge.adjacent);
            }
        }

        sorted.add(v);
    }

    public void clear(){
        vertexes = new LinkedList<>();
    }
}
