package problemserie3.commands.factory;

import problemserie3.AlphabetGraph;

import java.util.Scanner;

/**
 *
 */
public abstract class Command implements CommandInterface {

    protected final AlphabetGraph graph;

    protected Scanner scn;

    public Command(AlphabetGraph graph) {
        this.graph = graph;
        scn = new Scanner(System.in);
    }
}
