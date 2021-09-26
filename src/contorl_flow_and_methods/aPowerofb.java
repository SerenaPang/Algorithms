package contorl_flow_and_methods;
/**
 * calculate a power of b
 * */
public class aPowerofb {
	  public int power(int a, int b) {
		    int result = 1;
		   for(int i = 0; i < b; i++){
		      result = result *a;
		   }
		   return result;
		  }
}
