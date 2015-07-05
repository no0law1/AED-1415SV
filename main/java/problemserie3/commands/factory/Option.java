package problemserie3.commands.factory;

/**
 * Options of App
 */
public enum Option{
    AnOrder("List Character order"),
    RelativeOrder("Attain Character order of two words"),
    Exit("Exit");

    private String humamName;

    Option(String humamName) {
        this.humamName = humamName;
    }

    @Override public String toString() { return humamName; }


}
