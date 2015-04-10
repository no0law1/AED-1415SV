package mylibrary.Util;

/**
 * Created by rcacheira on 10/04/15.
 */
public class Boxing {
    public static Integer[] array(int[] v){
        Integer[] result = new Integer[v.length];
        for(int i = 0; i<=v.length; i++)
            result[i] = v[i];
        return result;
    }
}
