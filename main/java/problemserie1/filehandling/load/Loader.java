package problemserie1.filehandling.load;

/**
 * Created by Nuno on 26/03/2015.
 */
public interface Loader {

    /**
     *
     * @param path Path of file to load.
     * @return Next String.
     */
    String loadFromFile(String path);
}
