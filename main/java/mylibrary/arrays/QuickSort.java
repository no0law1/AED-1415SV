package mylibrary.arrays;

import java.util.Comparator;

/**
 * Created by rcacheira on 12/04/15.
 */
public class QuickSort {

    public static <T extends Comparable<? super T>> void sort(T[] v, int left, int right, boolean asc){
        sort(v, left, right, (T t1, T t2) -> asc ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    public static <T> void sort(T[] v, int left, int right, Comparator<T> c) {
        int i;
        if (right <= left) return;
        i = partition(v, left, right, c);
        sort(v, left, i - 1, c);
        sort(v, i + 1, right, c);
    }

    public static <T> int partition(T[] v, int l, int r, Comparator<T> c) {
        T x = v[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (c.compare(v[j], x) <= 0) {
                i++;
                Utils.swap(v, i, j);
            }
        }
        i++;
        Utils.swap(v, r, i);
        return i;
    }

    public static void sort(int[] v, int left, int right, boolean asc){
        sort(v, left, right, (Integer i1, Integer i2) -> (asc) ? i1.compareTo(i2) : i2.compareTo(i1));
    }

    public static void sort(int[] v, int left, int right, Comparator<Integer> c) {
        int i;
        if (right <= left) return;
        i = partition(v, left, right, c);
        sort(v, left, i - 1, c);
        sort(v, i + 1, right, c);
    }

    public static void grantFinalPositions(int[] v, int left, int right, int lesser, int greater, Comparator<Integer> c) {
        if (right <= left) return;
        int i = partition(v, left, right, c);

        if(i < greater) {
            grantFinalPositions(v, i + 1, right, lesser, greater, c);
        }
        else if (i > lesser) {
            grantFinalPositions(v, left, i - 1, lesser, greater, c);
        }
    }

    public static int partition(int[] v, int l, int r, Comparator<Integer> c) {
        int x = v[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (c.compare(v[j], x) <= 0) {
                i++;
                Utils.swap(v, i, j);
            }
        }
        i++;
        Utils.swap(v, r, i);
        return i;
    }
}
