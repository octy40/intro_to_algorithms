package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class Deque<Item> implements Iterable<Item> {
 
 private class StackNode<Item>{
  Item data;
  StackNode<Item> next;
  StackNode<Item> previous;
  
  public StackNode(Item item){
   this.data = item;
   this.next = null;
   this.previous = null;
  }
 }
 
 private class ListIterator implements Iterator<Item>{
  
  private StackNode<Item> current = head.previous;

  @Override
  public boolean hasNext() {
   if(current == tail){
    return false;
   }
   return current != null;
  }

  @Override
  public Item next() {
   Item item = current.data;
   current = current.previous;
   return item;
  }
  
  @Override
  public void remove(){
  
  }
  
 }
 
 private int size;
 private StackNode<Item> head;
 private StackNode<Item> tail;
 
 public Deque(){
  size = 0;
  head = new StackNode<Item>(null);
  tail = new StackNode<Item>(null);
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
 
 public void addFirst(Item item){
  if(item == null){ throw new NullPointerException("Can't add null item!"); }
  StackNode<Item> temp = head.previous;
  StackNode<Item> newItem = new StackNode<Item>(item);
  temp.next = newItem;
  newItem.next = head;
  newItem.previous = temp;
  head.previous = newItem;
  size++;
 }
 
 public void addLast(Item item){
  if(item == null){ throw new NullPointerException("Can't add null item!"); }
  StackNode<Item> temp = tail.next;
  StackNode<Item> newItem = new StackNode<Item>(item);
  temp.previous = newItem;
  newItem.next = temp;
  newItem.previous = tail;
  tail.next = newItem;
  size++;
 }
 
 public Item removeFirst(){
  if(size == 0){ throw new NoSuchElementException("Can't remove from an empty list!"); }
  Item returnVal = head.previous.data;
  head.previous = head.previous.previous;
  head.previous.next = head;  
  size--;
  return returnVal;
 }
 
 public Item removeLast(){
  if(size == 0){ throw new NoSuchElementException("Can't remove from an empty list!"); }
  Item returnVal = tail.next.data;
  tail.next = tail.next.next;
  tail.next.previous = tail;
  size--;
  return returnVal;
 }
 
  public Iterator<Item> iterator() {  
   return new ListIterator();  
 } 
}
