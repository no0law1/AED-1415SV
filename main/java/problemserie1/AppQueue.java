package problemserie1;

import mylibrary.arrays.PriorityQueue;
import problemserie1.filehandling.InputFile;
import problemserie1.filehandling.OutputFile;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

/**
 * Idea = Load every file into a List.
 *        After, sort the list and save to file.
 * WRONG! Not enough memory necessary to do that.
 *
 * Idea = Load from every file an equal amount(100) to a List.
 *        After, sort the list and save to the file.
 * WRONG! Between 1 and 101 in different files, it may be wrong.
 *
 * Idea = Load one by one from every file to an array equal to the size of arguments passed.
 *        Sort, remove first and load another word to it's place. Sort again and again..
 *
 * Created by Nuno on 26/03/2015.
*/
public class AppQueue {

    private int ith;
    private String outputFile;
    private String[] sourceFiles;
    int nSourceFiles;
    OutputFile of;
    PriorityQueue<InputFile> inputFileQueue;
    long nlines;

    private static class InputFileComparator implements Comparator<InputFile>{

        @Override
        public int compare(InputFile o1, InputFile o2) {
            if(o1 == null || o1.getCurrentLine() == null || o1.getCurrentLine().getIthWord() == null){
                return Integer.MAX_VALUE;
            }
            if(o2 == null || o2.getCurrentLine() == null || o2.getCurrentLine().getIthWord() == null){
                return Integer.MIN_VALUE;
            }
            return o2.getCurrentLine().getIthWord().compareTo(o1.getCurrentLine().getIthWord());
        }
    }

    public AppQueue(int ith, String outputFile, String[] sourceFiles){
        if(ith <= 0) throw new IllegalArgumentException("ith can't be less than 1");
        if(outputFile == null) throw new IllegalArgumentException("outputFile can't be null");
        if(sourceFiles == null) throw new IllegalArgumentException("sourceFiles can't be null");
        if(sourceFiles.length <= 0) throw new IllegalArgumentException("sourceFiles can't be less than 1");
        nSourceFiles = sourceFiles.length;
        this.ith = ith;
        this.outputFile = outputFile;
        this.sourceFiles = sourceFiles;
        inputFileQueue = new PriorityQueue<>(InputFile.class, nSourceFiles, new InputFileComparator());
    }

    public void mergeFiles() throws FileNotFoundException{
        of = new OutputFile(outputFile);

        nlines = 0;
        long startTime = System.currentTimeMillis();

        System.out.println("Processing files ... this can take a while");

        prepareInputFiles();
        processWords();
        closeFiles();

        System.out.println("Process finished. " + nlines + " processed lines in " + (System.currentTimeMillis() - startTime) + " millis");
    }

    private void processWords(){
        InputFile inputFile;
        while((inputFile = inputFileQueue.getNextValue()) != null) {
            of.writeln(inputFile.getCurrentLine().getText());
            inputFile.processNextAcceptedLine();
            if(inputFile.getCurrentLine().getText() != null) {
                inputFileQueue.addValue(inputFile);
            }
            nlines++;
        }
    }

    private void prepareInputFiles() throws FileNotFoundException{
        for(int i = 0; i<nSourceFiles; i++){
            inputFileQueue.addValue(new InputFile(sourceFiles[i], ith, System.lineSeparator()));
        }
    }

    private void closeFiles(){
        of.close();
        of = null;

        InputFile inputFile;
        while((inputFile = inputFileQueue.getNextValue()) != null){
            inputFile.close();
        }
    }

    /**
     *
     * @param args {ith, outputFile, files...}
     */
    public static void main(String []args) throws FileNotFoundException{
        if(args.length<=3){
            throw new IllegalArgumentException("usage: java -Xmx32m juntarFicheiros [ith] [ioutputFile] [inputFile1] [inputFile2] [inputFile3]");
        }

        //TODO: ArrayCopy
        AppQueue app = new AppQueue(Integer.parseInt(args[0]), args[1], Arrays.copyOfRange(args, 2, args.length));
        try {
            app.mergeFiles();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
            throw ex;
        }
    }
}
