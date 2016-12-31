package intro_to_algorithms;

import edu.princeton.cs.algs4.WeightedQuickUnionUF;
import edu.princeton.cs.algs4.StdRandom;

public class Percolation {
	
	private int[][] arr;
	private int N;
	private int doubleN;
	private WeightedQuickUnionUF UF; 
	private int trackOpenSites;
	
	// create n-by-n grid, with all sites blocked. A site with 0 is blocked
	public Percolation(int n){
		if( n <= 0 ){ throw new IllegalArgumentException(); }
		N = n;
		doubleN = n * n;
		UF = new WeightedQuickUnionUF((n * n) + 2);
		trackOpenSites = 0;
		arr = new int[n][n];
		for(int i = 0; i < n; i++){
			for(int j = 0; j < n; j++){
				arr[i][j] = -1;
			}
		}
	}
	
	// open site (row, col) if it is not open already. A site is open if it has a value other than -1.
	public void open(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N){ throw new IndexOutOfBoundsException(); }
		if( arr[row][col] == -1 ){
			arr[row][col] = getIndex(row, col);
			trackOpenSites++;
		}		
	}
	
	public boolean isOpen(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N){ throw new IndexOutOfBoundsException(); }
		if(arr[row][col] != -1){
			return true;
		}
		else{
			return false;
		}
	}
	
	
	// is site (row, col) full? A site is full if it is connected to the top virtual root
	public boolean isFull(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N){ throw new IndexOutOfBoundsException(); }
		return UF.connected(getIndex(row, col), doubleN);
	}
	
	// number of open sites
	public int numberOfOpenSites(){
		return trackOpenSites;
	}
	
	// does the system percolate?
	public boolean percolates(){
		return UF.connected(doubleN, (doubleN+1));
	}
	
	//Generate random number between 1 and n
	private int generateRandNumber(){
		return StdRandom.uniform(doubleN);
	}
	
	//Generate index from row and column
	private int getIndex(int row, int col){
		if(row < 0 || row >= N || col < 0 || col >= N){ throw new IndexOutOfBoundsException(); }
		return ((row * N) + col );
	}
	
	//Get column from index
	private int getColumn(int index){
		return index%N;
	}
	
	//Get row from index
	private int getRow(int index){
		return index/N;
	}
	
	//Check east
	private void isEastOpen(int row, int col){
		//Let's check boundaries, it will just return false if it's beyond boundary
		if((col+1) >= N){ return; }
		//To check east we increment the column
		if(isOpen( row, (col+1))){
			int p = getIndex(row, col);
			int q = getIndex(row, col+1);
			UF.union(p, q);
		}
	}
	
	//Check West
	private void isWestOpen(int row, int col){
		//Let's check boundaries
		if((col-1) < 0){ return; }
		if(isOpen(row, (col-1))){
			int p = getIndex(row, col);
			int q = getIndex(row, col-1);
			UF.union(p, q);
		}
	}
	
	//Check North
	private void isNorthOpen(int row, int col){
		//Let's check boundaries
		if((row-1) < 0){ return; }
		if(isOpen((row-1), col)){
			int p = getIndex(row, col);
			int q = getIndex(row-1, col);
			UF.union(p, q);
		}
	}
	
	//Check South
	private void isSouthOpen(int row, int col){
		//Let's check boundaries, it will just return false if it's beyond boundary
		if((row+1) >= N){ return; }
		//To check east we increment the column
		if(isOpen( (row+1), col)){
			int p = getIndex(row, col);
			int q = getIndex(row+1, col);
			UF.union(p, q);
		}
	}
	
	private void isTop(int row, int col){
		if( row == 0 ){
			UF.union(getIndex(row, col), doubleN);
		}
	}
	
	private void isBottom(int row, int col){
		if( row == (N-1) ){
			UF.union(getIndex(row, col), doubleN+1);
		}
	}
	
	//Let's fill our grid till it percolates
	public void fillGrid(){
		int row, col, site;
		while(!percolates()){
			site = generateRandNumber();
			row = getRow(site);
			col = getColumn(site);
			open(row, col);
			isEastOpen(row, col);
			isWestOpen(row, col);
			isNorthOpen(row, col);
			isSouthOpen(row, col);
			isTop(row, col);
			isBottom(row, col);			
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Percolation test = new Percolation(20);
		test.fillGrid();
		System.out.println(test.percolates());
		System.out.println(test.numberOfOpenSites());
	}

}
