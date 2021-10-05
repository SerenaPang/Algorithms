package condition.loops;

public class Iteration {
	public static void normalForLoop() {
		for(int i = 0; i < 10; i+=1) {
			System.out.print(i + " ");
		}	
	}
	
	public static void normalForLoop2() {
		for(int i = 0; i < 10; i++) {
			System.out.print(i + " ");
		}
	}
	
	public static void forLoop() {
		for(int i = 0; i < 10; i+=3) {
			System.out.print(i + " ");
		}
		//System.out.println("At last i is: " + i);
		//这句话打印不出来因为i的declaration是在for loop的scope里的
	}
	
	public static void forLoop2() {
		int i;
		for(i = 0 ; i < 10; i+=3){
			System.out.print(i + " ");
		}
		System.out.println("The last i is: " + i);
	}
	
	public static void printArray() {
		int[] arr = {2,3,5};
		for(int i : arr) {
			System.out.println(i);
		}
	}
	
	public static void normalWhile() {
		int i = 0;
		while(i < 10) {
			System.out.print(i + " ");
			i += 3;
		}
		System.out.println("The last i is: " + i);
	}
	
	
	public static void main(String[] args) {
		normalForLoop();
		System.out.println();
		
		normalForLoop2();
		System.out.println();
		
		forLoop();
		System.out.println();
		
		forLoop2();
		System.out.println();
		printArray();
		
		normalWhile();
		System.out.println();
		
	}
	
	
}
