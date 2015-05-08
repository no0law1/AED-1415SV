package serie2;

import mylibrary.structures.StackArray;

/**
 *
 */
public class Utils {

    /**
     *
     * @param str
     * @return
     */
    public static boolean verifyXML(String str) {
        StackArray<String> stack = new StackArray<>();

        int beginIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char aux = str.charAt(i);
            if (aux == '<') {
                beginIndex = i;
            }
            if (aux == '>') {
                String inBrackets = str.substring(beginIndex + 1, i);
                if (!stack.isEmpty() && stack.peek().equals(inBrackets.substring(1, inBrackets.length()))) {
                    stack.pop();
                } else {
                    stack.push(inBrackets);
                }
            }
        }
        return stack.isEmpty();
    }

    public static<K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list){

    }
}
