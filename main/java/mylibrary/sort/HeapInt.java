package mylibrary.sort;

import java.util.Comparator;

public class HeapInt {

    public static void sort(int[] v, int l, int r) {
        sort(v, l, r, (Integer i1, Integer i2) -> i1.compareTo(i2));
    }

    public static void sort(int[] v, int l, int r, Comparator<Integer> comp) {
        int heapSize = r - l + 1;
        buildMinHeap(v, l, heapSize, comp);
        int n = heapSize;

        for (int i = l + heapSize - 1; i > l; i--) {
            exch(v, i, l);
            minHeapify(v, l, l, --n, comp);
        }
    }

    private static void buildMinHeap(int[] arr, int l, int heapSize, Comparator<Integer> comp) {
        for (int p = l + (heapSize >> 1) - 1; p >= l; --p) {
            minHeapify(arr, l, p, heapSize, comp);
        }
    }

    private static void minHeapify(int[] arr, int l, int i, int heapSize, Comparator<Integer> comp) {
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

    private static void exch(int[] arr, int idx1, int idx2) {
        int aux = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = aux;
    }

}
