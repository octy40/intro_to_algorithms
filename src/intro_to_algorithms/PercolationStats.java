package intro_to_algorithms;

import edu.princeton.cs.algs4.StdStats;
import edu.princeton.cs.algs4.StdIn;
import edu.princeton.cs.algs4.StdOut;
import edu.princeton.cs.algs4.StdRandom;

public class PercolationStats {
 
 private Percolation[] perArr;
 private int T,N;
 private double mean;
 private double stddev;
 private double[] res; //res will hold the various values of x
 
 public PercolationStats(int n, int trials){
  if( n <= 0 || trials <= 0 ){ throw new IllegalArgumentException(); }
  perArr = new Percolation[trials];
  T = trials;
  N = n;
  res = new double[trials];
  fillMeanArray();
 }
 
 public double mean(){
  mean = StdStats.mean(res);
  return mean;
 }
 
 public double stddev(){
  stddev = StdStats.stddev(res); 
  return stddev;
 }
 
 public double confidenceLo(){
  return mean - ((1.96 * stddev)/Math.sqrt(T));
 }
 
 public double confidenceHi(){
  return mean + ((1.96 * stddev)/Math.sqrt(T));
 }
 
 private void fillMeanArray(){
	 int row, col, site;	 
	 for(int i = 0; i < T; i++){
		 perArr[i] = new Percolation(N);
		 while(!perArr[i].percolates()){
			 site = generateRandNumber();
			 row = getRow(site);
			 col = getColumn(site);
			 perArr[i].open(row, col);
		 }
		 res[i] = (perArr[i].numberOfOpenSites()*1.0)/(N * N);
	 }
 } 
 
 //Generate random number between 1 and n^2
 private int generateRandNumber(){
  return StdRandom.uniform(1, N*N + 1);
 }
 
 //Get column from index
 private int getColumn(int index){
	 if( index%N == 0 ){
		 return N;
	 }
	 else{
		 return index%N;
	 }
 }
 
 //Get row from index
 private int getRow(int index){
	 if( index%N == 0 ){
		 return index/N;
	 }
	 else{
		 return index/N + 1; 
	 }
 }
  
 public static void main(String[] args) {
  // TODO Auto-generated method stub
  int n = StdIn.readInt();
  int T = StdIn.readInt();
  PercolationStats stat = new PercolationStats(n, T);
  StdOut.println("mean                    = " + stat.mean());
  StdOut.println("stddev                  = " + stat.stddev());
  StdOut.println("95% confidence interval = " + stat.confidenceLo() + ", " + stat.confidenceHi());
 }

}
