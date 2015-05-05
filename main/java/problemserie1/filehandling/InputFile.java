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
    private Line line;

    public InputFile(String filenamePath, int ith, String wordDelimiter) throws FileNotFoundException {
        //TODO: dropar excepções
        this.ith = ith;
        scanner = new Scanner(new File(filenamePath));
        scanner.useDelimiter(wordDelimiter);
        line = Line.create(ith, scanner);
    }

    public Line getCurrentLine() {
        return line;
    }

    public void processNextAcceptedLine(){
        line.processNextAcceptedLine(scanner);
    }

    public void close(){
        scanner.close();
    }
}
