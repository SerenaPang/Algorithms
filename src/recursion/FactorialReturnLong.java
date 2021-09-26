package recursion;

public class FactorialReturnLong {
	 public long factorial(int n) {
		    if(n == 1){
				      return 1;
				    }
				    long result = n * factorial(n-1); 
				    return result;
		  }
}
