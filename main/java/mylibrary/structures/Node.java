package mylibrary.structures;

public class Node<E> {
	public E value;
	public Node<E> next;
	public Node<E> previous;
	
	public Node(){}
	public Node(E value){ this.value=value;}
}
