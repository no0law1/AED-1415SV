package mylibrary.structures;


/**
 *  Doubly Linked List with Sentinel and Circular (Nuno)
 */
public class PriorityQueue<E> {
    public interface CategoryExtractor<E> {
        public String getValue(E e);
    }

    public class Node<E>{
        E value;
        Integer prio;   /** Defining priority. 10 most urgent, 0 less urgent */
        int key;        /** Key -> HashCode */

        public Node(E value, Integer prio){
            this.value = value;
            key = this.value.hashCode();
            this.prio = prio;
        }
    }

    private static final int DEFAULT_CAPACITY = 32;

    private Node<E>[] queue;
    private int size;

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity){
        queue = (Node<E>[]) new Node[capacity];
        size = 0;
    }

    public PriorityQueue(){
        this(DEFAULT_CAPACITY);
    }

    @SuppressWarnings("unchecked")
    private void grow() {
        Node<E>[] aux = (Node<E>[])new Node[size*2];
        for (int i = 0; i < queue.length; i++) {
            aux[i]=queue[i];
        }
        queue=aux;
    }

    public int add(E elem, int prio){
        if(size >= queue.length){
            grow();
        }
        Node<E> toAdd = new Node<>(elem, prio);
        increaseKey(size, toAdd);
        size++;

        return toAdd.key;
    }

    public E peek(){
        return size>0 ? queue[0].value : null;
    }

    public E poll(){
        if(size > 0) {
            Node<E> aux = queue[0];
            remove(queue[0].key);
            return aux.value;
        }
        return null;
    }

    /**
     * Not lg(n)
     * @param key
     * @param prio
     */
    public void update(int key, int prio){
        Integer aux = 0;
        for (int i = 0; i < size; i++) {
            if(key == queue[i].key){
                aux = queue[i].prio;
                queue[i].prio = prio;

                if(aux.compareTo(prio) > 0){
                    decreaseKey(i);
                } else {
                    increaseKey(i, queue[i]);
                }
                return;
            }
        }
        throw new IllegalArgumentException("No Such key to update");
    }

    /**
     * Not lg(n)
     * @param key
     */
    public void remove(int key){
        int i = 0;
        for (; i < size; i++) {
            if(key == queue[i].key){
                queue[i] = queue[--size];
                break;
            }
        }
        decreaseKey(i);
    }

    /**
     * Can't see priority of values of queue1 and queue2 to add to Priority Queue to return.
     *
     * @param queue1
     * @param queue2
     * @param category
     * @param categoryExtractor
     * @return
     */
    public PriorityQueue<E> meld(PriorityQueue<E> queue1,PriorityQueue<E> queue2, String category, CategoryExtractor<E> categoryExtractor){
        PriorityQueue<E> result = new PriorityQueue<>();

        while(queue1.peek()!=null && queue2.peek()!=null){
            E value1, value2;
            while(queue1.peek()!=null && categoryExtractor.getValue(value1 = queue1.poll()) != category);
            while(queue2.peek()!=null && categoryExtractor.getValue(value2 = queue2.poll()) != category);

            //TODO:

            value1 = value2 = null;
        }



        return result;
    }

    private void decreaseKey(int index) {
        int i, son;
        for(i = index; i*2+1 <= this.size-1; i = son) {
            son = i*2+1;
            if(son < this.size-1 && queue[son+1].prio.compareTo(queue[son].prio) > 0){
                son++;
            }
            if(queue[i].prio.compareTo(queue[son].prio) < 0){
                Node aux = queue[i];
                queue[i] = queue[son];
                queue[son] = aux;
            }
            else
                break;
        }
    }

    private void increaseKey(int start, Node<E> p) {
        int i;
        for(i = start; i > 0 ; i = (i-1)/2) {
            if(p.prio.compareTo(queue[(i-1)/2].prio) > 0){
                Node aux = queue[i];
                queue[i] = queue[(i - 1) / 2];
                queue[(i - 1) / 2] = aux;
            } else {
                break;
            }
        }
        queue[i] = p;
    }
}
