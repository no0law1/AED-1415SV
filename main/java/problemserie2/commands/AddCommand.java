package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

/**
 *
 */
public class AddCommand extends Command implements CommandInterface{

    public AddCommand(PriorityQueue queue) {
        super(queue);
    }

    @Override
    public void execute() {
        System.out.println("Add");
        //TODO:
    }
}
