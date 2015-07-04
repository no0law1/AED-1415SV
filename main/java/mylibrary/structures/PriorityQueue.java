package mylibrary.structures;


import java.util.Comparator;

/**
 *  Doubly Linked List with Sentinel and Circular (Nuno)
 */
public class PriorityQueue<E> {
    public interface CategoryExtractor<E> {
        String getValue(E e);
    }

    public static class Node<E>{
        E value;
        Integer prio;   /** Defining priority. 10 less urgent, 0 most urgent */
        int key;        /** Key -> HashCode */

        public Node(E value, Integer prio){
            this.value = value;
            key = this.value.hashCode();
            this.prio = prio;
        }

        @Override
        public String toString() {
            return key+" : "+value.toString();
        }
    }

    /**
     * Key, key of node, ie. hashcode.
     * Value, index on queue.
     */
    private HashMap<Integer, Integer> map;

    private static final int DEFAULT_CAPACITY = 32;

    private Node<E>[] queue;

    private int size;

    private Comparator<Integer> cmp;

    public PriorityQueue(Comparator<Integer> cmp){
        this(DEFAULT_CAPACITY, cmp);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity){
        this(capacity, null);
    }

    public PriorityQueue(){
        this(DEFAULT_CAPACITY, null);
    }

    @SuppressWarnings("unchecked")
    public PriorityQueue(int capacity, Comparator<Integer> cmp){
        queue = (Node<E>[]) new Node[capacity];
        map = new HashMap<>(capacity);
        size = 0;
        this.cmp = cmp;
    }

    @SuppressWarnings({"unchecked", "ManualArrayCopy"})
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
        map.put(toAdd.key, size);
        queue[size] = toAdd;
        increaseKey(size);
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

    public void update(int key, int prio) {
        if(cmp==null){
            updateNoCmp(key, prio);
        } else {
            updateCmp(key, prio);
        }
    }

    private void updateCmp(int key, int prio) {
        Integer index = map.get(key);

        if (index != null) {
            Integer aux = queue[index].prio;
            queue[index].prio = prio;

            if (cmp.compare(aux, prio) < 0) {
                decreaseKeyCmp(index);
            } else {
                increaseKeyCmp(index);
            }
            return;
        }

        throw new IllegalArgumentException("No Such key to update");
    }

    private void updateNoCmp(int key, int prio) {
        Integer index = map.get(key);

        if (index != null) {
            Integer aux = queue[index].prio;
            queue[index].prio = prio;

            if (aux.compareTo(prio) < 0) {
                decreaseKeyNoCmp(index);
            } else {
                increaseKeyNoCmp(index);
            }
            return;
        }

        throw new IllegalArgumentException("No Such key to update");
    }

    public void remove(int key){
        Integer i = map.get(key);
        if(i != null){
            queue[i] = queue[--size];
            map.put(queue[size].key, i);
            decreaseKey(i);
            map.remove(key);
        }
    }

    public E getValue(int key){
        int index = map.get(key);
        return queue[index].value;
    }

    public static <E> PriorityQueue<E> meld(PriorityQueue<E> queue1, PriorityQueue<E> queue2, String category, CategoryExtractor<E> categoryExtractor){
        PriorityQueue<E> result = new PriorityQueue<>();

        extractAllIfSameCategory(result, queue1, category, categoryExtractor);
        extractAllIfSameCategory(result, queue2, category, categoryExtractor);

        return result;
    }

    private static <E> void extractAllIfSameCategory(PriorityQueue<E> dst, PriorityQueue<E> src, String category, CategoryExtractor<E> categoryExtractor){
        for (int i = 0; i < src.size; i++) {
           if(addIfCategory(dst, src.queue[i], category, categoryExtractor)){
               src.remove(src.queue[i].key);
               i--;
           }
        }
    }

    private static <E> boolean addIfCategory(PriorityQueue<E> dst, Node<E> node, String category, CategoryExtractor<E> categoryExtractor){
        if(categoryExtractor.getValue(node.value).equals(category)){
            dst.add(node.value, node.prio);
            return true;
        }
        return false;
    }

    private void decreaseKey(int index) {
        if(cmp == null){
            decreaseKeyNoCmp(index);
        } else {
            decreaseKeyCmp(index);
        }
    }

    private void decreaseKeyCmp(int index) {
        int i, son;
        for(i = index; i*2+1 <= this.size-1; i = son) {
            son = i*2+1;
            if(son < this.size-1 && cmp.compare(queue[son].prio, queue[son+1].prio) > 0){
                son++;
            }
            if(cmp.compare(queue[i].prio, queue[son].prio) > 0){
                Node<E> aux = queue[i];
                queue[i] = queue[son];
                map.put(queue[son].key, i);

                queue[son] = aux;
                map.put(aux.key, son);
            }
            else
                break;
        }
    }

    private void decreaseKeyNoCmp(int index) {
        int i, son;
        for(i = index; i*2+1 <= this.size-1; i = son) {
            son = i*2+1;
            if(son < this.size-1 && queue[son].prio.compareTo(queue[son+1].prio) > 0){
                son++;
            }
            if(queue[i].prio.compareTo(queue[son].prio) > 0){
                Node<E> aux = queue[i];
                queue[i] = queue[son];
                map.put(queue[son].key, i);

                queue[son] = aux;
                map.put(aux.key, son);
            }
            else
                break;
        }
    }

    private void increaseKey(int index) {
        if(cmp == null){
            increaseKeyNoCmp(index);
        } else {
            increaseKeyCmp(index);
        }
    }

    private void increaseKeyCmp(int index) {
        int i;
        for(i = index; i > 0 ; i = (i-1)/2) {
            if(cmp.compare(queue[i].prio, queue[(i-1)/2].prio) < 0){
                Node<E> aux = queue[i];

                queue[i] = queue[(i - 1) / 2];
                map.put(queue[(i - 1) / 2].key, i);

                queue[(i - 1) / 2] = aux;
                map.put(aux.key, (i - 1) / 2);
            } else {
                break;
            }
        }
    }

    private void increaseKeyNoCmp(int index) {
        int i;
        for(i = index; i > 0 ; i = (i-1)/2) {
            if(queue[i].prio.compareTo(queue[(i-1)/2].prio) < 0){
                Node<E> aux = queue[i];

                queue[i] = queue[(i - 1) / 2];
                map.put(queue[(i - 1) / 2].key, i);

                queue[(i - 1) / 2] = aux;
                map.put(aux.key, (i - 1) / 2);
            } else {
                break;
            }
        }
    }
}
