package problemserie2.commands.factory;

/**
 *
 */
public enum Option{
    CreateUser("Create Holder"),
    Add("Add Product"),
    ChangePriority("Change priority of a product"),
    Remove("Remove a Product"),
    ShowHighPriority("Show Highest Product Priority"),
    RemoveHighPriority("Remove Highest Product Priority"),
    Meld("Meld two Holders"),
    Exit("Exit");

    private String humamName;

    Option(String humamName) {
        this.humamName = humamName;
    }

    @Override public String toString() { return humamName; }


}
