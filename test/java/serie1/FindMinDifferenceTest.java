package serie1;

import org.junit.Test;

import static serie1.Arrays.findMinDifference;
import static org.junit.Assert.*;

public class FindMinDifferenceTest {
	
	@Test
	public void findMinDifference_OnBothEmptyArrays(){
		int[] v1 = new int[0];
		int[] v2 = new int[0];
		int diff = findMinDifference(v1, v2);
		assertEquals(-1, diff);	
	}
	
	@Test
	public void findMinDifference_OnAnArraysWithOneElementAndEmpty(){
		int[] v1 = new int[]{1};
		int[] v2 = new int[0];
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(-1, diff);	
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(-1, diff);	
	}
	
	@Test
	public void findMinDifference_OnAnArraysWithOneElement(){
		int[] v1 = new int[]{-1};
		int[] v2 = new int[]{-1};
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(0, diff);	
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(0, diff);	
	}
	
	@Test
	public void findMinDifference_OnAnArraysWithRandomElements(){
		int[] v1 = new int[]{-23, -10, 34, 68};
		int[] v2 = new int[]{-15, -12, 32, 33};
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(1, diff);	
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(1, diff);	
	}
	
	@Test
	public void findMinDifference_OnAnArraysWithRandomNegativeElements(){
		int[] v1 = new int[]{-99,-81,-70,-68,-45,-27,-3};
		int[] v2 = new int[]{-84, -35,-25,-16,-9};
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(2, diff);	
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(2, diff);	
	}
	
	@Test
	public void findMinDifference_OnAnArraysWithRandomPositiveElements(){
		int[] v1 = new int[]{3,27,45,68,70,81,99};
		int[] v2 = new int[]{9,16,25,35,75,84};
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(2, diff);	
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(2, diff);	
	}

	@Test
	public void findMinDifference_OnAnArraysWithRandomPositiveElementsAndDifferentLengths(){
		int[] v1 = {1, 3, 5 ,7, 9, 18};
		int[] v2 = {2, 4, 6 ,8, 10, 12, 14, 18};
		int diff = Arrays.findMinDifference(v1, v2);
		assertEquals(0, diff);
		diff = Arrays.findMinDifference(v2, v1);
		assertEquals(0, diff);
	}

}
