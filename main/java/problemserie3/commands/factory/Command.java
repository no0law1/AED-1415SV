package problemserie3.commands.factory;

import problemserie3.Graph;

import java.util.Scanner;

/**
 *
 */
public abstract class Command implements CommandInterface {

    protected final Graph graph;

    protected Scanner scn;

    public Command(Graph graph) {
        this.graph = graph;
        scn = new Scanner(System.in);
    }
}
