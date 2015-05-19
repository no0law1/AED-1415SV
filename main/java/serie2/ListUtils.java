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

    public static <E> Node<E> occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k) {

        Comparator<Node<E>> newCmp = (i1, i2) -> {
            if (i1 == null) return Integer.MAX_VALUE;
            if (i2 == null) return Integer.MIN_VALUE;
            return (cmp.compare(i1.value, i2.value));
        };

        Node<E> result = new Node<>();
        result.next = result;
        result.previous = result;

        int numberOfTimes = 0;
        int size = lists.length - 1;

        Heap.minHeapify(lists, 0, size, newCmp);

        Node<E> toBeSearched = lists[0];

        while(true){
            Node<E> max = lists[0];

            if(newCmp.compare(max, toBeSearched) == 0){
                numberOfTimes++;
            } else {
                if(numberOfTimes >= k){
                    addToList(result, toBeSearched);
                }
                numberOfTimes = 1;
                toBeSearched = max;
                if(lists[0]==null){
                    break;
                }
            }
            lists[0] = lists[0].next;
            if(lists[0] == null){
                lists[0] = lists[size];
                lists[size--] = null;
            }
            Heap.minHeapify(lists, 0, size, newCmp);

        }

        return result;
    }

    public static <E> void addToList(Node<E> list, Node<E> node){
        node.next = list;
        node.previous = list.previous;
        list.previous.next = node;
        list.previous = node;
    }
}
