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
        commands.put(Option.RemoveHighPriority, new RemoveHighPriorityCommand(queues));
        commands.put(Option.Meld, new MeldTwoQueuesCommand(queues));
    }

    private void displayMenu(){
        System.out.println("Commands");
        System.out.println();
        for (Option option : Option.values()) {
            System.out.println(option.ordinal()+1 + " -> " + option);
        }
    }

    private void run() throws IOException {
        Scanner scn = new Scanner(System.in);
        Option opt;
        do{
            this.displayMenu();
            int result = scn.nextInt()-1;
            opt = Option.values()[result];
            if(opt != Option.Exit){
                commands.get(opt).execute();
                System.in.read();
            }
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
