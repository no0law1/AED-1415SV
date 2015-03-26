package serie1;


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
                i++;
                j++;
            }
        }

		return diff;
	}
	
	public static int[] getTheKElementsNearestX(int[] v, int l, int r, int x, int k){
		throw new UnsupportedOperationException();
	}
	

	
	public static int median(int[] v, int l, int r){
		throw new UnsupportedOperationException();
	}	
	
	 public static String greaterCommonPrefix( String[] v, int l, int r, String word) {
         if(v.length<1 || r-l < 1){
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
