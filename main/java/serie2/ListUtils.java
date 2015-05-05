package serie2;

import mylibrary.arrays.Heap;

import java.util.Comparator;

/**
 *
 */
public class ListUtils {

    /**
     * que dada a lista simplesmente ligada sem sentinela e não circular referenciada por list, ordenada de modo crescente
     * segundo o comparador cmp, retorna se existir, o k-ésimo maior elemento presente na lista. Caso a lista tenha menos de k
     * elementos, o método deverá retorna null. Considere que cada objeto do tipo Node<E> tem dois campos: um value e
     * uma referência, next. NOTA: na resolução deste exercício, apenas deverá ser utilizado o campo next da classe Node.

     * @param list
     * @param k
     * @param cmp
     * @param <E>
     * @return
     */
    public static <E> E getKBiggest(Node<E> list, int k, Comparator<E> cmp) {
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
        int numberOfTimes = 0;

        while(lists[0]!=null){
            lists[0] = lists[0].next;

            Heap.sort(lists, 0, lists.length-1, (i1, i2)->(cmp.compare(i1.value, i2.value)));

            Node<E> recurrentSearch = lists[0];
            if(recurrentSearch.value.equals(toBeSearched.value)) {
                numberOfTimes++;
            } else{
                if(numberOfTimes >= k){
                    Node<E> onlyOnce = new Node<>(toBeSearched.value);
                    onlyOnce.next = aux.next;
                    onlyOnce.previous = aux;
                    aux.next.previous = onlyOnce;
                    aux.next = onlyOnce;
                }
                numberOfTimes = 0;
                toBeSearched = lists[0];
            }

        }
        return aux;
    }
}
