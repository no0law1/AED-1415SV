package mylibrary.structures;

import serie2.HashNode;

/**
 *
 */
public class HashMap<K, V> {

    private static final int DEFAULT_SIZE = 32;

    private HashNode<K, V>[] hashMap;

    @SuppressWarnings("unchecked")
    public HashMap(int size) {
        hashMap = (HashNode<K, V>[]) new HashNode[size];
    }

    public HashMap(){
        this(DEFAULT_SIZE);
    }

    public void put(K k, V v) {
        if(k == null || v == null) return;
        int i = index(k);
        // For duplicate purposes
        for (HashNode j = hashMap[i]; j != null; j = j.next) {
            if(j.key.equals(k)){
                j.value = v;
                return;
            }
        }
        HashNode<K,V> aux = new HashNode<>(k, v);
        aux.next = hashMap[i];
        hashMap[i] = aux;
    }

    public V get(K k) {
        int i = index(k);
        HashNode<K, V> curr = hashMap[i];
        while (curr != null) {
            if (curr.key.equals(k)) {
                return curr.value;
            }
            curr = curr.next;
        }
        return null;
    }

    public V remove(K k){
        int i = index(k);
        HashNode<K,V> curr = hashMap[i];
        HashNode<K,V> prev = null;
        while(curr!=null){
            if(curr.key.equals(k)){
                if(prev == null){
                    hashMap[i] = hashMap[i].next;
                } else {
                    prev.next = curr.next;
                }
                return curr.value;
            }
            prev = curr;
            curr = curr.next;
        }
        return null;
    }

    private int index(K k){
        return Math.abs(k.hashCode() % hashMap.length);
    }
}
