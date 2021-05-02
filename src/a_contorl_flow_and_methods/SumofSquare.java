package a_contorl_flow_and_methods;

public class SumofSquare {
	public static int sumOfSquares(int n) { //0 - 10 : 
	    int sum = 0;
	    System.out.println("n: " + n);
	    for(int i = 1; i*i <= n; i++){
	    	System.out.println("i: " + i);
	    	sum = sum + i*i;    
	      }
	    return sum;
	 } 
	  
	
	public static void main(String[] args) {
		//sumOfSquares(3);
		//sumOfSquares(4);
		sumOfSquares(20);
	}
}
