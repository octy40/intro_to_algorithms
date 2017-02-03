package week2;

import java.util.Iterator;
import java.util.NoSuchElementException;

import edu.princeton.cs.algs4.StdRandom;

public class RandomizedQueue<Item> implements Iterable<Item> {
 
 private class Node<Item>{
  Item data;
  Node<Item> next;
  Node<Item> previous;
  
  public Node(Item item){
   this.data = item;
   this.next = null;
   this.previous = null;
  }
 }
 
 private class ListIterator implements Iterator<Item>{
  
  private Node<Item> current = head.previous;

  @Override
  public boolean hasNext() {
   return current.previous != null;
  }

  @Override
  public Item next() {
      if(!hasNext()){
          throw new NoSuchElementException("no more element");
      }
      
      Item item = current.data;
      current = current.previous;
      return item;
  }
  
    
  @Override
  public void remove(){
      throw new UnsupportedOperationException("Can't call remove()");
  }
  
 }
 
 private int size;
 private Node<Item> head;
 private Node<Item> tail;
 
 public RandomizedQueue(){
  size = 0;
  head = new Node<Item>(null);
  tail = new Node<Item>(null);
  tail.next = head;
  head.previous = tail;
 }
 
 public boolean isEmpty(){
  return size == 0;
 }
 
 public int size(){
  return size;
 }
 
 public void enqueue(Item item){
  if(item == null){ throw new NullPointerException("Can't add null item!"); }
  Node<Item> temp = tail.next;
  Node<Item> newItem = new Node<Item>(item);
  temp.previous = newItem;
  newItem.next = temp;
  newItem.previous = tail;
  tail.next = newItem;
  size++;
 }
 
 public Item dequeue(){
  if(size == 0){ throw new NoSuchElementException("Can't remove from an empty list!"); }
  int index = StdRandom.uniform(0, size);
  Item returnVal = remove(index);   
  size--;
  return returnVal;
 }
 
 public Item sample(){
  if(size == 0){ throw new NoSuchElementException("Can't sample from an empty list!"); }
  Iterator<Item> loop = iterator();
  int index = StdRandom.uniform(0, size);
  Item returnVal = null;
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
 
 private Item remove(int index){
  Iterator<Item> loop = iterator();
  int i = 0;
  Item returnVal = null;
  Node<Item> temp = head.previous;
  Node<Item> temp2;
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
 public Iterator<Item> iterator() {
  return new ListIterator();
 }
 
 public static void main(String[] args){
     RandomizedQueue<Integer> list = new RandomizedQueue<Integer>();
     list.enqueue(90);
     list.enqueue(10);
     list.sample();
     System.out.println(list.sample());
 }
 
}
