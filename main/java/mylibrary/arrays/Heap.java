package mylibrary.arrays;

import java.util.Comparator;

public class Heap {

    private static int parent(int i){
        return (i-1)/2;
    }

    private static int leftSun(int i){
        return 2 * i + 1;
    }

    private static int rightSun(int i){
        return 2 * i + 2;
    }

    public static <T extends Comparable<? super T>> void sort(T[] v, int l, int r, boolean asc) {
        sort(v, l, r, (T t1, T t2) -> asc ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    public static <T> void sort(T[] v, int l, int r, Comparator<T> c) {
        int heapSize = r - l + 1;
        buildHeap(v, l, heapSize, c);

        for (int i = l + heapSize - 1; i > l; i--) {
            Utils.swap(v, i, l);
            heapify(v, l, l, --heapSize, c);
        }
    }

    public static <T> void buildHeap(T[] arr, int l, int heapSize, Comparator<T> c) {
        for (int p = l + (heapSize >> 1) - 1; p >= l; --p) {
            heapify(arr, l, p, heapSize, c);
        }
    }

    public static <T> void heapify(T[] arr, int l, int i, int heapSize, Comparator<T> c) {
        int ls = l + leftSun(i-l);
        int rs = ls + 1;
        int largest = i;
        if (ls < l + heapSize && c.compare(arr[ls], arr[largest]) > 0)
            largest = ls;
        if (rs < l + heapSize && c.compare(arr[rs], arr[largest]) > 0) {
            largest = rs;
        }
        if (largest != i) {
            Utils.swap(arr, i, largest);
            heapify(arr, l, largest, heapSize, c);
        }
    }

    public static void sort(int[] v, int l, int r, boolean asc) {
        sort(v, l, r, (Integer i1, Integer i2) -> asc ? i1 - i2 : i2 - i1);
    }

    public static void sort(int[] v, int l, int r, Comparator<Integer> c) {
        int heapSize = r - l + 1;
        buildHeap(v, l, heapSize, c);

        for (int i = l + heapSize - 1; i > l; i--) {
            Utils.swap(v, i, l);
            heapify(v, l, l, --heapSize, c);
        }
    }

    public static void sort(int[] v, int l, int r, int nValues, boolean asc) {
        sort(v, l, r, nValues, (Integer i1, Integer i2) -> (asc) ? i1 - i2 : i2 - i1);
    }

    public static void sort(int[] v, int l, int r, int nValues, Comparator<Integer> c) {
        int heapSize = r - l + 1;
        buildHeap(v, l, heapSize, c);
        if(nValues > heapSize) nValues = heapSize;

        int i = l + heapSize - 1;
        int stopValue = Math.max(l, i - nValues);
        for ( ; i > stopValue; i--) {
            Utils.swap(v, i, l);
            heapify(v, l, l, --heapSize, c);
        }
    }

    public static void buildHeap(int[] v, int l, int heapSize, Comparator<Integer> c) {
        for (int p = l + (heapSize >> 1) - 1; p >= l; --p) {
            heapify(v, l, p, heapSize, c);
        }
    }

    public static void heapify(int[] v, int l, int i, int heapSize, Comparator<Integer> c) {
        int ls = l + leftSun(i-l);
        int rs = ls + 1;
        int largest = i;
        if (ls < l + heapSize && c.compare(v[ls], v[largest]) > 0)
            largest = ls;
        if (rs < l + heapSize && c.compare(v[rs], v[largest]) > 0) {
            largest = rs;
        }
        if (largest != i) {
            Utils.swap(v, i, largest);
            heapify(v, l, largest, heapSize, c);
        }
    }

}
