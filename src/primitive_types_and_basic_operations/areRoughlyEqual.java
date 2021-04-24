package primitive_types_and_basic_operations;
/**
 * Check if the given number x and y are roughly equal, the allowed error is lower than 0.0001.
 * */
public class areRoughlyEqual {
	  public boolean areEqual(double x, double y) {
		    boolean b = false;//complete the expression
		    double precision = 0.0001;
		    double difference = Math.abs(x-y);
		    if(difference < precision){
		      b = true;
		    }
		    return b;
		    // Write your solution here
		  }
}
