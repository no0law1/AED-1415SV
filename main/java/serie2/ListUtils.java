package serie2;

import mylibrary.arrays.Heap;

import java.util.Comparator;

/**
 *
 */
public class ListUtils {

    public static <E> E getKBiggest(Node<E> list, int k, Comparator<E> cmp) {
        //TODO: Don't understand the concept of the problem
        if (k > 0) {
            int n = 0;
            Node<E> result = list;
            while (list != null && n<k) {
                if (cmp.compare(list.value, result.value) > 0) {
                    result.value = list.value;
                }
                list = list.next;
                n++;
            }
            return (n==k) ? result.value : null;
        }
        return null;
    }

    public static <E> Node<E> occurAtLeastKTimes(Node<E>[] lists, Comparator<E> cmp, int k) {
        Node<E> result = new Node<>();
        result.next = result;
        result.previous = result;

        Node<E> aux = result;
        Node<E> toBeSearched = lists[0];

        int numberOfTimes = 1;
        int size = lists.length - 1;

        Heap.sort(lists, 0, size, (i1, i2) -> {
            if (i1 == null) return Integer.MAX_VALUE;
            if (i2 == null) return Integer.MIN_VALUE;
            return (cmp.compare(i1.value, i2.value));
        });

        while (lists[0] != null){
            Node<E> recurrentSearch = lists[0];
            if(cmp.compare(recurrentSearch.value, toBeSearched.value) == 0) {
                numberOfTimes++;
                lists[0] = lists[0].next;
            } else{
                if(numberOfTimes >= k){
                    Node<E> onlyOnce = new Node<>(toBeSearched.value);
                    onlyOnce.next = aux.next;
                    onlyOnce.previous = aux;
                    aux.next.previous = onlyOnce;
                    aux.next = onlyOnce;

                    aux = aux.next;
                }
                numberOfTimes = 1;
                toBeSearched = lists[0];
            }

            if(lists[0] == null){
                lists[0] = lists[size--];
            }

            Heap.sort(lists, 0, size, (i1, i2) -> {
                if (i1 == null) return Integer.MAX_VALUE;
                if (i2 == null) return Integer.MIN_VALUE;
                return (cmp.compare(i1.value, i2.value));
            });
        }
        return result;
    }
}
