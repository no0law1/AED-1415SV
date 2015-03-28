package mylibrary;

import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nuno on 27/03/2015.
 */
public class HeapTest {

    @Test
    public void heapTest(){
        int[]arr = {3, 2, 5, 1, 6};

        Heap.heapSort(arr, arr.length);

        int[]result = {1, 2, 3, 5, 6};

        assertArrayEquals(arr, result);
    }
}