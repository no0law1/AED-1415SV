package serie2;

import static org.junit.Assert.*;
import static serie2.ListUtils.getKBiggest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;

import org.junit.Test;

public class GetKBiggestTest {
	
	ArrayList<Integer> aList = new ArrayList<Integer>(
		    Arrays.asList(2, 4, 6, 8, 10, 12, 14, 18, 20));

	static final Comparator<Integer> CMP_NATURAL_ORDER= new Comparator<Integer>() {
		public int compare(Integer i1, Integer i2) {
			return i1.compareTo(i2);
		}
	};	
	
	@Test
	public void  getKBiggest_emptyList_kSmallerThanOne(){
		Node<Integer> list = ListUtilTest.emptyListWithoutSentinel();	
		assertEquals(null, getKBiggest(list, 0, CMP_NATURAL_ORDER));
		assertEquals(null, getKBiggest(list, -1, CMP_NATURAL_ORDER));
	}
	
	@Test
	public void  getKBiggest_emptyList_kGreaterThanListLength(){
		Node<Integer> list = ListUtilTest.emptyListWithoutSentinel();	
		assertEquals(null, getKBiggest(list, 9, CMP_NATURAL_ORDER));
	}
	
	@Test
	public void  getKBiggest_emptyList_kSmallerThanListLength(){
		Node<Integer> list = ListUtilTest.emptyListWithoutSentinel();	
		assertEquals(null, getKBiggest(list, 3, CMP_NATURAL_ORDER));
	}
	
	@Test
	public void getKBiggest_kSmallerThanOne(){
		Node<Integer> list = ListUtilTest.getListWithoutSentinel(aList);
		assertEquals(null, getKBiggest(list, 0, CMP_NATURAL_ORDER));
		assertEquals(null, getKBiggest(list, -1, CMP_NATURAL_ORDER));
	}
	
	@Test
	public void getKBiggest_kEqualsListLength(){
		Node<Integer> list = ListUtilTest.getListWithoutSentinel(aList);
		assertEquals(new Integer(2), getKBiggest(list, 9, CMP_NATURAL_ORDER));
	}

	@Test
	public void getKBiggest_kGreaterThanListLength(){
		Node<Integer> list = ListUtilTest.getListWithoutSentinel(aList);
		assertEquals(null, getKBiggest(list, 10, CMP_NATURAL_ORDER));
	}
	
	@Test
	public void getKBiggest_kSmaller_ThanListLength(){
		Node<Integer> list = ListUtilTest.getListWithoutSentinel(aList);
		assertEquals(new Integer(14), getKBiggest(list, 3, CMP_NATURAL_ORDER));
	}	
}


