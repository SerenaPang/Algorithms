package condition.loops;

public class ControlFlow {	
	public static void condition() {
		int x = 11;
		if(x > 0) {
			System.out.println("x > 0");//只会print这一行因为条件满足了
		}else if(x > 5) {
			System.out.println("x > 5");
		}else if(x>10) {
			System.out.println("x > 10");
		}else {
			System.out.println("others");
		}		
	}
	
	public static void notSmartCompiler(int x) {
		if(x > 0) {
			System.out.println(x + " > 0 ");
		}
		if(x < 0) {
			System.out.println(x + " < 0");
		}
		// what if when x = 0 ?
		//it will print the wrong answer
	}
	
	public static void fixNotSmartCompiler(int x) {
		if(x > 0) {
			System.out.println(x + " > 0 ");
		}else if(x < 0) {
			System.out.println(x + " < 0 ");
		}else {
			System.out.println("x = 0");
		}
	}
	
	public static void fixNotSmartCompiler2(int x) {
		if(x > 0) {
			System.out.println(x + " > 0 ");
		}else if(x < 0) {
			System.out.println(x + " < 0 ");
		}
			System.out.println("x = 0");
	}
	
	public static void main(String[] args) {
		condition();
		int x = 0;
		notSmartCompiler(x);
		fixNotSmartCompiler(x);
		fixNotSmartCompiler2(x);
	}

}
