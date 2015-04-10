package mylibrary.sort;

import java.util.Comparator;

public class Heap {

    public static <E extends Comparable<E>> void heapSort(E[] v, int l, int r) {
        heapSort(v, l, r, (E e1, E e2) -> e1.compareTo(e2)); //Using Lambda Expression to define a new comparator
    }

    public static <E> void heapSort(E[] v, int l, int r, Comparator<E> comp) {
        int heapSize = r - l + 1;
        buildMinHeap(v, l, heapSize, comp);
        int n = heapSize;

        for (int i = l + heapSize - 1; i > l; i--) {
            exch(v, i, l);
            minHeapify(v, l, l, --n, comp);
        }
    }

    private static <E> void buildMinHeap(E[] arr, int l, int heapSize, Comparator<E> comp) {
        for (int p = l + (heapSize >> 1) - 1; p >= l; --p) {
            minHeapify(arr, l, p, heapSize, comp);
        }
    }

    private static <E> void minHeapify(E[] arr, int l, int i, int heapSize, Comparator<E> comp) {
        int ls = l + (2 * (i - l) + 1);
        int rs = ls + 1;
        int biggest = i;
        if (ls < l + heapSize && comp.compare(arr[ls], arr[biggest]) > 0)
            biggest = ls;
        if (rs < l + heapSize && comp.compare(arr[rs], arr[biggest]) > 0) {
            biggest = rs;
        }
        if (biggest != i) {
            exch(arr, i, biggest);
            minHeapify(arr, l, biggest, heapSize, comp);
        }
    }

    private static <E> void exch(E[] arr, int idx1, int idx2) {
        E aux = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = aux;
    }

}
