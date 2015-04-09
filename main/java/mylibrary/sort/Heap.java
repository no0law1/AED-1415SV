package mylibrary.sort;

public class Heap {

    public static void heapSort(int[] v, int l, int r) {
        int heapSize = r-l + 1;
        buildMinHeap(v, l, heapSize); //RC: buildMinHeap from l
        int n = heapSize; //RC: auxiliar heap size to decrement

        for (int i = l + heapSize - 1; i > l; i--) { //RC: iterate while i > l
            exch(v, i, l); //RC: exchange i with l
            minHeapify(v, l, l, --n); //RC: min Heapify l
        }
    }

    public static void buildMinHeap(int[] arr, int l, int heapSize) {
        for (int p = l+(heapSize>>1)-1; p >= l; --p) { //RC: iterate while p >= l
            minHeapify(arr, l, p, heapSize); //RC: min Heapify p
        }
    }

    public static void minHeapify(int[] arr, int l, int i, int heapSize){
        int ls = l+(2*(i-l)+1); //RC: calc i left sun
        int rs = ls+1; //RC: calc i right sun
        int biggest = i;
        if(ls<l+heapSize && arr[ls] > arr[biggest]) //RC: if left sun less then heapSize and arr[left sun] > arr[biggest]
            biggest = ls; //RC: then left sun is the biggest
        if(rs<l+heapSize && arr[rs] > arr[biggest]){ //RC: if right sun less then heapSize and arr[left sun] > arr[biggest]
            biggest = rs; //RC: then right sun is the biggest
        }
        if(biggest!=i){ //RC: if the biggest isn't i
            exch(arr, i, biggest); //RC: then exchange
            minHeapify(arr, l, biggest, heapSize); //RC: and min Heapify biggest
        }
    }

    private static void exch(int[] arr, int idx1, int idx2) {
        int aux = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = aux;
    }

}
