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

        int idx = 0;
        for (;idx < str.length();) {
            int openIdx = str.indexOf('<', idx);
            if(openIdx == -1) break;
            int closeIdx = str.indexOf('>', openIdx);
            if(closeIdx == -1) return false;

            boolean closeKey = str.charAt(openIdx+1) == '/';
            String key = str.substring(openIdx + ((closeKey) ? 2 : 1), closeIdx);
            if(!closeKey) stack.push(key);
            else if(stack.isEmpty() || !stack.pop().equals(key)) return false;
            idx = closeIdx+1;
        }
        return stack.isEmpty();
    }

    public static<K,V> void replace(HashNode<K,V>[] hashMap, HashNode<K,V> list){
        int M = hashMap.length;

        while(list != null){
            int hashAddress = list.key.hashCode()%M;
            HashNode hashNode = hashMap[hashAddress];
            while(hashNode != null){
                if(hashNode.key.equals(list.key)){
                    hashNode.value = list.value;
                    break;
                }
                hashNode = hashNode.next;
            }
            list = list.next;
        }
    }
}
