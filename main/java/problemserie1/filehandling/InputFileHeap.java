package problemserie1.filehandling;

import mylibrary.arrays.Heap;
import mylibrary.arrays.Utils;

import java.lang.reflect.Array;
import java.util.Comparator;

/**
 * Created by rcacheira on 15/04/15.
 */
public class InputFileHeap {

    private static class InputFileComparator implements Comparator<InputFile>{

        @Override
        public int compare(InputFile o1, InputFile o2) {
            if(o1 == null || o1.getCurrentLine().getIthWord() == null){
                return Integer.MAX_VALUE;
            }
            if(o2 == null || o2.getCurrentLine().getIthWord() == null){
                return Integer.MIN_VALUE;
            }
            return o2.getCurrentLine().getIthWord().compareTo(o1.getCurrentLine().getIthWord());
        }
    }

    private InputFile[] values;
    private Comparator<InputFile> comp;
    private int nValues;

    @SuppressWarnings("unchecked")
    public InputFileHeap(int heapSize){
        nValues = 0;
        values = new InputFile[heapSize];
        this.comp = new InputFileComparator();
    }

    public String getNextLine(){
        if(nValues <= 0)
            return null;
        String line = values[0].getCurrentLine().getText();
        values[0].processNextAcceptedLine();
        Heap.heapify(values, 0, 0, nValues, comp);
        return line;
    }

    public void addValue(InputFile value) {
        if(nValues >= values.length) {
            throw new RuntimeException("This heap doesn't grow");
        }
        values[nValues] = value;
        Heap.heapify(values, 0, 0, nValues, comp);
        nValues++;
    }

    public void close(){
        for(int i = 0; i < values.length; i++){
            values[i].close();
        }
    }

    public int length(){
        return nValues;
    }

    public int size(){
        return values.length;
    }
}
