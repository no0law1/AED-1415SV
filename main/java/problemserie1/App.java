package problemserie1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
* Created by Nuno on 26/03/2015.
        */
public class App {

    private List<String> words;

    private int numberOfWordsAcceptedByFile;

    private File finalTxt;

    public App(int numberOfWordsAcceptedByFile, String finalTxtPath, String []inputTxtFiles){
        this.numberOfWordsAcceptedByFile = numberOfWordsAcceptedByFile;
        finalTxt = new File(finalTxtPath);
        addToFinalTxtPath(inputTxtFiles);
    }

    /**
     * With -Xmx32m, app reaches limit.
     *
     * @param inputTxtFiles
     */
    private void addToFinalTxtPath(String[] inputTxtFiles) {
        words = new ArrayList<>();
        for (int i = 0; i < inputTxtFiles.length; i++) {
            try (Scanner txtFileStream = new Scanner(new FileReader(inputTxtFiles[i]))) {
                while(txtFileStream.hasNext()){
                    String word = txtFileStream.nextLine();
                    if(word.length() >= numberOfWordsAcceptedByFile){
                        words.add(word);
                    }
                }
            }
            catch (FileNotFoundException e) {
                e.printStackTrace();
            }
        }
    }


    /**
     *
     * @param args {numberOfWordsAcceptedByFile, outputFile, files...}
     */
    public static void main(String []args){
        if(args.length<=3){
            throw new IllegalArgumentException();
        }
        String[] inputTxtFiles = new String[args.length-1-1];
        System.arraycopy(args, 2, inputTxtFiles, 0, args.length-1-1);

        App app = new App(Integer.parseInt(args[0]), args[1], inputTxtFiles);


    }
}
