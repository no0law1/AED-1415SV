package problemserie1.filehandling;

import java.util.Scanner;

/**
 * Created by rcacheira on 14/04/15.
 */
public class Line {
    public final int ith;
    private String text;
    private String ithWord;
    //words

    private Line(int ith){
        this.ith = ith;
    }

    public void processNextAcceptedLine(Scanner s){
        String lineWords[];
        while (s.hasNextLine() &&
                (text = s.nextLine()) != null &&
                (lineWords = text.split(" ")).length >= ith){
            ithWord = lineWords[ith-1];
            return;
        }
        ithWord = null;
        text = null;
    }

    public static Line create(int ith, Scanner s){
        Line line = new Line(ith);
        line.processNextAcceptedLine(s);
        return line;
    }

    public String getIthWord() {
        return ithWord;
    }

    public String getText() {
        return text;
    }
}
