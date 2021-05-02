package basic6_recursion;

public class Power {
	public static int nodes = 0;
	//a to the power of b
	//a^b 3^4 = 81
	//method 2
	public static long power(int a, int b) {
		if(b == 0) {
			return 1;
		}
		return a * power(a, b - 1);
	}
	//method 3
	public static long power1(int a, int n) {
		
		nodes++;
		
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return a;
		}
		
		if(n % 2 == 1) {
			return power1(a, n / 2) * power1(a, n / 2) * a;
		}else {
			return power1(a, n / 2) * power1(a, n / 2);
		}
	}
	
	//method 3 simplified
	public long power2(int a, int n) {
		if(n == 0) {
			return 1;
		}else if(n == 1) {
			return a;
		}
		
		long half = power2(a, n / 2);
		if(n % 2 == 1) {
			return half * half * a;
		}else {
			return half * half;
		}
	}
	
	
	public static void main(String[] args) {
		long result = power(2, 3);
		System.out.println("result: " + result);
		System.out.println("nodes: " + nodes);
	}
}
