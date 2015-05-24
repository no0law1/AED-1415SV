package problemserie2.commands.factory;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;

/**
 *
 */
public abstract class Command implements CommandInterface {

    protected PriorityQueue<Product> queue;

    public Command(PriorityQueue queue){
        this.queue = queue;
    }
}
