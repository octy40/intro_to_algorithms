package week2;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    
    

    public static void insertIntoSorted(int[] ar) {
        // Fill up this function  
        int e = ar[ar.length - 1];
        if(ar.length == 1){
            printArray(ar);
        }
        else{
            for(int i = ar.length - 1; i > 0; i--){
                if(e < ar[i-1]){
                    int temp = ar[i-1];
                    ar[i] = temp;
                    printArray(ar);
                }
                else{
//                    ar[i+1] = e;
                	System.out.println("last");
                    printArray(ar);
                    break;
                }
            }            
        }        
    }
    
    
/* Tail starts here */
     public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int s = in.nextInt();
        int[] ar = new int[s];
         for(int i=0;i<s;i++){
            ar[i]=in.nextInt(); 
         }
         insertIntoSorted(ar);
    }
    
    
    private static void printArray(int[] ar) {
      for(int n: ar){
         System.out.print(n+" ");
      }
        System.out.println("");
   }
    
    
}