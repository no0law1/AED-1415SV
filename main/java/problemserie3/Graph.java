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
        for (int i = 0; i < alphabetGraph.length; i++) {
            if(src == ((Vertex) alphabetGraph[i]).id){
                vertexSrc = (Vertex) alphabetGraph[i];
            }
            if(dst == ((Vertex) alphabetGraph[i]).id){
                vertexDst = (Vertex) alphabetGraph[i];
            }
        }
        if(vertexSrc == null || vertexDst == null){
            throw new IllegalArgumentException("No Character in alphabet");
        }
        vertexSrc.addEdge(vertexDst);
    }

    private void topologicalSort(){
        orderedAlphabet = new LinkedList<>();
        boolean[] visited = new boolean[alphabetGraph.length];

        for (int i = 0; i< alphabetGraph.length; i++){
            if(!visited[i]){
                topologicalSort(i, visited);
            }
        }
    }

    private void topologicalSort(int i, boolean[] visited){
        visited[i] = true;
        for(Edge edge = ((Vertex) alphabetGraph[i]).adjList; edge != null; edge=edge.next){
            int alphaIdx = getAlphabetIndex(edge.adjacent);
            if(!visited[alphaIdx])
                topologicalSort(alphaIdx, visited);
        }
        orderedAlphabet.add((Vertex) alphabetGraph[i]);
    }

    private int getAlphabetIndex(Vertex v){
        for(int i = 0; i< alphabetGraph.length; i++){
            if(alphabetGraph[i] == v) return i;
        }
        throw new IndexOutOfBoundsException("v not present in alphabetGraph");
    }

    public void printOrderedAlphabet(){
        Iterator<Vertex> it = orderedAlphabet.reverseIterator();
        while(it.hasNext()){
            System.out.println((char)it.next().id);
        }
    }
}
