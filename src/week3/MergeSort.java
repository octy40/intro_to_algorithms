package week3;

import java.util.Arrays;

public class MergeSort {
	
	public static void sort(int[] a, int[] aux, int lo, int hi){
		if(hi <= lo){ return; }
		int mid = lo + (hi - lo) / 2;
		sort(a, aux, lo, mid);
		sort(a, aux, mid+1, hi);
		System.out.println("lo = " + lo + " hi = " + hi + " mid = " + mid);
	}
	
	public static void merge(int[] a, int[] aux, int lo, int hi){
		
	}
	
	public static void main(String[] args){
		int[] a = { 67,	79,	9, 75, 36, 95 };
		int[] aux = new int[a.length];
		sort(a, aux, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

}
