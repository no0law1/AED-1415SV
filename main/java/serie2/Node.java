package serie2;

public class Node<E> {
	E value;
	Node<E> next;
	Node<E> previous;
	
	public Node(){}
	public Node(E value){ this.value=value;}

	/**
	 * Test Purposes
	 * @return
	 */
	@Override
	public String toString() {
		return value+"";
	}
}
