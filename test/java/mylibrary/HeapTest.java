package mylibrary;

import mylibrary.sort.Heap;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nuno on 27/03/2015.
 */
public class HeapTest {

    @Test
    public void heapTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.heapSort(arr, 0, 7);

        int[]expected = {1, 2, 3, 5, 6, 7, 9, 10};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void heapTest2(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.heapSort(arr, 0, 6);

        int[]expected = {1, 2, 3, 5, 6, 7, 10, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void heapTest3(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.heapSort(arr, 0, 2);

        int[]expected = {2, 3, 5, 1, 6, 10, 7, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void heapTest4(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.heapSort(arr, 2, 7);

        int[]expected = {3, 2, 1, 5, 6, 7, 9, 10};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void heapTest5(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.heapSort(arr, 1, 3);

        int[]expected = {3, 1, 2, 5, 6, 10, 7, 9};
        assertArrayEquals(expected, arr);
    }
}