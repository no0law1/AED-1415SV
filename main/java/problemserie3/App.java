package problemserie3;

import mylibrary.structures.HashMap;
import problemserie3.commands.AnOrderCommand;
import problemserie3.commands.RelativeOrderCommand;
import problemserie3.commands.factory.Command;
import problemserie3.commands.factory.Option;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class App {

    private HashMap<Option, Command> commands;

    private Graph graph;

    private App(File alphabetFile, File wordsFile) throws Exception {
        graph = new Graph(alphabetFile, wordsFile);
        createCommands();
    }

    /**
     * Where to add commands
     */
    private void createCommands() {
        commands = new HashMap<>();
        commands.put(Option.AnOrder, new AnOrderCommand(graph));
        commands.put(Option.RelativeOrder, new RelativeOrderCommand(graph));
    }

    private void run() throws IOException {
        Scanner scn = new Scanner(System.in);
        Option opt;
        do{
            this.displayMenu();
            int result = scn.nextInt()-1;
            opt = Option.values()[result];
            if(opt != Option.Exit) {
                commands.get(opt).execute();
                System.in.read();
            }
        }while(opt != Option.Exit);
    }

    public static void start(String alphabetFile, String wordsFile){
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
            app.run();
        }
        catch (Exception ex){
            ex.printStackTrace();
        }
    }

    private void displayMenu() {
        System.out.println("Commands");
        System.out.println();
        for (Option option : Option.values()) {
            System.out.println(option.ordinal()+1 + " -> " + option);
        }
    }

    public static void main(String[] args) {
        if(args.length < 2) {
            System.out.println("usage: java alphabeticOrder alphabetFile.al alphabetFile.ao");
            System.exit(1);
        }
        App.start(args[0], args[1]);
    }
}
