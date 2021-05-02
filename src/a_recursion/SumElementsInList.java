package a_recursion;

import java.util.ArrayList;
import java.util.List;

public class SumElementsInList {

	public static long sumIterative(List<Integer> list) {
		long sum = 0;
		for(int i = 0; i < list.size();i++) {
			sum = sum + list.get(i);
		//	System.out.println(list.get(i));
		}
		return sum;
	}
	
	private static long sumRecursive(List<Integer> numbers) {
		int index = 0;
		return sumRecursiveHelper(numbers,index);
	}
	
	private static long sumRecursiveHelper(List<Integer> numbers, int index) {
		int sum = 0;
		if(numbers.size() == index) {
			return 0;
		}
		System.out.println(numbers.get(index));
		
		sum = numbers.get(index);
		index++;
		return sum + sumRecursiveHelper(numbers, index);
	}

	public static void main(String[] args) {
		List<Integer> numbers = new ArrayList<>();
		numbers.add(1);
		numbers.add(2);
		numbers.add(3);
		numbers.add(4);
		numbers.add(5);

		long sum1 = sumIterative(numbers);
		//long sum2 = sumRecursive(numbers);
		long sum2 = sumRecursive(numbers);
		System.out.println("Iterative: " + sum1);
		System.out.println("Recursive: " + sum2);
	}
}
