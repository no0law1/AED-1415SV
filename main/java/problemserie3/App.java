package problemserie3;

import mylibrary.structures.List;
import mylibrary.structures.Stack;
import mylibrary.structures.StackArray;
import mylibrary.structures.graphs.Edge;
import mylibrary.structures.graphs.Vertex;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 */
public class App {

    private Object[] alphabet;
    File wordsFile;
    Stack orderedAlphabet;

    private App(File alphabetFile, File wordsFile) throws FileNotFoundException {
        readAlphabetFile(alphabetFile);
        this.wordsFile = wordsFile;
    }

    private void readAlphabetFile(File alphabetFile) throws FileNotFoundException {
        List<Vertex> vlist = new List();

        Scanner scanner = new Scanner(alphabetFile);

        while (scanner.hasNextLine()){
            vlist.add(new Vertex(scanner.nextLine().charAt(0)));
        }

        alphabet = vlist.toArray();
    }

    private void addEdge(char src, char dst){
        Vertex vsrc = null;
        Vertex vdst = null;
        for (int i = 0; i < alphabet.length; i++) {
            if(src == ((Vertex)alphabet[i]).id){
                vsrc = (Vertex)alphabet[i];
            }
            if(dst == ((Vertex)alphabet[i]).id){
                vdst = (Vertex)alphabet[i];
            }
        }
        vsrc.addEdge(vdst);
    }

    private void topologicalSort(){
        orderedAlphabet = new StackArray<>();
        boolean[] visited = new boolean[alphabet.length];
        for (int i = 0; i< alphabet.length; i++){
            if(visited[i] == false){
                topologicalSort(i, visited);
            }
        }
    }

    private int getAlphabetIndex(Vertex v){
        for(int i = 0; i<alphabet.length; i++){
            if(alphabet[i] == v) return i;
        }
        throw new IndexOutOfBoundsException("v not present in alphabet");
    }

    private void topologicalSort(int i, boolean[] visited){
        visited[i] = true;
        for(Edge edge = ((Vertex)alphabet[i]).adjList; edge != null; edge=edge.next){
            int alphidx = getAlphabetIndex(edge.adjacent);
            if(!visited[alphidx])
                topologicalSort(alphidx, visited);
        }
        orderedAlphabet.push((Vertex)alphabet[i]);
    }

    private void printOrderedAlphabet(){
        //TODO: changeit
        while(!orderedAlphabet.isEmpty())
            System.out.println((char)((Vertex)orderedAlphabet.pop()).id);
    }

    private void readWordsFile() throws FileNotFoundException {
        Scanner scanner = new Scanner(wordsFile);

        if(!scanner.hasNextLine()) new UnorderedLanguageException("Words File don't have words");

        String firstWord = scanner.nextLine();

        if(!scanner.hasNextLine()) new UnorderedLanguageException("Words File only have one word");

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

    public static void run(String alphabetFile, String wordsFile){
        if(!alphabetFile.endsWith(".al")){
            System.out.println("Unrecognized alphabet file extension");
            System.exit(2);
        }
        if(!wordsFile.endsWith(".ao")){
            System.out.println("Unrecognized words file extension");
            System.exit(3);
        }
        try {
            App app = new App(new File(alphabetFile), new File(wordsFile));
            app.readWordsFile();
            app.topologicalSort();
            app.printOrderedAlphabet();
            Scanner s = new Scanner(System.in);
            s.nextLine();
        }
        catch (FileNotFoundException ex){
            System.out.println(ex.getMessage());
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("usage: java alphabeticOrder alphabetFile.al alphabetFile.ao");
            System.exit(1);
        }
        App.run(args[0], args[1]);
    }
}
