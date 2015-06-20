package problemserie2;

import mylibrary.structures.HashMap;
import mylibrary.structures.PriorityQueue;
import problemserie2.commands.*;
import problemserie2.commands.factory.CommandInterface;
import problemserie2.commands.factory.Option;

import java.io.IOException;
import java.util.Scanner;

/**
 *
 */
public class App {

    private static HashMap<Option, CommandInterface> commands;

    public App(){
        createCommands();
    }

    private void createCommands() {
        PriorityQueue[] queues = new PriorityQueue[8];
        commands = new HashMap<>();
        commands.put(Option.CreateUser, new CreateQueueCommand(queues));
        commands.put(Option.Add, new AddCommand(queues));
        commands.put(Option.ChangePriority, new ChangePriorityCommand(queues));
        commands.put(Option.Remove, new RemoveCommand(queues));
        commands.put(Option.ShowHighPriority, new ShowHighPriorityCommand(queues));
        commands.put(Option.Meld, new MeldTwoQueuesCommand(queues));
    }

    private void displayMenu(){
        System.out.println("Commands");
        System.out.println();
        System.out.println("1. Create User");
        System.out.println("2. Add to Queue");
        System.out.println("3. Change priority of a product in queue");
        System.out.println("4. Remove from queue");
        System.out.println("5. Show Highest Product Priority");
        System.out.println("6. Meld two queues");
        System.out.println("7. Exit");
    }

    private void run() throws IOException {
        Scanner scn = new Scanner(System.in);
        Option opt;
        do{
            this.displayMenu();
            int result = scn.nextInt();
            opt = Option.values()[result];
            commands.get(opt).execute();
            System.in.read();
        }while(opt != Option.Exit);
    }

    public static void main(String[] args){
        try {
            App app = new App();
            app.run();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
