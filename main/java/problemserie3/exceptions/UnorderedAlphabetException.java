package problemserie3.exceptions;

/**
 * Created by rcacheira on 04/07/15.
 */
public class UnorderedAlphabetException extends AlphabetException {

    public UnorderedAlphabetException(){
        super();
    }

    public UnorderedAlphabetException(String message){
        super(message);
    }

    public UnorderedAlphabetException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnorderedAlphabetException(Throwable cause) {
        super(cause);
    }
}
