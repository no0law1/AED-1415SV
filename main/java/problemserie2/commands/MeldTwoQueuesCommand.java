package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

import java.io.IOException;

/**
 *
 */
public class MeldTwoQueuesCommand extends Command implements CommandInterface {

    public MeldTwoQueuesCommand(PriorityQueue[] queue) {
        super(queue);
    }

    @Override
    public void execute() throws IOException {
        PriorityQueue<Product> queue1 = getQueue();
        PriorityQueue<Product> queue2 = getQueue();
        if(queuesCanMeld(queue1, queue2)){
            System.out.print("Category: ");
            String category = scn.nextLine();
            PriorityQueue.meld(queue1, queue2, category, Product::getCategory);
        } else {
            System.out.println("Nothing has been done. See indexes better");
        }

    }

    private boolean queuesCanMeld(PriorityQueue<Product> queue1, PriorityQueue<Product> queue2) {
        return queue1 != queue2 && queue1 != null && queue2 != null;
    }
}
