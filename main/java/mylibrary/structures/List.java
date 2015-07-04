package mylibrary.structures;

import mylibrary.structures.Node;
import mylibrary.structures.graphs.Vertex;

/**
 * Created by rcacheira on 04/07/15.
 */
public class List<E> {
    private Node<E> list;
    private int size;

    public List(){
        size = 0;
        list = null;
    }

    public void add(E v){
        Node<E> aux = new Node<>(v);
        aux.next = list;
        list = aux;
        size++;
    }

    public Object[] toArray(){
        Object[] vertexes = new Object[size];
        Node<E> aux = list;
        for(int i = size-1; i>=0; i--){
            vertexes[i] = aux.value;
            aux = aux.next;
        }

        return vertexes;
    }
}
