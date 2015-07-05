package problemserie3.exceptions;

/**
 * Created by rcacheira on 04/07/15.
 */
public class UnorderedLanguageException extends Exception{

    public UnorderedLanguageException(){
        super();
    }

    public UnorderedLanguageException(String message){
        super(message);
    }

    public UnorderedLanguageException(String message, Throwable cause) {
        super(message, cause);
    }

    public UnorderedLanguageException(Throwable cause) {
        super(cause);
    }
}
