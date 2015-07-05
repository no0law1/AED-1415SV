package problemserie3.commands;

import problemserie2.commands.factory.CommandInterface;
import problemserie3.Graph;
import problemserie3.commands.factory.Command;

import java.io.IOException;

/**
 *
 */
public class RelativeOrderCommand extends Command implements CommandInterface {
    public RelativeOrderCommand(Graph app) {
        super(app);
    }

    @Override
    public void execute() throws IOException {
        //TODO
    }
}
