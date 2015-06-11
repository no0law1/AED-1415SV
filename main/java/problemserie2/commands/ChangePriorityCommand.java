package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

/**
 *
 */
public class ChangePriorityCommand extends Command implements CommandInterface {

    public ChangePriorityCommand(PriorityQueue queue) {
        super(queue);
    }

    @Override
    public void execute() {
        System.out.println("Change priority to");

        //TODO:
    }
}
