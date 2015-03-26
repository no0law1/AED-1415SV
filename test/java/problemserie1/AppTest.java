package problemserie1;

import org.junit.Test;

/**
 * Created by Nuno on 26/03/2015.
 */
public class AppTest {

    @Test
    public void randomTest(){
        String[] args = {"1", "output", "f1", "f2", "f3"};
        String[] inputTxtFiles = new String[args.length-1-1];
        System.arraycopy(args, 2, inputTxtFiles, 0, args.length-1-1);
    }
}