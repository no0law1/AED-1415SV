package serie2;

import mylibrary.structures.StackArray;

/**
 *
 */
public class Utils {

    public static boolean verifyXML(String str) {
        StackArray<String> stack = new StackArray<>();

        int beginIndex = 0;
        for (int i = 0; i < str.length(); i++) {
            char aux = str.charAt(i);
            if (aux == '<') {
                beginIndex = i;
            }
            if (aux == '>') {
                String key = str.substring(beginIndex + 1, i);
                if (!stack.isEmpty() && key.charAt(0) == '/' && stack.peek().equals(key.substring(1, key.length()))) {
                    stack.pop();
                } else {
                    stack.push(key);
                }
            }
        }
        return stack.isEmpty();
    }

    public static<K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list){

    }
}
