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
            System.out.println("Key of product to remove: ");
            Integer key = Integer.parseInt(scn.nextLine());
            queue.remove(key);
        } else {
            System.out.println("No Queue");
        }
    }
}
