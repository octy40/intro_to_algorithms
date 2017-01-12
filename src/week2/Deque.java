package week2;

import java.util.Iterator;

public class Deque<E> implements Iterable<E> {
	
	private class StackNode<E>{
		E data;
		StackNode<E> next;
		StackNode<E> previous;
		
		public StackNode(E item){
			this.data = item;
			this.next = null;
			this.previous = null;
		}
	}
	
	private class ListIterator implements Iterator<E>{
		
		private StackNode<E> current = head.previous;

		@Override
		public boolean hasNext() {
			if(current == tail){
				return false;
			}
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
	private StackNode<E> head;
	private StackNode<E> tail;
	
	public Deque(){
		size = 0;
		head = new StackNode<E>(null);
		tail = new StackNode<E>(null);
		tail.next = head;
		head.previous = tail;
	}

	public boolean isEmpty(){
		if( size == 0 ){
			return true;
		}
		else{
			return false;
		}
	}
	
	public int size(){
		return size;
	}
	
	public void addFirst(E item){
		if(item == null){ throw new NullPointerException("Can't add null item!"); }
		StackNode<E> temp = head.previous;
		StackNode<E> newItem = new StackNode<E>(item);
		temp.next = newItem;
		newItem.next = head;
		newItem.previous = temp;
		head.previous = newItem;
		size++;
	}
	
	public void addLast(E item){
		if(item == null){ throw new NullPointerException("Can't add null item!"); }
		StackNode<E> temp = tail.next;
		StackNode<E> newItem = new StackNode<E>(item);
		temp.previous = newItem;
		newItem.next = temp;
		newItem.previous = tail;
		tail.next = newItem;
		size++;
	}
	
	public E removeFirst(){
		if(size == 0){ throw new UnsupportedOperationException("Can't remove from an empty list!"); }
		E returnVal = head.previous.data;
		head.previous = head.previous.previous;
		head.previous.next = head;		
		size--;
		return returnVal;
	}
	
	public E removeLast(){
		if(size == 0){ throw new UnsupportedOperationException("Can't remove from an empty list!"); }
		E returnVal = tail.next.data;
		tail.next = tail.next.next;
		tail.next.previous = tail;
		size--;
		return returnVal;
	}
	
	 public Iterator<E> iterator() {		
		 return new ListIterator();		
	}	
}
