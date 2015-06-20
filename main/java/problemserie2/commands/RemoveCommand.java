package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

/**
 *
 */
public class RemoveCommand extends Command implements CommandInterface {

    public RemoveCommand(PriorityQueue[] queue) {
        super(queue);
    }

    @Override
    public void execute() {
        PriorityQueue<Product> queue = getQueue();
        if(queue != null) {
            if (queue.peek() == null) {
                System.out.println("Nothing in queue");
            } else {
                Product prod = queue.poll();
                System.out.println("Removed: " + prod.toString());
            }
        } else {
            System.out.println("No Queue");
        }
    }
}
