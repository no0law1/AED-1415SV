package problemserie1.filehandling;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 * Created by rcacheira on 14/04/15.
 */
public class InputFile {
    public final int ith;
    private Scanner scanner;
    private String line;
    private String ithWord;

    public InputFile(String filenamePath, int ith, String wordDelimiter) throws FileNotFoundException {
        //TODO: dropar exceções
        this.ith = ith;
        scanner = new Scanner(new File(filenamePath));
        scanner.useDelimiter(wordDelimiter);
        getNextAcceptedLine();
    }

    public void getNextAcceptedLine(){
        String lineWords[];
        while (scanner.hasNextLine() &&
                (line = scanner.nextLine()) != null &&
                (lineWords = line.split(" ")).length >= ith){
            ithWord = lineWords[ith-1];
            return;
        }
        ithWord = null;
        line = null;
    }

    public String getIthWord() {
        return ithWord;
    }

    public String getLine() {
        return line;
    }

    public void close(){
        scanner.close();
    }
}
