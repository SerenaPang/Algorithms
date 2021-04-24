package contorl_flow_and_methods;
/**
 * Determine whether an integer n is a prime number. Assumption: n is >= 2.
 * */
public class isPrime {
	 public boolean isPrime(int n) {
		    for(int i = 2; i < n; i++){
		      if(n % i == 0){
		        return false;
		      }
		    }   
		    return true;
		  }
}
