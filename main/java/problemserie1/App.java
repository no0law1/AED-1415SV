package problemserie1;

import problemserie1.filehandling.InputFile;

import java.io.*;
import java.util.Arrays;
import java.util.Scanner;

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
public class App {

    private int ith;
    private String outputFile;
    private String[] sourceFiles;
    int nSourceFiles;
    PrintStream ps;
    InputFile inputFiles[];
    long nlines;

    public App(int ith, String outputFile, String []sourceFiles){
        if(ith <= 0) throw new IllegalArgumentException("ith can't be less than 1");
        if(outputFile == null) throw new IllegalArgumentException("outputFile can't be null");
        if(sourceFiles == null) throw new IllegalArgumentException("sourceFiles can't be null");
        if(sourceFiles.length <= 0) throw new IllegalArgumentException("sourceFiles can't be less than 1");
        nSourceFiles = sourceFiles.length;
        this.ith = ith;
        this.outputFile = outputFile;
        this.sourceFiles = sourceFiles;
        inputFiles = new InputFile[nSourceFiles];
    }

    public void mergeFiles() throws FileNotFoundException{
        ps = new PrintStream(new FileOutputStream(outputFile, false), true);

        nlines = 0;
        long startTime = System.currentTimeMillis();

        prepareInputFiles();
        processWords();
        closeFiles();

        System.out.println("n lines: " + nlines + " in millis " + (System.currentTimeMillis() - startTime));
    }

    private void processWords(){
        int smallestWord = 0;

        for(;;) {
            int i = 0;
            for (; i < nSourceFiles; i++) {
                if (inputFiles[i].getIthWord() != null) {
                    smallestWord = i++;
                    break;
                }
            }

            for (; i < nSourceFiles; i++) {
                if (inputFiles[i].getIthWord() != null &&
                        inputFiles[smallestWord].getIthWord().compareTo(inputFiles[i].getIthWord()) < 0) {
                    smallestWord = i;
                }
            }
            if(inputFiles[smallestWord].getIthWord() == null) break;
            ps.println(inputFiles[smallestWord].getLine());
            inputFiles[smallestWord].getNextAcceptedLine();
            nlines++;
        }
    }

    private void prepareInputFiles() throws FileNotFoundException{
        for(int i = 0; i<nSourceFiles; i++){
            inputFiles[i] = new InputFile(sourceFiles[i], ith, System.lineSeparator());
        }
    }

    private void closeFiles(){
        if(ps != null){
            ps.flush();
            ps.close();
            ps = null;
        }

        for(int i = 0; i<nSourceFiles; i++){
            inputFiles[i].close();
            inputFiles[i] = null;
        }
    }

    /**
     *
     * @param args {ith, outputFile, files...}
     */
    public static void main(String []args) throws FileNotFoundException{
        if(args.length<=3){
            throw new IllegalArgumentException("usage: java -Xmx32m juntarFicheiros 1 output.txt f1.txt f2.txt f3.txt");
        }

        App app = new App(Integer.parseInt(args[0]), args[1], Arrays.copyOfRange(args, 2, args.length-2));
        try {
            app.mergeFiles();
        }
        catch (FileNotFoundException ex){
            ex.printStackTrace(System.out);
            throw ex;
        }

    }
}
