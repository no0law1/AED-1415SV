package serie1;

import mylibrary.sort.HeapInt;
import mylibrary.sort.QuickSortInt;

import java.util.Comparator;
import java.util.Stack;

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

    private static class DiffComparator implements Comparator<Integer> {
        private Integer x;
        public DiffComparator(Integer x){
            this.x = x;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(x - o1) - Math.abs(x - o2);
        }
    }

    /**
     * Implementation O(n.lg(n))
     *
     * @param v array to search
     * @param l first position to search
     * @param r last position to search
     * @param x value to search
     * @param k number of elements to return
     * @return array with the k nearest x values
     */
    public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k) {
        if (v.length < 1 || r < l || k == 0) {
            return new int[0];
        }

        HeapInt.sort(v, l, r, new DiffComparator(x));     //O(n.lg(n))

        int size = Math.min(k, r - l + 1);
        int[] result = new int[size];

        for (int i = 0; l < size; l++, i++) {
            result[i] = v[l];
        }

        return result;
    }

    /**
     * Implementation O(n.lg(n))
     *
     * @param v
     * @param l
     * @param r
     * @return
     */
    public static int median(int[] v, int l, int r) {
//        HeapInt.sort(v, l, r);
//        if ((r - l + 1) % 2 == 0) {
//            return (v[r / 2] + v[(r / 2) + 1]) / 2;
//        }
//        return v[r / 2];

        int i = l;
        Stack<Integer> stack = new Stack<>();
        stack.push(r);
        stack.push(l);
        while(i != (r-l)/2){
            int left = stack.pop();
            int right = stack.pop();
            if(right <= left){
                continue;
            }
            i = QuickSortInt.partition(v, left, right);

            if (i-left > right-i){
                stack.push(i-1);
                stack.push(left);
            }
            stack.push(right);
            stack.push(i+1);
            if (i-left <= right-i){
                stack.push(i-1);
                stack.push(left);
            }
        }
        return ((r - l + 1) % 2 == 0) ? (v[i]+v[i+1])/2 : v[i];
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
        int result = l;

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
                result = i;
            }
            equal = 0;
        }
        return v[result];
    }
}
