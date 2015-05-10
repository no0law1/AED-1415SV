package serie2;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 *
 */
public class Iterables {

    public static Iterable<Integer> getValuesBetween(Iterable<Integer> src, int l, int r){
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
            private HashNode<K,V> curr = null;

            private int currPos = 0;

            @Override
            public boolean hasNext() {
                if(curr != null){
                    return true;
                }

                if(currPos < hashMap.length-1){
                    currPos+=1;
                    return true;
                }

                return false;
            }

            @Override
            public K next() {
                return null;
            }

            @Override
            public void remove() {
                throw new UnsupportedOperationException("getKeys:Iterator - remove not supported");
            }
        };
    }
}
