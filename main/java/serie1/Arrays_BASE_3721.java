package serie1;


import mylibrary.Heap;

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
	public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k){
        if(v.length<1 || r<l || k==0){
            return new int[0];
        }
        Heap.heapSort(v, v.length);     // O(n.lg(n))

        int size = (k < v.length) ? k : v.length;
        int[] finalResult = new int[size]; //k-1

        int xIndex = findIndex(v, x);       // O(n)

        int fill=0;
        int left = xIndex-1, right = xIndex;
        for (; fill<size;) {
            if(left<=0){
                finalResult[fill++] = v[right++];
            }
            else if(right>=v.length){
                finalResult[fill++] = v[left--];
            }
            else {
                if (Math.abs(v[left] - x) < Math.abs(v[right] - x)) {
                    finalResult[fill++] = v[left--];
                } else {
                    finalResult[fill++] = v[right++];
                }
            }

        }

		return finalResult;
	}

    private static int findIndex(int[] v, int x) {
        int xIndex;
        for (xIndex = 0; xIndex < v.length; xIndex++) {
            if(v[xIndex]==x){
                return xIndex;
            }
        }
        return xIndex-1;
    }


    public static int median(int[] v, int l, int r){
		throw new UnsupportedOperationException();
	}	
	
	 public static String greaterCommonPrefix( String[] v, int l, int r, String word) {
         if(v.length<1 || r<l){
             return null;
         }

         String result = v[v.length-1];
         int size = l-r;
         int equal = 0;
         for (int i = size; i >= 0; i--) {
             if(i>v.length){
                 continue;
             }
             for (int j = 0; j < word.length() && j < v[i].length(); j++) {

             }


         }
         
         return "";
    }
}
