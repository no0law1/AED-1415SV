package problemserie3.commands;

import problemserie2.commands.factory.CommandInterface;
import problemserie3.Graph;
import problemserie3.commands.factory.Command;

import java.io.IOException;

/**
 *
 */
public class AnOrderCommand extends Command implements CommandInterface{

    public AnOrderCommand(Graph graph) {
        super(graph);
    }

    @Override
    public void execute() throws IOException {
        graph.printOrderedAlphabet();
    }
}
