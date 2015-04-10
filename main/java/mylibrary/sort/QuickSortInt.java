package mylibrary.sort;

/**
 * Created by Nuno on 10/04/2015.
 */
public class QuickSortInt {

    public static void quicksort(int a[], int left, int right) {
        int i;
        if (right <= left) return;
        i = partition(a, left, right);
        quicksort(a, left, i - 1);
        quicksort(a, i + 1, right);
    }

    public static int partition(int[] a, int l, int r) {
        int x = a[r];
        int i = l - 1;
        for (int j = l; j < r; j++) {
            if (a[j] <= x) {
                i++;
                exch(a, i, j);
            }
        }
        i++;
        exch(a, r, i);
        return i;
    }

    private static void exch(int[] a, int i, int j) {
        int aux = a[i];
        a[i] = a[j];
        a[j] = aux;
    }

}
