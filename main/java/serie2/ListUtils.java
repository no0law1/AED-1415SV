package serie2;

import mylibrary.arrays.Heap;

import java.util.Comparator;

/**
 *
 */
public class ListUtils {

    public static <E> E getKBiggest(Node<E> list, int k, Comparator<E> cmp) {
        if ( list == null || k <= 0 ){
            return null;
        }
        int n = 1;
        Node<E> result = list;
        Node<E> lastNode = list;
        while (n++ < k){
            lastNode = lastNode.next;
            if(lastNode.next == null){
                break;
            }
        }
        if(n<k){
            return null;
        }
        while(lastNode.next != null){
            lastNode = lastNode.next;
            result = result.next;
        }

        return result.value;
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

    public static <E> Node<E> occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k) {

        Comparator<Node<E>> newCmp = (i1, i2) -> {
            if (i1 == null) return Integer.MAX_VALUE;
            if (i2 == null) return Integer.MIN_VALUE;
            return (cmp.compare(i1.value, i2.value));
        };

        Node<E> returnList = new Node<>();
        returnList.next = returnList.previous = returnList;

        int heapSize = lists.length;
        Heap.buildMinHeap(lists, heapSize, newCmp);

        Node currentNode = null;
        int count = 0;

        for(;;){
            if(newCmp.compare(currentNode, lists[0]) != 0){
                if(count >= k){
                    removeFromList(currentNode);
                    addToList(returnList, currentNode);
                }
                if(lists[0] == null) break;
                currentNode = lists[0];
                count = 1;
            }
            else{
                count++;
            }
            lists[0] = lists[0].next;
            Heap.minHeapify(lists, 0, heapSize, newCmp);
        }

        return returnList;
    }

}
