package serie2;

import static org.junit.Assert.*;
import static serie2.Iterables.getKeys;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;

import org.junit.Test;

public class GetKeysTest {
	
	ArrayList<Integer> mapKeys = new ArrayList<Integer>(
		Arrays.asList(2101, 2002, 2103, 2104, 2205, 2106, 2407, 2408, 2409, 2410, 2311, 2212));
	
	ArrayList<String> mapValues = new ArrayList<String>(
		Arrays.asList("Aquario", "Peixes", "Carneiro", "Touro", "Gemeos", "Caranguejo", 
				"Leao", "Virgem", "Balanca", "Escorpiao", "Sagitario", "Capricornio"));	
	
	@Test
	public void  getKeys_emptyTable(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.emptyHashMap(10);
		assertTrue(HashMapUtilTest.isEmptyHashMap(hashMap));
		Iterator<Integer> it = getKeys(hashMap).iterator();
		ArrayList<Integer> listAux = new ArrayList<Integer>();
		while (it.hasNext()) listAux.add(it.next());
		assertTrue(listAux.isEmpty());
	}
	
	@Test
	public void  getKeys_fullTableWithCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 10);
		Iterator<Integer> it = getKeys(hashMap).iterator();
		ArrayList<Integer> listAux = new ArrayList<Integer>();	
		while (it.hasNext()) listAux.add(it.next());
		assertTrue(mapKeys.containsAll(listAux));
		assertTrue(listAux.containsAll(mapKeys));
	}
	
	@Test
	public void  getKeys_notFulltableWithCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 30);
		Iterator<Integer> it = getKeys(hashMap).iterator();
		ArrayList<Integer> listAux = new ArrayList<Integer>();	
		while (it.hasNext()) listAux.add(it.next());
		assertTrue(mapKeys.containsAll(listAux));
		assertTrue(listAux.containsAll(mapKeys));
	}
	
	@Test
	public void  getKeys_notFulltableWithNoCollisions(){
		HashNode<Integer,String>[] hashMap = HashMapUtilTest.getHashMap(mapKeys, mapValues, 20);
		Iterator<Integer> it = getKeys(hashMap).iterator();
		ArrayList<Integer> listAux = new ArrayList<Integer>();	
		while (it.hasNext()) listAux.add(it.next());
		assertTrue(mapKeys.containsAll(listAux));
		assertTrue(listAux.containsAll(mapKeys));
	}
}


