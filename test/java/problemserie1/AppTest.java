package problemserie1;

import org.junit.Test;

/**
 * Created by Nuno on 26/03/2015.
 */
public class AppTest {

    @Test
    public void arrayCopyTest(){
        String[] args = {"1", "output", "f1", "f2", "f3"};
        String[] inputTxtFiles = new String[args.length-1-1];
        System.arraycopy(args, 2, inputTxtFiles, 0, args.length-1-1);
    }

    @Test
    public void appTest(){
        int numberOfWordsAcceptedByFile = 1;
        String finalTxtPath = "../files/output.txt";
        String []inputTxtFiles = {
                "../test/java/problemserie1/files/f1.txt",
                "../test/java/problemserie1/files/f2.txt",
                "../test/java/problemserie1/files/f3.txt"};
        App app = new App(numberOfWordsAcceptedByFile, finalTxtPath, inputTxtFiles);
    }
}