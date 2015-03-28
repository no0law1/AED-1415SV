package mylibrary;

/**
 * Created by Nuno on 27/03/2015.
 */
public class Heap {

    public static void heapSort(int[] v, int size) {
        buildMinHeap(v, size);
        int n = size;

        for (int i = size - 1; i > 0; i--) {
            exch(v, i , 0);
            minHeapify(v, 0, --n);
        }
    }

    public static void buildMinHeap(int[] arr, int heapSize) {
        int p = (heapSize>>1)-1;
        for ( ; p >= 0; --p) {
            minHeapify(arr, p, heapSize);
        }
    }

    public static void minHeapify(int[] arr, int i, int heapSize) {
        int largest;
        int l = 2*i+1;
        int r = 2*i+2;
        if(l<heapSize && arr[l] > arr[i])
            largest = l;
        else
            largest = i;

        if(r<heapSize && arr[r] > arr[largest]){
            largest=r;
        }
        if(largest!=i){
            exch(arr, i, largest);
            minHeapify(arr, largest, heapSize);
        }
    }

    private static void exch(int[] arr, int i, int largest) {
        int aux = arr[i];
        arr[i] = arr[largest];
        arr[largest] = aux;
    }
}
