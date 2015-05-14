package serie2;

import mylibrary.arrays.Heap;

import java.util.Comparator;

/**
 *
 */
public class ListUtils {

    /**
     * que dada a lista simplesmente ligada sem sentinela e n�o circular referenciada por list, ordenada de modo crescente
     * segundo o comparador cmp, retorna se existir, o k-�simo maior elemento presente na lista. Caso a lista tenha menos de k
     * elementos, o m�todo dever� retorna null. Considere que cada objeto do tipo Node<E> tem dois campos: um value e
     * uma refer�ncia, next. NOTA: na resolu��o deste exerc�cio, apenas dever� ser utilizado o campo next da classe Node.

     * @param list
     * @param k
     * @param cmp
     * @param <E>
     * @return
     */
    public static <E> E getKBiggest(Node<E> list, int k, Comparator<E> cmp) {
        if ( list == null || k <= 0 ) return null;
        int n = 1;
        Node<E> kNode = list;
        Node<E> lastNode = list;
        while( n++ < k ){
            lastNode = lastNode.next;
            if(lastNode.next == null) break;
        }
        if( n < k ) return null;
        while( lastNode.next != null ){
            lastNode = lastNode.next;
            kNode = kNode.next;
        }
        return kNode.value;
    }

    public static <E> void removeFromList(Node<E> node){
        if(node.next != null) node.next.previous = node.previous;
        if(node.previous != null) node.previous.next = node.next;
    }

    public static <E> void addToList(Node<E> list, Node<E> node){
        node.next = list;
        node.previous = list.previous;
        list.previous.next = node;
        list.previous = node;
    }

    private static class NodeComparator<E> implements Comparator<Node<E>>{

        private Comparator<E> cmp;

        public NodeComparator(Comparator<E> cmp){
            if(cmp == null)
                throw new IllegalArgumentException("cmp can't be null");
            this.cmp = cmp;
        }

        @Override
        public int compare(Node<E> o1, Node<E> o2) {
            if(o1 == null) return Integer.MAX_VALUE;
            if(o2 == null) return Integer.MIN_VALUE;
            return cmp.compare(o1.value, o2.value);
        }
    }

    public static <E> Node<E> occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k) {

        NodeComparator ncmp = new NodeComparator(cmp);

        Node<E> returnList = new Node<>();
        returnList.next = returnList.previous = returnList;

        int heapSize = lists.length;
        Heap.buildMinHeap(lists, heapSize, ncmp);

        Node currentNode = lists[0];
        int count = 0;

        for(;lists[0] != null;){
            if(ncmp.compare(currentNode, lists[0]) == 0){
                count++;
            }
            else{
                if(count >= k){
                    removeFromList(currentNode);
                    addToList(returnList, currentNode);
                }
                currentNode = lists[0];
                count = 1;
            }
            lists[0] = lists[0].next;
            Heap.minHeapify(lists, 0, heapSize, ncmp);
        }

        if(count >= k){
            removeFromList(currentNode);
            addToList(returnList, currentNode);
        }

        return returnList;
    }

    public static <E> Node<E> occurAtLeastKTimesOld(Node<E>[] lists, Comparator<E> cmp, int k) {

        Node<E> returnList = new Node<>();
        returnList.next = returnList.previous = returnList;

        int count;

        Node<E> currentNode;

        while(true){
            Heap.maxHeapSort(lists, 0, lists.length - 1, new NodeComparator(cmp));
            if(lists[0] == null) return returnList;
            currentNode = lists[0];
            count = 0;
            for(int i =0; i < lists.length;){
                if(lists[i] != null && cmp.compare(lists[i].value, currentNode.value) == 0) {
                    count += 1;
                    lists[i] = lists[i].next;
                }
                else{
                    i++;
                }
            }
            if(count >= k){
                removeFromList(currentNode);
                addToList(returnList, currentNode);
            }
        }
    }
}
