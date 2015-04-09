package serie1;

import static org.junit.Assert.*;
import static serie1.Arrays.getTheKElementsNearestX;

import org.junit.Test;

public class GetTheKElementsNearestXTest {
	
	private final static int[] singletonArray=new int[]{5};
	private final static int[] emptyArray={};
	private final static int[] array=new int[] {10,2,4,5,7,6,8,1,9,0,3};
	
	@Test
	public void getTheKElementsNearestX_onEmptyArray(){		
		assertArrayEquals(emptyArray,getTheKElementsNearestX(singletonArray,0,-1,3,10));
	}
	
	@Test
	public void getTheKElementsNearestX_onZeroK(){
		assertArrayEquals(emptyArray,getTheKElementsNearestX(array,0,10,3,0));
	}
	
	@Test
	public  void getTheKElementsNearestX_onSingletonArrayWithEquaTolK(){			
		assertArrayEquals(singletonArray,getTheKElementsNearestX(singletonArray,0,0,3,1));
	}

	@Test
	public void getTheKElementsNearestX_onSingletonArrayWithMoreThanK(){		
		assertArrayEquals(singletonArray,getTheKElementsNearestX(singletonArray,0,0,3,7));
	}

	@Test
	public void getTheKElementsNearestX_onArrayWithoutDuplicates(){
		int[] result=getTheKElementsNearestX(array,0,10,3,3);
		int[] expected=new int[]{2,3,4};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);	
	}

	@Test
	public void getTheKElementsNearestX_cacheira(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0},
				0,10,24,6);
		int[] expected=new int[]{25, 26, 27, 28, 29, 30};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira2(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0, -4, 50, -10, 70},
				0,14,26,5);
		int[] expected=new int[]{25, 26, 27, 28, 29};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira3(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0, -10, -35, 100, 50},
				0,9,5,5);
		int[] expected=new int[]{1, 2, 3, 4, 25};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira4(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0},
				0,10,4,6);
		int[] expected=new int[]{0, 1, 2, 3, 4, 25};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira5(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0},
				0,10,35,3);
		int[] expected=new int[] {28, 29, 30};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira6(){
		int[] result=getTheKElementsNearestX(
				new int[] {30, 26, 25, 3, 27, 2, 1, 4, 28, 29, 0},
				0,10,-1,3);
		int[] expected=new int[] {0, 1, 2};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

	@Test
	public void getTheKElementsNearestX_cacheira7(){
		int[] result=getTheKElementsNearestX(
				new int[] {-100, -10, -4, -1, 0, 1, 3, 4, 5, 6, 7},
				0,10,-99,2);
		int[] expected=new int[] {-100, -10};
		java.util.Arrays.sort(result);
		assertArrayEquals(expected,result);
	}

}

