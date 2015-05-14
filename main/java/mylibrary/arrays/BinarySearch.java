package mylibrary.arrays;

import java.util.Comparator;

/**
 * Created by rcacheira on 09/04/15.
 */
public class BinarySearch {

    public static <E extends Comparable<? super E>> int find(E[] v, int l, int r, E x, boolean asc) {
        return find(v, l, r, x, (E e1, E e2) -> (asc) ? e1.compareTo(e2) : e2.compareTo(e1));
    }

    public static <E> int find(E[] v, int l, int r, E x, Comparator<E> c) {
        if (l > r) return -1;
        int med = l + (r - l) / 2;

        int compRes = c.compare(x,v[med]);
        if (compRes == 0) {
            return med;
        }

        if (compRes < 0) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        return find(v, l, r, x, c);
    }

    public static int find(int[] v, int l, int r, int x, boolean asc) {
        return find(v, l, r, x, (i1, i2) -> (asc) ? i1 - i2 : i2 - i1);
    }

    public static int find(int[] v, int l, int r, int x, Comparator<Integer> c) {
        if (l > r) return -1;
        int med = l + (r - l) / 2;

        int compRes = c.compare(x,v[med]);
        if (compRes == 0) {
            return med;
        }

        if (compRes < 0) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        return find(v, l, r, x, c);
    }

    public static class Position {
        private int idx;
        private int dif;

        public Position(int idx, int dif) {
            this.idx = idx;
            this.dif = dif;
        }

        public int getDif() {
            return dif;
        }

        public int getIdx() {
            return idx;
        }
    }

    public static <E extends Comparable<? super E>> Position findNearest(E[] v, int l, int r, E x, boolean asc) {
        return findNearest(v, l, r, x, (E e1, E e2) -> (asc) ? e1.compareTo(e2) : e2.compareTo(e1));
    }

    public static <E> Position findNearest(E[] v, int l, int r, E x, Comparator<E> c) {
        if (l > r) return new Position(-1, 0);
        int med = l + (r - l) / 2;

        int compRes = c.compare(x, v[med]);
        if (compRes == 0) {
            return new Position(med, 0);
        }

        if (compRes < 0) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        int dif = Math.abs(compRes);

        Position pos = findNearest(v, l, r, x, c);
        if (pos.idx == -1 || pos.dif > dif) {
            pos.idx = med;
            pos.dif = dif;
        }
        return pos;
    }

}
