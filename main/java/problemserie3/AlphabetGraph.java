package problemserie3;

import mylibrary.structures.LinkedList;
import mylibrary.structures.graphs.Graph;
import mylibrary.exception.SortException;
import mylibrary.structures.graphs.Vertex;
import problemserie3.exceptions.AlphabetException;
import problemserie3.exceptions.UnorderedAlphabetException;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

/**
 * Created by rcacheira on 05/07/15.
 */
public class AlphabetGraph extends Graph {
    /**
     * Array of vertexes
     */
    private LinkedList<Vertex> order;

    public void readAlphabetFile(File alphabetFile) throws FileNotFoundException {
        Scanner scanner = new Scanner(alphabetFile);
        order = null;
        clear();

        while (scanner.hasNextLine()){
            addVertex(scanner.nextLine().charAt(0));
        }
    }

    public void readWordsFile(File wordsFile) throws FileNotFoundException, AlphabetException {
        Scanner scanner = new Scanner(wordsFile);

        if(!scanner.hasNextLine()){
            throw new UnorderedAlphabetException("Words File don't have words");
        }
        String firstWord = scanner.nextLine();

        if(!scanner.hasNextLine()){
            throw new UnorderedAlphabetException("Words File only have one word");
        }
        do{
            String secondWord = scanner.nextLine();

            for(int i =0; i<Math.min(firstWord.length(), secondWord.length()); i++){
                if(firstWord.charAt(i) != secondWord.charAt(i)){
                    try {
                        addEdge(firstWord.charAt(i), secondWord.charAt(i));
                    }catch (IllegalArgumentException ex){
                        throw new AlphabetException("Unrecognized characters on words file");
                    }
                    break;
                }
            }

            firstWord = secondWord;
        }while(scanner.hasNextLine());
    }

    public void printOrderedAlphabet(PrintStream out) throws SortException {
        if(order == null){
            order = topologicalSort();
        }
        Iterator<Vertex> it = order.reverseIterator();
        while(it.hasNext()){
            out.println((char)it.next().id);
        }
    }

    public int getOrder(char c) throws SortException, AlphabetException {
        if(order == null){
            order = topologicalSort();
        }
        Iterator<Vertex> it = order.reverseIterator();
        int i = 0;
        while(it.hasNext()){
            if(c == it.next().id){
                return i;
            }
            i++;
        }
        throw new AlphabetException("Any of the characters is not present in alphabet");
    }
}
