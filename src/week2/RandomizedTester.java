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
	
	//Test foreach loop
	@Test
	public void testLoop(){
		for(Integer i : longList){
			System.out.println(i);
//			for(Integer j : longList){
//				
//			}
			
		}
	}
	
	@Test
	public void testSample(){
		emptyList = new RandomizedQueue<Integer>();
		emptyList.enqueue(45);
		emptyList.enqueue(90);
		emptyList.enqueue(299);
		Iterator<Integer> test = emptyList.iterator();
		int counter = 0;
		while(test.hasNext()){
			counter++;
			emptyList.dequeue();
			test.next();
		}
		System.out.println(counter);
		System.out.println(emptyList.sample());
		System.out.println(emptyList.size());
//		System.out.println(emptyList.sample());
	}
	

}
