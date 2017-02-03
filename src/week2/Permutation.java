package week2;

import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdIn;

public class Permutation {
  
 public static void main(String[] args){
     int k = StdIn.readInt();
     RandomizedQueue<String> queue = new RandomizedQueue<String>();
     while(StdIn.hasNextChar()){
         queue.enqueue(StdIn.readString());
     }
     for(int i = 0; i < k; i++){
         StdOut.print(queue.dequeue());
     }
 }
}
