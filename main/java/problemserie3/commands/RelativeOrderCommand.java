package problemserie3.commands;

import problemserie2.commands.factory.CommandInterface;
import problemserie3.commands.factory.Command;
import problemserie3.AlphabetGraph;

import java.io.IOException;

/**
 *
 */
public class RelativeOrderCommand extends Command implements CommandInterface {
    public RelativeOrderCommand(AlphabetGraph graph) {
        super(graph);
    }

    @Override
    public void execute() throws IOException {
        try {
            System.out.print("First word: ");
            String firstWord = scn.nextLine();
            System.out.print("Second word: ");
            String secondWord = scn.nextLine();

            int firstOrder = -1;
            int secondOrder = -1;
            int i = 0;
            for (; i < Math.min(firstWord.length(), secondWord.length()); i++) {
                if (firstWord.charAt(i) != secondWord.charAt(i)) {
                    firstOrder = graph.getOrder(firstWord.charAt(i));
                    secondOrder = graph.getOrder(secondWord.charAt(i));
                    break;
                }
            }
            if (firstOrder > secondOrder
                    || (firstOrder == secondOrder && i < Math.max(firstWord.length(), secondWord.length()))) {
                String aux = secondWord;
                secondWord = firstWord;
                firstWord = aux;
            }

            System.out.println("Relative order: " + firstWord + " -> " + secondWord);
        } catch (Exception ex){
            System.out.println(ex.getMessage());
        }
    }
}
