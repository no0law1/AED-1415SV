package mylibrary.arrays;

/**
 * Created by rcacheira on 12/04/15.
 */
public class Utils {

    public static void swap(int[] v, int i1, int i2) {
        int aux = v[i1];
        v[i1] = v[i2];
        v[i2] = aux;
    }

    public static <T> void swap(T[] v, int i1, int i2) {
        T aux = v[i1];
        v[i1] = v[i2];
        v[i2] = aux;
    }

}
