package a_contorl_flow_and_methods;
/**
 * 求n的阶乘. Assumption, n > 1.
Example:
n = 3, return 6
n = 4, return 24
n = 5, return 120
 * */

public class FactorialCalculator {
	//recursive solution
	  public static int factorial(int n) {
		    if(n == 1){
		      return 1;
		    }
		    int result = n * factorial(n-1); 
		    return result;
		  }
	  
	  //iterative solution
	  public static int factorialIterative(int n) {
		  int result = 1;
		  if(n == 1) {
			  return 1;
		  }
		  //4: 1 2 3 4
		  for(int i = 1; i <= n; i++) {
			  result = result * i;
		  }  
		  return result;
	  }
	  
	  public static void main(String[] args) {
		  int n = 4;
		  int recursiveResult = factorial(n);
		  int iterativeResult = FactorialCalculator.factorialIterative(n);
		  System.out.println("Recursive: " + recursiveResult);
		  System.out.println("Iterative: " + iterativeResult);
	}
}
