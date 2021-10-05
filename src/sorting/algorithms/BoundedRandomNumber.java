package sorting.algorithms;

import java.util.Random;

/**
 * returns a random number within the range of [a, b]
 * note the random.nextInt returns the number range from 0 to (n -1)
 * so in order to return number range from 0 to n, we have to pass 
 * in 0 to n + 1
 * */
public class BoundedRandomNumber {
	static Random randomGenerater = new Random();
	public static void ranGenerator(int a, int b) {
		System.out.println("Generat 10 numbers in the range from "+ a +" to " + b + " randomly: ");
		for(int i = 0; i < 10; i++) {
			int num = a + randomGenerater.nextInt(b - a + 1);
			//        1 + (6 - 1 + 1) = 1 + 6 = 7
			//		  2 + (6 - 2 + 1) = 2 + 5 = 7
			//		  3 + (6 - 3 + 1) = 3 + 4 = 7
			System.out.print(num + " ");
		}
	}
	
	public static void generator(int x, int y) {
		System.out.println("Generat 10 numbers in the range from "+ x +" to " + y + " randomly: ");
		for(int i = 0; i < 10; i++) {
			int num = x + randomGenerater.nextInt(y - x + 1);
			System.out.print(num + " ");
		}
	}
	
	public static void main(String[] args) {
		int a = 1;
		int b = 6;
		ranGenerator(a, b);
		System.out.println();
		System.out.println();
		int x = 4;
		int y = 7;
		generator(x, y);
	}
}
