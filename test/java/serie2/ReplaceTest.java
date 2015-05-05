package serie2;

import static org.junit.Assert.*;
import static serie2.Utils.replace;

import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;

public class ReplaceTest {
	
	static ArrayList<Integer> values = new ArrayList<Integer>(Arrays.asList(2, 4, 6, 8, 10, 12, 14, 18, 20));	
	static ArrayList<Integer> keys = new ArrayList<Integer>(Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8));
	static ArrayList<Integer> subKeys = new ArrayList<Integer>(Arrays.asList(0, 2, 4, 6, 8));
	static ArrayList<Integer> subValues = new ArrayList<Integer>(Arrays.asList(2, 6, 10, 14, 20)); 
	static ArrayList<Integer> newValues = new ArrayList<Integer>( Arrays.asList(21, 22, 23, 24, 25)); 
	
	
	
	@Test
	public void  replace_empty_map(){
		HashNode<Integer,Integer>[] hashMap = HashMapUtilTest.<Integer,Integer>emptyHashMap(10);	
		assertTrue(HashMapUtilTest.isEmptyHashMap(hashMap));
		replace(hashMap,null);
		assertTrue(HashMapUtilTest.isEmptyHashMap(hashMap));
		HashNode<Integer,Integer> list=HashMapUtilTest.getList(keys, values);
		replace(hashMap,list);
		assertTrue(HashMapUtilTest.isEmptyHashMap(hashMap));
		
	}
	
	@Test
	public void  replace_on_map_with_singletonLists(){
		HashNode<Integer,Integer>[] hashMap = HashMapUtilTest.getHashMap(keys, values, 9);
		replace(hashMap,null);
		for(int i=0; i<keys.size();i++) {
			assertTrue(HashMapUtilTest.containsKey(keys.get(i), hashMap));
			assertTrue(HashMapUtilTest.containsEntry(keys.get(i), values.get(i),hashMap));
		}
		HashNode<Integer,Integer> list=HashMapUtilTest.getList(subKeys, newValues);
		replace(hashMap,list);
		for(int i=0; i<subKeys.size();i++) {
			assertTrue(HashMapUtilTest.containsKey(keys.get(i), hashMap));
			assertFalse(HashMapUtilTest.containsEntry(subKeys.get(i), subValues.get(i),hashMap));
			assertTrue(HashMapUtilTest.containsEntry(subKeys.get(i), newValues.get(i),hashMap)); 
		}	
	}
	
	@Test
	public void  replace_on_map(){
		for(int dim=1;dim<15; dim++){
			HashNode<Integer,Integer>[] hashMap = HashMapUtilTest.getHashMap(keys, values, dim);
			replace(hashMap,null);
			for(int i=0; i<keys.size();i++) {
				assertTrue(HashMapUtilTest.containsKey(keys.get(i), hashMap));
				assertTrue(HashMapUtilTest.containsEntry(keys.get(i), values.get(i),hashMap));
			}		
			HashNode<Integer,Integer> list=HashMapUtilTest.getList(subKeys, newValues);
			replace(hashMap,list);
			for(int i=0; i<subKeys.size();i++) {
				assertTrue(HashMapUtilTest.containsKey(keys.get(i), hashMap));
				assertFalse(HashMapUtilTest.containsEntry(subKeys.get(i), subValues.get(i),hashMap));
				assertTrue(HashMapUtilTest.containsEntry(subKeys.get(i), newValues.get(i),hashMap)); 
			}
		}
	}

}
