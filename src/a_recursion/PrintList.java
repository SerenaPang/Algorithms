package a_recursion;

import java.util.ArrayList;
import java.util.List;

/**
 * Print the elements in the list using recursions and an iterative approach.
 *
 */
public class PrintList {

	public static <T> void printListIterative(List<T> list) {
		for (T element : list) {
			System.out.print(element + " ");
		}

		System.out.println();
	}

	public static <T> void printListRecursive1(List<T> list) {
		List<T> copy = new ArrayList<T>(list);

		if (copy.isEmpty()) {
			System.out.println();
			return;
		}

		System.out.print(copy.get(0) + " ");
		copy.remove(0);
		printListRecursive1(copy);
	}

	public static <T> void printListRecursive2(List<T> list) {
		int index = 0;
		printListRecursive2(list, index);
	}
	
	public static <T> void printListRecursive2(List<T> list, int index) {
		if (list.size() == index) {
			return;
		}
		
		System.out.print(list.get(index) + " ");
		index++;
		printListRecursive2(list, index);
	}
	

	public static void main(String[] args) {
		List<String> cities = new ArrayList<>();
		cities.add("San Francisco");
		cities.add("Barcelona");
		cities.add("Mexico City");
		cities.add("Shanhai");

		printListIterative(cities);

		printListRecursive1(cities);
		
		printListRecursive2(cities);
	}

}
