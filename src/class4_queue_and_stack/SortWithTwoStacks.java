package class4_queue_and_stack;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
/**
 * Given a list of numbers, sort it with 2 stacks
 * */
public class SortWithTwoStacks {
	/**
	 * @param s1 is the linked list of integers needs to be sorted
	 * */
	public void sort(LinkedList<Integer> s1) {
		if(s1 == null || s1.size() <= 1) {
			return;
		}
		LinkedList<Integer> s2 = new LinkedList<Integer>();
		sort(s1, s2);
	}
	
	private void sort(Deque<Integer> input, Deque<Integer> buffer) {
		//iterate thru the stack to find the smallest, update globalMin for each numbers until found
		//push the smallest number to the bottom of the stack and don't remove it(count keep track of the sorted numbers)
		//repeat the steps again until all the elements are sorted
		
		
	}
	
	public static void print(List<Integer> numbers) {
		for(int i = 0; i < numbers.size(); i++) {
			System.out.print(numbers.get(i) + " ");
		}	
	}
	
	public static void printDeque(Iterator<Integer> input) {
		while(input.hasNext()) {
			System.out.print(input.next() + " ");
		}
		System.out.println();
	}
	
	public static void main(String[] args) {
		List<Integer> numbers = new LinkedList<>();
		numbers.add(4);
		numbers.add(12);
		numbers.add(1);
		numbers.add(3);		
		print(numbers);
		System.out.println(" ");
		Deque<Integer> input = new ArrayDeque<>();
		input.addAll(numbers);
		printDeque(input.iterator());	
	}
}
