package serie2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */
public class Iterables {

    public static Iterable<Integer>getValuesBetween(Iterable<Integer> src, int l, int r){
        return () -> new Iterator<Integer>() {
            private Integer curr = null;
            private Iterator<Integer> iterator = src.iterator();

            @Override
            public boolean hasNext() {
                if(curr!=null){
                    return true;
                }
                while(iterator.hasNext()){
                    Integer aux = iterator.next();
                    if(aux>=l && aux<=r){
                        curr = aux;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public Integer next() {
                if(hasNext()) {
                    Integer aux = curr;
                    curr = null;
                    return aux;
                }
                throw new NoSuchElementException("getValuesBetween:Iterator - no such element");
            }

            @Override
            public void remove(){
                throw new UnsupportedOperationException("getValuesBetween:Iterator - remove not supported");
            }
        };
    }

    public static<K,V> Iterable<K> getKeys(HashNode<K,V>[] hashMap){
        return () -> new Iterator<K>() {
            K curr = null;
            int i = 0;

            @Override
            public boolean hasNext() {
                if(curr != null){
                    return true;
                }
                while (i < hashMap.length) {
                    if(hashMap[i] == null){
                        i++;
                    } else {
                        curr = hashMap[i].key;
                        hashMap[i] = hashMap[i].next;
                        return true;
                    }
                }
                return false;
            }

            @Override
            public K next() {
                if(hasNext()){
                    K aux = curr;
                    curr = null;
                    return aux;
                }
                throw new NoSuchElementException("getValuesBetween:Iterator - no such element");
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("getValuesBetween:Iterator - remove not supported");
            }
        };
    }
}
