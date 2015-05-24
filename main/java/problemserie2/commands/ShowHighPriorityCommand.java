package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

/**
 *
 */
public class ShowHighPriorityCommand extends Command implements CommandInterface {

    public ShowHighPriorityCommand(PriorityQueue queue) {
        super(queue);
    }

    @Override
    public void execute() {
        System.out.println("Show Highest");
        System.out.println(queue.peek() == null ? "Nothing in queue" : queue.peek());
    }
}
