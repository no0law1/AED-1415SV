package problemserie2.commands.factory;

import mylibrary.structures.PriorityQueue;
import problemserie2.Product;

import java.util.Scanner;

/**
 *
 */
public abstract class Command implements CommandInterface {

    protected PriorityQueue<Product> queue;

    protected Scanner scn;

    public Command(PriorityQueue queue){
        this.queue = queue;
        scn = new Scanner(System.in);
    }
}
