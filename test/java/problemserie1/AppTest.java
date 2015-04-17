package problemserie1;

import org.junit.Test;

import java.io.FileNotFoundException;

/**
 * Created by Nuno on 26/03/2015.
 */
public class AppTest {

    @Test
    public void appTest() throws FileNotFoundException{
        int i = 1;
        String finalTxtPath = "../../FilesEx3/output.txt";
        String []inputTxtFiles = {
                "../../FilesEx3/f1.txt",
                "../../FilesEx3/f2.txt",
                "../../FilesEx3/f3.txt"};
        AppHeap app = new AppHeap(i, finalTxtPath, inputTxtFiles);
        app.mergeFiles();
    }
}