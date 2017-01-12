package week2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class DequeTester {
	Deque<Integer> shortList;
	Deque<Integer> emptyList;
	Deque<Integer> longList;
	
	@Before
	public void setUp() throws Exception {
		//Setup shortList
		shortList = new Deque<Integer>();
		shortList.addFirst(1);
		shortList.addFirst(2);
		
		//setup emptyList
		emptyList = new Deque<Integer>();
		
		//setup LongList
		longList = new Deque<Integer>();
		for(int i = 0; i < 10; i++){
			longList.addLast(i);
		}
	}
	
	//Test iteration
	@Test
	public void testIterator(){
		int j = 0, i = 0;
		Iterator<Integer> test = longList.iterator();
		while(test.hasNext()){
			i = test.next();
			assertEquals("testIterator: check if loop works", j, i);
			j++;			
		}
	}
	
	//Test removing first item
	@Test
	public void testAddRemoveFirst(){
		shortList.addFirst(9);
		int a = shortList.removeFirst();
		assertEquals("removeFirst: check if a is correct ", 9, a);
	}
	
	//Test removing last item
	@Test
	public void testAddRemoveLast(){
		shortList.addLast(9);
		int a = shortList.removeLast();
		assertEquals("removeFirst: check if a is correct ", 9, a);
	}
	
	//Test adding to an empty list
	@Test
	public void testAddToEmptyList(){
		emptyList.addFirst(9);
		int a = emptyList.removeFirst();
		assertEquals("testAddToEmptyList: check if a is correct ", 9, a);
	}
	
	//Test addlast by adding null value
	@Test
	public void testAddNull(){
		try {
			emptyList.addLast(null);
			fail("Can't add a null value");
		}
		catch (NullPointerException e){
			
		}
		
		try {
			emptyList.addFirst(null);
			fail("Can't add a null value");
		}
		catch (NullPointerException e){
			
		}
	}
	
	//Test removing from an empty list
	@Test
	public void testRemovingEmptyList(){
		try{
			emptyList.removeFirst();
			fail("Can't remove from an empty list");
		}
		catch (UnsupportedOperationException e){
			
		}
		
		try{
			emptyList.removeLast();
			fail("Can't remove from an empty list");
		}
		catch (UnsupportedOperationException e){
			
		}
		
	}

	//Test isEmpty
	@Test
	public void testIsEmpty(){
		boolean test = emptyList.isEmpty();
		boolean test1 = shortList.isEmpty();
		assertEquals("testIsEmpty: check if emptyList is empty!", true, test);
		assertEquals("testIsEmpty: check if shortList is empty!", false, test1);
	}
	
	//Test size
	@Test
	public void testSize(){
		int a = emptyList.size();
		int a1 = shortList.size();
		assertEquals("testSize: check if emptyList has correct size!", 0, a);
		assertEquals("testIsEmpty: check if shortList has correct size!", 2, a1);
	}
}
