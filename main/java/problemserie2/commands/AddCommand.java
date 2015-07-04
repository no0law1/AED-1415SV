package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

import java.io.IOException;

/**
 *
 */
public class AddCommand extends Command implements CommandInterface {

    public AddCommand(PriorityQueue[] queue) {
        super(queue);
    }

    @Override
    public void execute() throws IOException {
        PriorityQueue<Product> queue = getQueue();
        if (queue != null) {
            System.out.println("Add");
            System.out.print("Category: ");
            String category = scn.nextLine();
            System.out.print("Agency: ");
            String agency = scn.nextLine();
            System.out.print("Buy Value: ");
            int bValue = Integer.parseInt(scn.nextLine());
            System.out.print("Actual Value: ");
            int aValue = Integer.parseInt(scn.nextLine());

            Product product = new Product(category, agency, bValue, aValue);

            queue.add(product, product.getLossValue());
            System.out.println(product + " added.");
        } else {
            System.out.println("No Queue");
        }
    }
}
