package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

/**
 *
 */
public class ChangePriorityCommand extends Command implements CommandInterface {

    public ChangePriorityCommand(PriorityQueue[] queue) {
        super(queue);
    }

    @Override
    public void execute() {
        PriorityQueue<Product> queue = getQueue();
        if (queue != null) {
            System.out.print("Key: ");
            Integer key = Integer.parseInt(scn.nextLine());
            Product product = queue.getValue(key);
            System.out.print("Actual Value: ");
            product.setActualValue(Integer.parseInt(scn.nextLine()));

            queue.update(key, product.getLossValue());
        } else {
            System.out.println("No Queue.");
        }
    }
}
