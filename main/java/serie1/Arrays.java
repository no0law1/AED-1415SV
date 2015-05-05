package serie1;

import mylibrary.arrays.BinarySearch;
import mylibrary.arrays.Heap;
import mylibrary.arrays.QuickSort;

import java.util.Comparator;

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
     * Difference to number comparator as we need the n smaller difference, the comparation is inverted to turn the
     * maxHeap algorithm into minHeap
     */
    private static class DiffComparator implements Comparator<Integer> {
        private Integer x;
        public DiffComparator(Integer x){
            this.x = x;
        }

        @Override
        public int compare(Integer o1, Integer o2) {
            return Math.abs(x - o2) - Math.abs(x - o1);
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

        int size = Math.min(k, r - l + 1);

        Heap.sort(v, l, r, size, new DiffComparator(x));     //O(n.lg(n))

        int[] result = new int[size];

        for (int i = 0; i < size; i++) {
            result[i] = v[r--];
        }

        return result;
    }

    /**
     * Quick Sort
     * @param v
     * @param l
     * @param r
     * @return
     */
    public static int median(int[] v, int l, int r) {
        int nElems = r-l + 1;
        int med = l+(r-l)/2;

        if(nElems %2 == 0){
            QuickSort.grantFinalPositions(v, l, r, med, med+1, Integer::compareTo);
            return (v[med] + v[med+1]) / 2;
        }

        QuickSort.grantFinalPositions(v, l, r, med, med, Integer::compareTo);
        return v[med];
    }

    private static class StringPrefixComparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            for(int i =0; i<Math.min(o1.length(), o2.length()); i++){
                if(o1.charAt(i) < o2.charAt(i))
                    return (o1.length()-i)*-1;
                if(o1.charAt(i) > o2.charAt(i))
                    return o1.length()-i;

            }
            return 0;
        }
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
     *
     * Binary Search
     */
    public static String greaterCommonPrefix(String[] v, int l, int r, String word) {
        if (v.length < 1 || r < l) {
            return null;
        }

        BinarySearch.Position p = BinarySearch.findNearest0(v, l, r, word, new StringPrefixComparator());

        return v[p.getDif() == word.length() ? r : p.getIdx()];
    }
}
