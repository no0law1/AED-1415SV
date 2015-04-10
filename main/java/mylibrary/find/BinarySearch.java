package mylibrary.find;

/**
 * Created by rcacheira on 09/04/15.
 */
public class BinarySearch {

    public static <E extends Comparable<E>> E findValue(E[] v, int l, int r, E x) {
        return v[findValueIdx(v, l, r, x)];
    }

    private static <E extends Comparable<E>> int findValueIdx(E[] v, int l, int r, E x) {
        if (l > r) return -1;
        int med = l + (r - l) / 2;

        int compRes = x.compareTo(v[med]);
        if (compRes == 0) {
            return med;
        }

        if (compRes < 0) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        return findValueIdx(v, l, r, x);
    }

    public static <E extends Comparable<E>> E findNearestValue(E[] v, int l, int r, E x) {
        return v[findNearestValueIdx(v, l, r, x)];
    }

    public static <E extends Comparable<E>> int findNearestValueIdx(E[] v, int l, int r, E x) {
        return findNearest(v, l, r, x).idx;
    }

    private static class Position {
        int idx;
        int dif;

        public Position(int idx, int dif) {
            this.idx = idx;
            this.dif = dif;
        }
    }

    private static <E extends Comparable<E>> Position findNearest(E[] v, int l, int r, E x) {
        if (l > r) return new Position(-1, 0);
        int med = l + (r - l) / 2;

        int compRes = x.compareTo(v[med]);
        if (compRes == 0) {
            return new Position(med, 0);
        }

        if (compRes < 0) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        int dif = Math.abs(compRes);

        Position pos = findNearest(v, l, r, x);
        if (pos.idx == -1 || pos.dif > dif) {
            pos.idx = med;
            pos.dif = dif;
        }
        return pos;
    }

}
