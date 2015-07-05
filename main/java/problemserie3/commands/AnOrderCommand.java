package problemserie3.commands;

import mylibrary.exception.SortException;
import problemserie2.commands.factory.CommandInterface;
import problemserie3.commands.factory.Command;
import problemserie3.AlphabetGraph;

import java.io.IOException;

/**
 *
 */
public class AnOrderCommand extends Command implements CommandInterface{

    public AnOrderCommand(AlphabetGraph graph) {
        super(graph);
    }

    @Override
    public void execute() throws IOException {
        try {
            graph.printOrderedAlphabet(System.out);
        }
        catch (SortException ex){
            System.out.println("Alphabet can't be sorted");
        }
    }
}
