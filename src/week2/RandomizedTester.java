package week2;

import static org.junit.Assert.*;

import java.util.Iterator;

import org.junit.Before;
import org.junit.Test;

public class RandomizedTester {
	RandomizedQueue<Integer> shortList;
	RandomizedQueue<Integer> longList;
	RandomizedQueue<Integer> emptyList;
	
	@Before
	public void setUp() throws Exception {
		//Setup shortList
		shortList = new RandomizedQueue<Integer>();
		shortList.enqueue(1);
		shortList.enqueue(2);
		
		//setup emptyList
		
		
		//setup LongList
		longList = new RandomizedQueue<Integer>();
		for(int i = 0; i < 10; i++){
			longList.enqueue(i);
		}	
	}
	
	//Test dequeue
	@Test
	public void testDequeue(){
		longList.dequeue();		
	}
	
	//Test enqueue
	@Test
	public void testEnqueue(){
		emptyList = new RandomizedQueue<Integer>();
		for(int i = 0; i < 10; i++){
			emptyList.enqueue(i);
		}		
	}
	
	//Test sample

}
