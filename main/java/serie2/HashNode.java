package serie2;

public class HashNode<K,V> {
	
	public K key;
	public V value;
	public HashNode<K,V> next;

	public HashNode(){
		key = null;
		value = null;
	}

	public HashNode(K k, V v){
		key = k;
		value = v;
	}

	@Override
	public String toString() {
		return key.toString()+" : "+value.toString();
	}
}
