package serie3;

/**
 *
 */
public class Node<E> {

    public E value;
    public Node<E> left;
    public Node<E> right;

    public Node(E value){
        this.value = value;
    }

    public Node(){
        this.value = null;
    }
}
