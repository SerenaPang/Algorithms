package primitive_types_and_basic_operations;
/**
 * Given two integer a and b, calculate a divide by b but maintain the precision.
 * */
public class Division {
	
		public static double divide() {
			int a = 3;
			int b = 7;
			
			double a1 = (double)a;
			double b1 = (double)b;
			double c = a1/b1;//Complete the expression
			
			return c;
		}
		

		public static double divide2(){
			int a  = 3;
			int b = 7;
			double c = (double)a /(double)b;
			return c;
		}
		public static double divide3() {
			int a = 3;
			int b = 7;
			double c = 1.0 * a/b;
			return c;
		}

		public static void main(String[] args) {
			double result1 = divide();
			double result2 = divide2();
			double result3 = divide3();
			System.out.println("result1: " + result1);
			System.out.println("result2: " + result2);
			System.out.println("result3: " + result3);
		}
	
}
