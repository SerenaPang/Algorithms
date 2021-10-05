package primitive.types.and.basic.operations;

public class CalculationTypeConvertion {

	public static void precedence2() {
		int a = 2;
		int b = 4;
		int c = 8;
		
		double result = a + (double)(b/c);
		System.out.println("result 2: " + result);
	}
	
	public static void precedence3() {
		int a = 2;
		int b = 4;
		int c = 8;
		
		double result = a +((double)b) / c;
		System.out.println("result 3: " + result);
	}
	public static void precedence1() {
		int a = 2;
		int b = 4;
		int c = 8;
		
		double result = (double)(a + b/c );
		//2 + 0.5
		//System.out.println((double)(b/c));
		//System.out.println(b/c);
		System.out.println("result 1: " + result);
	}
	
	public static void precedence4() {
		int a = 2;
		int b = 4;
		int c = 8;
		
		double result = a + 1.0 *b / c;
		System.out.println("result 4: " + result);
	}
public static void main(String[] args) {
	 precedence1();
	 precedence2();
	 precedence3();
	 precedence4();
}
}
