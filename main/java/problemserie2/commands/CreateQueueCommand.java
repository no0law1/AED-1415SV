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
        Integer idx;
        if((idx = getIndexOfQueue()) == null){
            queue[idx] = new PriorityQueue();
        } else {
            System.out.println("Queue already exists");
        }
    }
}
