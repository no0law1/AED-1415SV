package problemserie3.exceptions;

/**
 * Created by rcacheira on 05/07/15.
 */
public class AlphabetException extends Exception{

    public AlphabetException(){
        super();
    }

    public AlphabetException(String message){
        super(message);
    }

    public AlphabetException(String message, Throwable cause) {
        super(message, cause);
    }

    public AlphabetException(Throwable cause) {
        super(cause);
    }
}
