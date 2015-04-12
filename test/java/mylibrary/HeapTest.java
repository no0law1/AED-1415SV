package mylibrary;

import mylibrary.arrays.Heap;
import org.junit.Test;

import java.util.Arrays;

import static org.junit.Assert.assertArrayEquals;

/**
 * Created by Nuno on 27/03/2015.
 */
public class HeapTest {

    @Test
    public void sortAscendingTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 0, 7, true);

        int[]expected = {1, 2, 3, 5, 6, 7, 9, 10};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortDescendingTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 0, 7, false);

        int[]expected = {10, 9, 7, 6, 5, 3, 2, 1};
        assertArrayEquals(expected, arr);
    }

    public void getNBiggestOrSmallestValuesTest(int[] arr, int[] expected, boolean biggest, int nValues){
        Heap.sort(arr, 0, 7, nValues, biggest);

        assertArrayEquals(expected, Arrays.copyOfRange(arr, arr.length-nValues, arr.length));
    }

    @Test
    public void get2BiggestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {9, 10};

        getNBiggestOrSmallestValuesTest(arr, expected, true, 2);
    }

    @Test
    public void get2SmallestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {2, 1};

        getNBiggestOrSmallestValuesTest(arr, expected, false, 2);
    }

    @Test
    public void get5BiggestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {5, 6, 7, 9, 10};

        getNBiggestOrSmallestValuesTest(arr, expected, true, 5);
    }

    @Test
    public void get8SmallestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {10, 9, 7, 6, 5, 3, 2, 1};

        getNBiggestOrSmallestValuesTest(arr, expected, false, 8);
    }

    @Test
    public void get8BiggestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {1, 2, 3, 5, 6, 7, 9, 10};

        getNBiggestOrSmallestValuesTest(arr, expected, true, 8);
    }

    @Test
    public void get5SmallestValuesTest(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};
        int[]expected = {6, 5, 3, 2, 1};

        getNBiggestOrSmallestValuesTest(arr, expected, false, 5);
    }

    @Test
    public void sortAscendingTest2(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 0, 6, true);

        int[]expected = {1, 2, 3, 5, 6, 7, 10, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortAscendingTest3(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 0, 2, true);

        int[]expected = {2, 3, 5, 1, 6, 10, 7, 9};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortAscendingTest4(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 2, 7, true);

        int[]expected = {3, 2, 1, 5, 6, 7, 9, 10};
        assertArrayEquals(expected, arr);
    }

    @Test
    public void sortAscendingTest5(){
        int[]arr = {3, 2, 5, 1, 6, 10, 7, 9};

        Heap.sort(arr, 1, 3, true);

        int[]expected = {3, 1, 2, 5, 6, 10, 7, 9};
        assertArrayEquals(expected, arr);
    }
}