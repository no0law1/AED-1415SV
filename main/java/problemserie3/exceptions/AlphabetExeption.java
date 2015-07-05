package problemserie3.exceptions;

import sun.security.x509.Extension;

/**
 * Created by rcacheira on 05/07/15.
 */
public class AlphabetExeption extends Exception{

    public AlphabetExeption(){
        super();
    }

    public AlphabetExeption(String message){
        super(message);
    }

    public AlphabetExeption(String message, Throwable cause) {
        super(message, cause);
    }

    public AlphabetExeption(Throwable cause) {
        super(cause);
    }
}
