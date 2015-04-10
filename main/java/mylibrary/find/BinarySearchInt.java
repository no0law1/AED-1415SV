package mylibrary.find;

/**
 * Created by rcacheira on 09/04/15.
 */
public class BinarySearchInt {

    public static int findValue(int[] v, int l, int r, int x) {
        return v[findValueIdx(v, l, r, x)];
    }

    private static int findValueIdx(int[] v, int l, int r, int x) {
        if (l > r) return -1;
        int med = l + (r - l) / 2;

        int compRes = x - v[med];
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

    public static int findNearestValue(int[] v, int l, int r, int x) {
        return v[findNearestValueIdx(v, l, r, x)];
    }

    public static int findNearestValueIdx(int[] v, int l, int r, int x) {
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

    private static Position findNearest(int[] v, int l, int r, int x) {
        if (l > r) return new Position(-1, 0);
        int med = l + (r - l) / 2;

        int compRes = x - v[med];
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
