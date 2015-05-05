package problemserie1.filehandling;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintStream;

/**
 * Created by rcacheira on 14/04/15.
 */
public class OutputFile {
    private PrintStream ps;

    public OutputFile(String fileNamePath) throws FileNotFoundException {
        ps = new PrintStream(new FileOutputStream(fileNamePath, false), true);
    }

    public void writeln(String line){
        ps.println(line);
    }

    public void close(){
        ps.close();
    }
}
