package mylibrary.arrays;

import java.util.Comparator;

/**
 * Created by rcacheira on 12/04/15.
 */
public class QuickSort {

    public static <E extends Comparable<? super E>> void sort(E[] v, boolean asc){
        sort(v, (t1, t2) -> asc ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    public static <E extends Comparable<? super E>> void sort(E[] v, int left, int right, boolean asc){
        sort(v, left, right, (t1, t2) -> asc ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    public static <E> void sort(E[] v, Comparator<E> c) {
        sort(v, 0, v.length-1, c);
    }

    public static <E> void sort(E[] v, int left, int right, Comparator<E> c) {
        int i;
        if (right <= left) return;
        i = partition(v, left, right, c);
        sort(v, left, i - 1, c);
        sort(v, i + 1, right, c);
    }

    private static <E> int partition(E[] v, int l, int r, Comparator<E> c) {
        E x = v[r];
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

    public static void sort(int[] v, boolean asc){
        sort(v, (i1, i2) -> (asc) ? i1 - i2 : i2 - i1);
    }

    public static void sort(int[] v, int left, int right, boolean asc){
        sort(v, left, right, (i1, i2) -> (asc) ? i1 - i2 : i2 - i1);
    }

    public static void sort(int[] v, Comparator<Integer> c) {
        sort(v, 0, v.length-1, c);
    }

    public static void sort(int[] v, int left, int right, Comparator<Integer> c) {
        int i;
        if (right <= left) return;
        i = partition(v, left, right, c);
        sort(v, left, i - 1, c);
        sort(v, i + 1, right, c);
    }

    public static void grantPivotAtPositions(int[] v, int left, int right, int lesserPivotPos, int greaterPivotPos, Comparator<Integer> c) {
        if (right <= left) return;
        int i = partition(v, left, right, c);

        if(i < greaterPivotPos) {
            grantPivotAtPositions(v, i + 1, right, lesserPivotPos, greaterPivotPos, c);
        }
        else if (i > lesserPivotPos) {
            grantPivotAtPositions(v, left, i - 1, lesserPivotPos, greaterPivotPos, c);
        }
    }

    private static int partition(int[] v, int l, int r, Comparator<Integer> c) {
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
