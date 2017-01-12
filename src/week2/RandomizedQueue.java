package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<E> implements Iterable<E> {
	
	private class Node<E>{
		E data;
		Node<E> next;
		Node<E> previous;
		
		public Node(E item){
			this.data = item;
			this.next = null;
			this.previous = null;
		}
	}
	
	private class ListIterator implements Iterator<E>{
		
		private Node<E> current = head;

		@Override
		public boolean hasNext() {
			return current != null;
		}

		@Override
		public E next() {
			E item = current.data;
			current = current.previous;
			return item;
		}
		
	}
	
	private int size;
	private Node<E> head;
	private Node<E> tail;
	
	public RandomizedQueue(){
		size = 0;
		head = new Node<E>(null);
		tail = new Node<E>(null);
		tail.next = head;
		head.previous = tail;
	}
	
	public boolean isEmpty(){
		return size == 0;
	}
	
	public int size(){
		return size;
	}
	
	public void enqueue(E item){
		if(item == null){ throw new NullPointerException("Can't add null item!"); }
		Node<E> temp = tail.next;
		Node<E> newItem = new Node<E>(item);
		temp.previous = newItem;
		newItem.next = temp;
		newItem.previous = tail;
		tail.next = newItem;
		size++;
	}
	
	public E dequeue(){
		if(size == 0){ throw new NoSuchElementException("Can't remove from an empty list!"); }
		int index = StdRandom.uniform(0, size);
		E returnVal = remove(index);			
		size--;
		return returnVal;
	}
	
	public E sample(){
		if(size == 0){ throw new NoSuchElementException("Can't sample from an empty list!"); }
		Iterator<E> loop = iterator();
		int index = StdRandom.uniform(0, size);
		E returnVal = null;
		int i = 0;
		while(loop.hasNext()){
			if(i == index){
				returnVal = loop.next();
				break;
			}
			loop.next();
			i++;
		}		
		return returnVal;
	}
	
	private E remove(int index){
		Iterator<E> loop = iterator();
		int i = 0;
		E returnVal = null;
		Node<E> temp = head.previous;
		Node<E> temp2;
		while(loop.hasNext()){
			if(i == index){
				returnVal = temp.data;
				temp2 = temp.next;
				temp = temp.previous;
				temp.next = temp2;
				temp2.previous = temp;
				break;
			}
			temp = temp.previous;
			i++;
		}		
		return returnVal;
	}

	@Override
	public Iterator<E> iterator() {
		return new ListIterator();
	}

}
