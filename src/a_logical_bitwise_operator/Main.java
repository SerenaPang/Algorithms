package a_logical_bitwise_operator;

public class Main {
	public static boolean f() {
		System.out.print("F");
		return true;
	}
	
	public static boolean g() {
		System.out.print("G");
		return false;
	}
	
	public static void main(String[] args) {
		/**
		 * 已经运行过f并返回true了，由于｜｜决定了结果，所以不用看g了
		 * */
		if(f() || g()) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		
		/**
		 * 已经运行过g并返回false了，由于&&决定了结果肯定是false，所以不用看f了
		 * */
		if(g() && f()) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		
		/**
		 * 会打印g和f因为bitwise operator用在true false上没有short circuit
		 * */
		if(g() & f()) {
			System.out.println("1");
		}else {
			System.out.println("2");
		}
		
	}
}
