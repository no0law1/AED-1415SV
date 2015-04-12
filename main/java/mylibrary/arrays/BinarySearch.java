package mylibrary.arrays;

import java.util.Comparator;

/**
 * Created by rcacheira on 09/04/15.
 */
public class BinarySearch {

    private static <T extends Comparable<? super T>> int find(T[] v, int l, int r, T x, boolean asc) {
        return find(v, l, r, x, (T t1, T t2) -> (asc) ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    private static <T> int find(T[] v, int l, int r, T x, Comparator<T> c) {
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

    private static int find(int[] v, int l, int r, int x, boolean asc) {
        return find(v, l, r, x, (Integer i1, Integer i2) -> (asc) ? i1 - i2 : i2 - i1);
    }

    private static int find(int[] v, int l, int r, int x, Comparator<Integer> c) {
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

    public static <T extends Comparable<? super T>> int findNearest(T[] v, int l, int r, T x, boolean asc) {
        return findNearest(v, l, r, x, (T t1, T t2) -> (asc) ? t1.compareTo(t2) : t2.compareTo(t1));
    }

    public static <T> int findNearest(T[] v, int l, int r, T x, Comparator<T> c) {
        return findNearest0(v, l, r, x, c).idx;
    }

    public static <T> Position findNearest0(T[] v, int l, int r, T x, Comparator<T> c) {
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

        Position pos = findNearest0(v, l, r, x, c);
        if (pos.idx == -1 || pos.dif > dif) {
            pos.idx = med;
            pos.dif = dif;
        }
        return pos;
    }

    public static int findNearest(int[] v, int l, int r, int x) {
        return findNearest0(v, l, r, x, (Integer i1, Integer i2) -> i1 - i2).idx;
    }

    public static int findNearest(int[] v, int l, int r, int x, Comparator<Integer> c) {
        return findNearest0(v, l, r, x, c).idx;
    }

    public static Position findNearest0(int[] v, int l, int r, int x, Comparator<Integer> c) {
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

        Position pos = findNearest0(v, l, r, x, c);
        if (pos.idx == -1 || pos.dif > dif) {
            pos.idx = med;
            pos.dif = dif;
        }
        return pos;
    }

}
