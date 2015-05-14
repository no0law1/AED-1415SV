package mylibrary.arrays;

import java.util.Comparator;

public class Heap{

    public static int parent(int i){
        return (i-1)/2;
    }

    public static int leftSun(int i){
        return 2 * i + 1;
    }

    public static int rightSun(int i){
        return 2 * i + 2;
    }

    public static <E extends Comparable<? super E>> void sort(E[] v, boolean asc) {
        if(asc) maxHeapSort(v, 0, v.length-1, (e1, e2) -> e1.compareTo(e2));
        else minHeapSort(v, 0, v.length - 1, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E extends Comparable<? super E>> void sort(E[] v, int l, int r, boolean asc) {
        if(asc) maxHeapSort(v, l, r, (e1, e2) -> e1.compareTo(e2));
        else minHeapSort(v, l, r, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E extends Comparable<? super E>> void maxHeapSort(E[] v){
        maxHeapSort(v, 0, v.length-1, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void maxHeapSort(E[] v, Comparator<E> c) {
        maxHeapSort(v, 0, v.length - 1, c);
    }

    public static <E> void maxHeapSort(E[] v, int l, int r, Comparator<E> cmp) {
        int heapSize = r - l + 1;
        buildMaxHeap(v, l, heapSize, cmp);

        for (int i = l + heapSize - 1; i > l; i--) {
            Utils.swap(v, i, l);
            maxHeapify(v, l, l, --heapSize, cmp);
        }
    }

    public static <E extends Comparable<? super E>> void minHeapSort(E[] v){
        minHeapSort(v, 0, v.length - 1, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void minHeapSort(E[] v, Comparator<E> cmp) {
        minHeapSort(v, 0, v.length - 1, cmp);
    }

    public static <E> void minHeapSort(E[] v, int l, int r, Comparator<E> cmp) {
        maxHeapSort(v, l, r, (e1, e2) -> cmp.compare(e2, e1));
    }

    public static <E extends Comparable<? super E>> void buildMaxHeap(E[] v, int heapSize){
        buildMaxHeap(v, heapSize, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void buildMaxHeap(E[] arr, int heapSize, Comparator<E> cmp) {
        buildMaxHeap(arr, 0, heapSize, cmp);
    }

    public static <T> void buildMaxHeap(T[] arr, int l, int heapSize, Comparator<T> cmp) {
        for (int p = l + (heapSize >> 1) - 1; p >= l; --p) {
            maxHeapify(arr, l, p, heapSize, cmp);
        }
    }

    public static <E extends Comparable<? super E>> void buildMinHeap(E[] v, int heapSize){
        buildMinHeap(v, heapSize, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void buildMinHeap(E[] arr, int heapSize, Comparator<E> cmp) {
        buildMinHeap(arr, 0, heapSize, cmp);
    }

    public static <E> void buildMinHeap(E[] arr, int l, int heapSize, Comparator<E> cmp) {
        buildMaxHeap(arr, l, heapSize, (e1, e2) -> cmp.compare(e2, e1));
    }

    public static <E extends Comparable<? super E>> void maxHeapify(E[] v, int i, int heapSize){
        maxHeapify(v, heapSize, i, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void maxHeapify(E[] arr, int i, int heapSize, Comparator<E> cmp) {
        maxHeapify(arr, 0, i, heapSize, cmp);
    }

    public static <E> void maxHeapify(E[] arr, int l, int i, int heapSize, Comparator<E> cmp) {
        int ls = l + leftSun(i-l);
        int rs = ls + 1;
        int largest = i;
        if (ls < l + heapSize && cmp.compare(arr[ls], arr[largest]) > 0)
            largest = ls;
        if (rs < l + heapSize && cmp.compare(arr[rs], arr[largest]) > 0) {
            largest = rs;
        }
        if (largest != i) {
            Utils.swap(arr, i, largest);
            maxHeapify(arr, l, largest, heapSize, cmp);
        }
    }

    public static <E extends Comparable<? super E>> void minHeapify(E[] v, int i, int heapSize){
        minHeapify(v, heapSize, i, (e1, e2) -> e1.compareTo(e2));
    }

    public static <E> void minHeapify(E[] arr, int i, int heapSize, Comparator<E> cmp) {
        minHeapify(arr, 0, i, heapSize, cmp);
    }

    public static <E> void minHeapify(E[] arr, int l, int i, int heapSize, Comparator<E> cmp) {
        maxHeapify(arr, l, i, heapSize, (i1, i2) -> cmp.compare(i2, i1));
    }

    public static void sort(int[] v, boolean asc){
        sort(v, 0, v.length - 1, asc);
    }

    public static void sort(int[] v, int l, int r, boolean asc) {
        if(asc) maxHeapSort(v, l, r, (i1, i2) -> i1.compareTo(i2));
        else minHeapSort(v, l, r, (i1, i2) -> i1.compareTo(i2));
    }

    public static void maxHeapSort(int[] v) {
        maxHeapSort(v, 0, v.length - 1, (i1, i2) -> i1.compareTo(i2));
    }

    public static void maxHeapSort(int[] v, int l, int r, Comparator<Integer> cmp) {
        int heapSize = r - l + 1;
        buildMaxHeap(v, l, heapSize, cmp);

        for (int i = l + heapSize - 1; i > l; i--) {
            Utils.swap(v, i, l);
            maxHeapify(v, l, l, --heapSize, cmp);
        }
    }

    public static void minHeapSort(int[] v) {
        minHeapSort(v, 0, v.length - 1, (i1, i2) -> i1.compareTo(i2));
    }

    public static void minHeapSort(int[] v, int l, int r, Comparator<Integer> cmp) {
        maxHeapSort(v, l, r, (i1, i2) -> cmp.compare(i2, i1));
    }

    public static void buildMaxHeap(int[] v, int heapSize) {
        buildMaxHeap(v, 0, heapSize, (i1, i2) -> i1.compareTo(i2));
    }

    public static void buildMaxHeap(int[] v, int l, int heapSize, Comparator<Integer> cmp) {
        for (int p = l + heapSize / 2 - 1; p >= l; --p) {
            maxHeapify(v, l, p, heapSize, cmp);
        }
    }

    public static void buildMinHeap(int[] v, int heapSize) {
        buildMinHeap(v, 0, heapSize, (i1, i2) -> i1.compareTo(i2));
    }

    public static void buildMinHeap(int[] v, int l, int heapSize, Comparator<Integer> cmp) {
        buildMaxHeap(v, l, heapSize, (i1, i2) -> cmp.compare(i2, i1));
    }

    public static void maxHeapify(int[] v, int i, int heapSize) {
        maxHeapify(v, 0, i, heapSize, (i1, i2) -> i1.compareTo(i2));
    }

    public static void maxHeapify(int[] v, int l, int i, int heapSize, Comparator<Integer> cmp) {
        int ls = l + leftSun(i-l);
        int rs = ls + 1;
        int largest = i;
        if (ls < l + heapSize && cmp.compare(v[ls], v[largest]) > 0)
            largest = ls;
        if (rs < l + heapSize && cmp.compare(v[rs], v[largest]) > 0) {
            largest = rs;
        }
        if (largest != i) {
            Utils.swap(v, i, largest);
            maxHeapify(v, l, largest, heapSize, cmp);
        }
    }

    public static void minHeapify(int[] v, int i, int heapSize) {
        minHeapify(v, 0, i, heapSize, (i1, i2) -> i1.compareTo(i2));
    }

    public static void minHeapify(int[] v, int l, int i, int heapSize, Comparator<Integer> cmp) {
        maxHeapify(v, l, i, heapSize, (i1, i2) -> cmp.compare(i2,i1));
    }

}
