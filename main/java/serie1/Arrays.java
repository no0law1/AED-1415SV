package serie1;

import mylibrary.sort.Heap;

public class Arrays {

    /**
     * Implementation O(n).
     * Finds the minimum difference between two arrays of Integers.
     *
     * @param elem1 Array number 1
     * @param elem2 Array number 2
     * @return The minimum difference between two Integers.
     */
    public static int findMinDifference(int[] elem1, int[] elem2) {
        if (elem1.length < 1 || elem2.length < 1) {
            return -1;
        }

        int diff = Integer.MAX_VALUE;
        int idx1 = 0, idx2 = 0;

        while (idx1 < elem1.length && idx2 < elem2.length) {
            if (elem1[idx1] == elem2[idx2]) {
                return 0;
            }
            int res = Math.abs(elem1[idx1] - elem2[idx2]);
            if (res < diff) {
                diff = res;
            }
            if (elem1[idx1] < elem2[idx2]) {
                idx1++;
            } else {
                idx2++;
            }
        }

        return diff;
    }

    /**
     * Implementation O(n.lg(n))
     *
     * @param v array to search
     * @param l first position to search
     * @param r last position to search
     * @param x value to search
     * @param k number of elements to return
     * @return array with the k x nearest values
     */
    public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k) {
        if (v.length < 1 || r < l || k == 0) {
            return new int[0];
        }

        //RC: claro que é para procurar entre l e r antes de ordenar, por isso precisamos de ordenar só entre l e r
        Heap.heapSort(v, l, r);     //O(n.lg(n))
        int size = Math.min(k, r-l+1);
        int[] finalResult = new int[size]; //k-1

        int nearIdx = binaryNearestSearch(v, l, r, x);       // O(n) ? RC: não sei o custo, temos de calcular

        int fill = 0;
        int left = nearIdx - 1, right = nearIdx;

        for (; fill < size; ) {
            //if (left <= 0) { RC: Mas ca granda anormal então e o zero não conta ???
            //if (left < 0) { RC: Este também nao serve porque é só até l inclusive
            if (left < l) {
                finalResult[fill++] = v[right++];
            //} else if (right >= v.length) { // RC: Este também não serve porque é só até r inclusive
            } else if (right > r) {
                finalResult[fill++] = v[left--];
            } else {
                if (Math.abs(v[left] - x) < Math.abs(v[right] - x)) {
                    finalResult[fill++] = v[left--];
                } else {
                    finalResult[fill++] = v[right++];
                }
            }
        }

        return finalResult;
    }

    /**
     * finds the position of x nearest value, using binarySearch algorithm
     *
     * @param v array to search
     * @param l first position to search
     * @param r last position to search
     * @param x value to search
     * @return position of x nearest value
     */
    private static int binaryNearestSearch(int[] v, int l, int r, int x) {
        return binaryNearestSearchAux(v, l, r, x).idx;
    }

    private static class Position {
        int idx;
        int dif;

        public Position(int idx, int dif) {
            this.idx = idx;
            this.dif = dif;
        }
    }

    private static Position binaryNearestSearchAux(int[] v, int l, int r, int x) {
        if (l > r) return new Position(-1, 0);
        int med = l + (r - l) / 2;

        if (x == v[med]) {
            return new Position(med, 0);
        }

        if (x < v[med]) {
            r = med - 1;
        } else {
            l = med + 1;
        }

        int dif = Math.abs(x - v[med]);

        Position pos = binaryNearestSearchAux(v, l, r, x);
        if (pos.idx == -1 || pos.dif > dif) {
            pos.idx = med;
            pos.dif = dif;
        }
        return pos;
    }

    public static int median(int[] v, int l, int r) {
        throw new UnsupportedOperationException();
    }

    /**
     * Implementation - O(n*k)
     * n = array length
     * k = word length
     *
     * @param v    Array of strings
     * @param l    Beginning of search
     * @param r    End of search
     * @param word Word to search in array {@code v}
     * @return The word in array {@code v} that has a greater common prefix with {@code word}.
     */
    public static String greaterCommonPrefix(String[] v, int l, int r, String word) {
        if (v.length < 1 || r < l) {
            return null;
        }
        String result = v[v.length - 1];     //TODO: See l and r of Unit tests.
        int finalEqual = 0, equal = 0;
        for (int i = r; i >= l; i--) {
            if (i > v.length - 1) {
                continue;
            }
            for (int j = 0; j < word.length() && j < v[i].length(); j++) {
                if (word.charAt(j) == v[i].charAt(j)) {
                    equal++;
                } else {
                    break;
                }
            }
            if (equal > finalEqual) {
                finalEqual = equal;
                result = v[i];
            }
            equal = 0;
        }
        return result;
    }

    public static String greaterCommonPrefix2(String[] v, int l, int r, String word) {
        if (v.length < 1 || r < l) {
            return null;
        }

        return null;
    }
}
