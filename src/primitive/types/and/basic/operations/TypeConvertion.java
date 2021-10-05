package primitive.types.and.basic.operations;

public class TypeConvertion {
	public static void main(String[] args) {
		//cast an integer to a double(explicit conversion)
		int x = 1;
		double y = (double)x;
		//x: 1 y: 1.0
		System.out.println("x: " + x + " y: " + y);
		
		//cast a double to an integer(take the integer that's close to 0)
		double a = 1.9;
		int b = (int)a;
		//a: 1.9 b: 1
		System.out.println("a: " + a + " b: " + b);
		
		//convert a double to an integer without explicit casting
		double c = 1.9;
		//int d = c;//error message or warning
		//System.out.println("c: " + c + " d: " + d);
		
		//convert an integer to double without casting
		int e = 1;
		double h = e;
		System.out.println("e: " + e + " h: " + h);
		//which is fine because it's from lower precision to higher precision
	}
	
}
