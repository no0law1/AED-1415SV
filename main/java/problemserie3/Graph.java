package problemserie3;

import mylibrary.structures.LinkedList;
import mylibrary.structures.graphs.Edge;
import mylibrary.structures.graphs.Vertex;
import problemserie3.exceptions.UnorderedLanguageException;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Iterator;
import java.util.Scanner;

/**
 *
 */
public class Graph {

    /**
     * Array of vertexes
     */
    private Object[] alphabetGraph;

    private LinkedList<Vertex> orderedAlphabet;

    public Graph(File alphabetFile, File wordsFile) throws Exception {
        this.readAlphabetFile(alphabetFile);
        this.readWordsFile(wordsFile);
        this.topologicalSort();
    }

    private void readAlphabetFile(File alphabetFile) throws FileNotFoundException {
        LinkedList<Vertex> vlist = new LinkedList();

        Scanner scanner = new Scanner(alphabetFile);

        while (scanner.hasNextLine()){
            vlist.add(new Vertex(scanner.nextLine().charAt(0)));
        }

        alphabetGraph = vlist.toArray();
    }

    private void readWordsFile(File wordsFile) throws Exception {
        Scanner scanner = new Scanner(wordsFile);

        if(!scanner.hasNextLine()){
            throw new UnorderedLanguageException("Words File don't have words");
        }
        String firstWord = scanner.nextLine();

        if(!scanner.hasNextLine()){
            throw new UnorderedLanguageException("Words File only have one word");
        }
        do{
            String secondWord = scanner.nextLine();

            for(int i =0; i<Math.min(firstWord.length(), secondWord.length()); i++){
                if(firstWord.charAt(i) != secondWord.charAt(i)){
                    addEdge(firstWord.charAt(i), secondWord.charAt(i));
                    break;
                }
            }

            firstWord = secondWord;
        }while(scanner.hasNextLine());
    }

    private void addEdge(char src, char dst){
        Vertex vertexSrc = null;
        Vertex vertexDst = null;

        for (Object o : alphabetGraph) {
            Vertex v = (Vertex)o;
            if(src == v.id){
                vertexSrc = v;
            }
            if(dst == v.id){
                vertexDst = v;
            }
        }

        if(vertexSrc == null || vertexDst == null){
            throw new IllegalArgumentException("Any of the characters is not present in alphabet");
        }
        vertexSrc.addEdge(vertexDst);
    }

    private void topologicalSort(){
        orderedAlphabet = new LinkedList<>();
        for (Object o : alphabetGraph) {
            ((Vertex)o).visited = false;
        }

        for (Object o : alphabetGraph) {
            Vertex v = (Vertex) o;
            if(!v.visited){
                topologicalSort(v);
            }
        }
    }

    private void topologicalSort(Vertex v){
        v.visited = true;

        for(Edge edge = v.adjList; edge != null; edge=edge.next){
            if(!edge.adjacent.visited) {
                topologicalSort(edge.adjacent);
            }
        }

        orderedAlphabet.add(v);
    }

    public void printOrderedAlphabet(){
        Iterator<Vertex> it = orderedAlphabet.reverseIterator();
        while(it.hasNext()){
            System.out.println((char)it.next().id);
        }
    }

    public int getOrder(char c) {
        Iterator<Vertex> it = orderedAlphabet.reverseIterator();
        int i = 0;
        while(it.hasNext()){
            if(c == it.next().id){
                break;
            }
            i++;
        }
        return i;
    }
}
