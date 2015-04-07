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
        if(elem1.length<1 || elem2.length<1) {
            return -1;
        }
        int diff = Integer.MAX_VALUE;
        int i=0, j=0;

        while(i<elem1.length && j<elem2.length){
            if(Math.abs(elem1[i]-elem2[j])<diff){
                diff = Math.abs(elem1[i]-elem2[j]);
            }
            if(elem1[i]<elem2[j]){
                i++;
            }
            else if(elem1[i]>elem2[j]) {
                j++;
            }
            else{
                return 0;
            }
        }

		return diff;
	}

    /**
     *
     * @param v array
     * @param l begin of array to search
     * @param r end of array to search
     * @param x nearest to search
     * @param k max number of elements
     * @return
     */
    public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k) {
        if (v.length < 1 || r < l || k == 0) {
            return new int[0];
        }

        Heap.heapSort(v, v.length);     //O(n.lg(n))

        int size = Math.min(k, v.length);
        int[] finalResult = new int[size]; //k-1

        int xIndex = binarySearch(v, l, r, x);       // O(n)

        int fill = 0;
        int left = xIndex - 1, right = xIndex;
        for (; fill < size; ) {
            if (left <= 0) {
                finalResult[fill++] = v[right++];
            } else if (right >= v.length) {
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
     *
     * @param v array
     * @param x value to find
     * @return  Index of value {@code x} in array {@code v}.
     */
    private static int binarySearch(int[] v, int l, int r, int x) {
        //TODO: Implementation of Binary Search
        int xIndex;
        for (xIndex = 0; xIndex < v.length; xIndex++) {
            if(v[xIndex]==x){       //TODO:
                return xIndex;
            }
        }
        return xIndex-1;
    }


    public static int median(int[] v, int l, int r){
		throw new UnsupportedOperationException();
	}

    /**
     *  Implementation - O(n*k)
     *  n = array length
     *  k = word length
     *
     * @param v Array of strings
     * @param l Beginning of search
     * @param r End of search
     * @param word Word to search in array {@code v}
     * @return The word in array {@code v} that has a greater common prefix with {@code word}.
     */
	public static String greaterCommonPrefix( String[] v, int l, int r, String word) {
         if(v.length<1 || r<l){
             return null;
         }
         String result = v[v.length-1];     //TODO: See l and r of Unit tests.
         int finalEqual = 0, equal = 0;
         for (int i = r; i >= l; i--) {
             if(i>v.length-1){
                 continue;
             }
             for (int j = 0; j < word.length() && j < v[i].length(); j++) {
                if(word.charAt(j) == v[i].charAt(j)){
                    equal++;
                }
                else{
                    break;
                }
             }
             if(equal > finalEqual){
                 finalEqual = equal;
                 result = v[i];
             }
             equal = 0;
         }
         return result;
    }

    public static String greaterCommonPrefix2( String[] v, int l, int r, String word) {
        if(v.length<1 || r<l){
            return null;
        }

        return null;
    }
}
