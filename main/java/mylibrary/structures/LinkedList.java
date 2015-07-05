package mylibrary.structures;

import java.util.Iterator;

/**
 * Created by rcacheira on 04/07/15.
 */
public class LinkedList<E> {
    private Node<E> list;
    private int size;

    public LinkedList(){
        size = 0;
        list = new Node<>();
        list.next = list.previous = list;
    }

    public void add(E v){
        Node<E> toAdd = new Node<>(v);

        toAdd.next = list;
        toAdd.previous = list.previous;

        list.previous.next = toAdd;
        list.previous = toAdd;

        size++;
    }

    public Object[] toArray(){
        Object[] vertexes = new Object[size];
        Node<E> aux = list.next;
        for(int i = 0; i<size; i++){
            vertexes[i] = aux.value;
            aux = aux.next;
        }

        return vertexes;
    }

    public Iterator<E> reverseIterator(){
        return new Iterator<E>() {
            Node<E> aux = list.previous;
            E curr;

            @Override
            public boolean hasNext() {
                if(curr != null){
                    return true;
                }
                while(aux.value != null){
                    curr = aux.value;
                    aux = aux.previous;
                    return true;
                }
                return false;
            }

            @Override
            public E next() {
                if(hasNext()){
                    E aux = curr;
                    curr = null;
                    return aux;
                }
                throw new IllegalStateException();
            }
        };
    }
}
