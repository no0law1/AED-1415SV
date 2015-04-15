package mylibrary.arrays;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by rcacheira on 15/04/15.
 */
public class PriorityQueue<T> {

    private T[] values;
    private Class<T> tclass;
    private Comparator<T> comp;
    private int nValues;

    @SuppressWarnings("unchecked")
    public PriorityQueue(Class<T> tclass, int initialHeapSize, Comparator<T> comp){
        nValues = 0;
        this.tclass = tclass;
        values = (T[]) Array.newInstance(tclass, initialHeapSize);
        this.comp = comp;
    }

    public T getNextValue(){
        if(nValues <= 0)
            return null;
        T value = (T) values[0];
        if (0 != --nValues) {
            Utils.swap(values, 0, nValues);
            if (nValues > 0) {
                Heap.heapify(values, 0, nValues-1, nValues, comp);
            }
        }
        return value;
    }

    private void remove(int idx) {
        if (idx >= nValues)
            throw new IndexOutOfBoundsException("idx greater than heap size");
        if (idx != --nValues){
            Utils.swap(values, idx, nValues);

            if (nValues > 0) {
                Heap.heapify(values, 0, idx, nValues, comp);
                //TODO: going down not needed now
            }
        }
    }

    public void addValue(T value) {
        if(nValues >= values.length) {
            //TODO: grow not needed now
            throw new RuntimeException("This heap don't implement grow");
        }
        values[nValues] = value;
        Heap.heapify(values, 0, nValues, nValues, comp);
        nValues++;
    }

    public int length(){
        return nValues;
    }

    public int size(){
        return values.length;
    }
}
