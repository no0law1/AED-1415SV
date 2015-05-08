package serie2;

/**
 *
 */
public class Utils {

    /**
     * TODO: Stack
     * @param str
     * @return
     */
    public static boolean verifyXML(String str) {
        boolean beginningBracket = false;
        boolean closingBracket = false;
        int n = 0;

        for (int i = 0; i < str.length(); i++) {
            char aux = str.charAt(i);
            if (aux == '<') {
                beginningBracket = true;
            }
            if (aux == '>') {
                if (closingBracket) {
                    if (n == 0) {
                        return false;
                    }
                    beginningBracket = false;
                    closingBracket = false;
                    n--;
                } else if (beginningBracket) {
                    beginningBracket = false;
                    n++;
                }
            }
            if (aux == '/' && str.charAt(i - 1) == '<') {
                closingBracket = true;
            }

        }
        return !beginningBracket && !closingBracket && n == 0;
    }

    public static<K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list){

    }
}
