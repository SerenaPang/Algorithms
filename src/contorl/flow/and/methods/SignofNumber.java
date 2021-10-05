package contorl.flow.and.methods;
/**
 * Return 1 if the input integer is positive, -1 if the input integer is negative, 0 if the input integer is zero.
 * */
public class SignofNumber {
	  public int sign(int x) {
		    // Write your solution here
		    if(x > 0){
		      return 1;
		    }else if(x < 0){
		      return -1;
		    }else{
		      return 0;
		    }
		  }
}
