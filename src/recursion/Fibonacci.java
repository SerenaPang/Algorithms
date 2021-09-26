package recursion;
/**
 * 0 1 2 3 4 5 6 7  8
 * 0 1 1 2 3 5 8 13 21
 * */
public class Fibonacci {
	public long fibo(int n) {
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		return fibo(n - 1) + fibo(n - 2);
	}
	
	public static long fib(int n) {
		if(n < 0) {
			return -1;
		}
		if(n == 0) {
			return 0;
		}
		if(n == 1) {
			return 1;
		}
		long a = 0;
		long b = 1;
		for(int i = 0; i < n - 1; i++) {
			long tmp = a + b;
			a = b;
			b = tmp;
		}
		return b;
	}
}
