package problemserie2.commands;

import mylibrary.structures.PriorityQueue;
import problemserie2.commands.factory.Command;
import problemserie2.commands.factory.CommandInterface;

import java.io.IOException;

/**
 *
 */
public class CreateQueueCommand extends Command implements CommandInterface {

    public CreateQueueCommand(PriorityQueue[] queue) {
        super(queue);
    }

    @Override
    public void execute() throws IOException {
        Integer idx = getIndexOfQueue();
        if(idx != null){
            if(idx > queue.length){
                System.out.println("Error !");
                System.out.println("Max -> "+(queue.length-1));
            } else {
                queue[idx] = new PriorityQueue();
            }
        } else {
            System.out.println("Queue already exists");
        }
    }
}
