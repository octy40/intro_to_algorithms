package intro_to_algorithms;

import java.lang.*;

public class Percolation {
	
	private int[][] arr;
	private int arrSz;
	private int trackOpenSites;
	
	// create n-by-n grid, with all sites blocked. A site with 0 is blocked
	public Percolation(int n){
		if( n <= 0 ){ throw new IllegalArgumentException(); }
		arrSz = n;
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = 0;
			}
		}
	}
	
	// open site (row, col) if it is not open already. A site is open if it has a value of 1.
	public void open(int row, int col){
		if(row < 1 || row > arrSz || col < 1 || col > arrSz){ throw new IndexOutOfBoundsException(); }
		arr[row][col] = 1;
		trackOpenSites++;
	}
	
	public boolean isOpen(int row, int col){
		if(row < 1 || row > arrSz || col < 1 || col > arrSz){ throw new IndexOutOfBoundsException(); }
		if(arr[row][col] == 1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	// is site (row, col) full? A site is full if it has a value of 2.
	public boolean isFull(int row, int col){
		if(row < 1 || row > arrSz || col < 1 || col > arrSz){ throw new IndexOutOfBoundsException(); }
		if(arr[row][col] == 2){
			return true;
		}
		else{
			return false;
		}
	}
	
	// number of open sites
	public int numberOfOpenSites(){
		return 1;
	}
	
	// does the system percolate?
	public boolean percolates(){
		return true;
	}
	
	//Generate random number between 1 and n
	public int generateRandNumber(){
		return (int)(Math.random() * arrSz + 1);
	}
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub

	}

}
