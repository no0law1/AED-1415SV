package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

import java.io.IOException;

/**
 *
 */
public class AddCommand extends Command implements CommandInterface{

    public AddCommand(PriorityQueue queue) {
        super(queue);
    }

    @Override
    public void execute() throws IOException {
        System.out.println("Add");
        System.out.print("ID: ");
        int id = Integer.parseInt(scn.nextLine());
        System.out.print("Category: ");
        String category = scn.nextLine();
        System.out.print("Agency: ");
        String agency = scn.nextLine();
        System.out.print("Buy Value: ");
        float bValue = Float.parseFloat(scn.nextLine());
        System.out.print("Actual Value: ");
        float aValue = Float.parseFloat(scn.nextLine());

        System.out.print("Priority: ");
        int priority = scn.nextInt();

        Product product = new Product(id, category, agency, bValue, aValue);

        queue.add(product, priority);
        System.out.println(product + " added.");
    }
}
