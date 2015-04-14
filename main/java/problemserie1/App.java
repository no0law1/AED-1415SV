package problemserie1;

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

    private int i;
    private String outputFile;
    private String[] sourceFiles;
    int nSourceFiles;
    PrintStream ps;
    Scanner scanner[];
    String line[];
    String iword[];
    long nlines;

    public App(int i, String outputFile, String []sourceFiles){
        if(i <= 0) throw new IllegalArgumentException("i can't be less than 1");
        if(outputFile == null) throw new IllegalArgumentException("outputFile can't be null");
        if(sourceFiles == null) throw new IllegalArgumentException("sourceFiles can't be null");
        if(sourceFiles.length <= 0) throw new IllegalArgumentException("sourceFiles can't be less than 1");
        nSourceFiles = sourceFiles.length;
        this.i = i;
        this.outputFile = outputFile;
        this.sourceFiles = sourceFiles;
        scanner = new Scanner[sourceFiles.length];
        line = new String[sourceFiles.length];
        iword = new String[sourceFiles.length];
    }

    public void mergeFiles() throws FileNotFoundException{
        ps = new PrintStream(new FileOutputStream(outputFile, false));

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
            int j = 0;
            for (; j < nSourceFiles; j++) {
                if (iword[j] != null) {
                    smallestWord = j++;
                    break;
                }
            }

            for (; j < nSourceFiles; j++) {
                if (iword[j] != null && iword[smallestWord].compareTo(iword[j]) < 0) {
                    smallestWord = j;
                }
            }
            if(iword[smallestWord] == null) break;
            ps.println(line[smallestWord]);
            getNextAcceptedLineFromFile(smallestWord);
            nlines++;
        }
    }

    private void prepareInputFiles() throws FileNotFoundException{
        for(int j = 0; j<nSourceFiles; j++){
            scanner[j] = new Scanner(new File(sourceFiles[j]));
            scanner[j].useDelimiter(System.lineSeparator());
            getNextAcceptedLineFromFile(j);
        }
    }

    private void getNextAcceptedLineFromFile(int fileIdx){
        String words[];
        while (scanner[fileIdx].hasNextLine() &&
                (line[fileIdx] = scanner[fileIdx].nextLine()) != null &&
                (words = line[fileIdx].split(" ")).length >= i){
            iword[fileIdx] = words[i-1];
            return;
        }
        iword[fileIdx] = null;
        line[fileIdx] = null;
    }

    private void closeFiles(){
        if(ps != null){
            ps.flush();
            ps.close();
            ps = null;
        }

        for(int j = 0; j<nSourceFiles; j++){
            scanner[j].close();
            scanner[j] = null;
        }
    }

    /**
     *
     * @param args {i, outputFile, files...}
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
