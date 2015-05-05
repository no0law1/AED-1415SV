package serie2;
import static org.junit.Assert.assertEquals;
import static serie2.Iterables.getValuesBetween;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

public class GetValuesBetweenTest extends IterablesTest {
	static final Iterable<Integer> SE = Collections.<Integer>emptyList();
	static final List<Integer> S1= unmodifiable( Arrays.asList( 3, 5, 7, 10, 12 ) );
	static final int FIRST_VALUE_OF_S1 = S1.get(0);
	static final int LAST_VALUE_OF_S1 = S1.get(S1.size()-1);
	

	protected static void testValuesBetween( List<Integer> source,  int min, int max ) {
		List<Integer> expected = source.subList(source.indexOf(min), source.lastIndexOf(max)+1);
		test(expected, getValuesBetween( source, min, max ));
		test(expected, getValuesBetween( source, min-1, max ));
		test(expected, getValuesBetween( source, min, max+1 ));
		test(expected, getValuesBetween( source, min-1, max+1));

	}
	
	@Test 
	public void getValuesBetween_withEmptySequences(){
		assertIterableEmpty( getValuesBetween( SE,  0, 3 ) );	
	}

	@Test 
	public void getValuesBetween_withOneElementSequence(){
		List<Integer> s = Collections.singletonList( 3 );
		assertIterableEmpty( getValuesBetween( s,  0, 2) );
		assertIterableEmpty( getValuesBetween( s,  4, 10) );	
		testValuesBetween(s,  s.get(0), s.get(0));
	}
	
	@Test 
	public void getValuesBetween_allGreaterInSequences(){
		assertIterableEmpty( getValuesBetween( S1,  FIRST_VALUE_OF_S1-2, FIRST_VALUE_OF_S1-1 ) );	
	}

	@Test 
	public void getValuesBetween_allLessInSequences(){
		assertIterableEmpty( getValuesBetween( S1, LAST_VALUE_OF_S1+1, LAST_VALUE_OF_S1+2 ) );	
	}


	@Test 
	public void getValuesBetween__allSequence(){
		testValuesBetween(S1,  FIRST_VALUE_OF_S1, LAST_VALUE_OF_S1 );	
	}

	@Test 
	public void getValuesBetween__onlyFirstOfSequences(){
		testValuesBetween(S1,FIRST_VALUE_OF_S1, FIRST_VALUE_OF_S1 );	
	}
	
	@Test 
	public void getValuesBetween__inBeginOfSequences(){
		testValuesBetween( S1,  FIRST_VALUE_OF_S1, S1.get(S1.size()-3) );	
	}

	@Test 
	public void getValuesBetween_exceptLastElement(){
		testValuesBetween( S1,  FIRST_VALUE_OF_S1, S1.get(S1.size()-2) );	
	}


	@Test 
	public void getValuesBetween__onlyLastOfSequences(){
		testValuesBetween(S1,  LAST_VALUE_OF_S1, LAST_VALUE_OF_S1 );	
	}
	

	@Test 
	public void getValuesBetween__inEndOfSequences(){
		testValuesBetween( S1,S1.get(2), LAST_VALUE_OF_S1 );	
	}

	@Test 
	public void getValuesBetween_exceptFirstElement(){
		testValuesBetween( S1,  S1.get(1), LAST_VALUE_OF_S1 );	
	}

	@Test 
	public void getValuesBetween_exceptFirstAndLastElement(){
		testValuesBetween( S1, S1.get(1), S1.get(S1.size()-2) );	
	}
	
	@Test(expected=NoSuchElementException.class)
	public void getValuesBetween_nextInEmptySequence() {
		getValuesBetween(SE, 0, 0).iterator().next();
	}	
	
	@Rule
	public ExpectedException exception = ExpectedException.none();
	
	@Test 
	public void getValuesBetween_NextWithNoElements(){
		Iterator<Integer> it=  getValuesBetween(S1,  LAST_VALUE_OF_S1, LAST_VALUE_OF_S1).iterator();	
		assertEquals(LAST_VALUE_OF_S1, it.next().intValue());
		exception.expect(NoSuchElementException.class);
		exception.expectMessage("getValuesBetween:Iterator - no such element");
		it.next();
	}

	@Test 
	public void getValuesBetween_RemoveElements(){
		Iterator<Integer> it=  getValuesBetween(S1, LAST_VALUE_OF_S1, LAST_VALUE_OF_S1).iterator();	
		it.next();
		exception.expect(UnsupportedOperationException.class);
		exception.expectMessage("getValuesBetween:Iterator - remove not supported");
		it.remove();
	}
}
