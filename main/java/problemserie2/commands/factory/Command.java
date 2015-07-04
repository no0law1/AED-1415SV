package problemserie2.commands.factory;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;

import java.util.Scanner;

/**
 *
 */
public abstract class Command implements CommandInterface {

    protected PriorityQueue[] queue;

    protected Scanner scn;

    public Command(PriorityQueue[] queue) {
        this.queue = queue;
        scn = new Scanner(System.in);
    }

    public PriorityQueue<Product> getQueue() {
        int index = getIndexOfQueue();
        if (queue[index] != null) {
            return queue[index];
        }
        System.out.println("No such Queue");
        return null;
    }

    public Integer getIndexOfQueue() {
        System.out.print("Number of Queue: ");
        return Integer.parseInt(scn.nextLine());
    }
}
