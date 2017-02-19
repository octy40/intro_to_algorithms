package week3;

import java.util.Arrays;

public class BottomUpMergeSort {
	
	public static void merge(int[] a, int[] aux, int incrementer){
		for(int k = 0; k < a.length; k += incrementer ){
			for(int i = k, j = incrementer; i < incrementer; i++, j++){
				if(a[i] > a[j]){
					aux[i] = a[j];
					aux[j] = a[i];
				}
			}
		}
	}
	
	public static void main(String[] args){
		int[] a = { 97, 67,	79,	9, 75, 36, 95 };
		int[] aux = new int[a.length];
		for(int i = 0; i < a.length; i++){ //copy a into aux
			aux[i] = a[i];
		}
		
		merge(a, aux, 1);
		merge(a, aux, 3);
		System.out.println(Arrays.toString(aux));
	}

}
