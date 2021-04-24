package arraylist;

import java.util.ArrayList;
import java.util.List;

/**
 * Problem: Give an array list of integer, calculate the sum of squares of all its elements.
Note: return 0 if the list is null or empty.

Example:
list = {1,2,3} → returns 14 (14=1*1+2*2+3*3)
 * 
 * */
public class SumofSqaure{
	public static int sumOfSqaure(List<Integer> list) {
		if(list == null) {
			return 0;
		}
		int sum = 0;
		for(int i = 0; i < list.size();i++) {
			sum = sum + list.get(i) * list.get(i);
		}
		return sum;
	}
	
	public static void main(String[] args) {
		List<Integer> mylist = new ArrayList<Integer>();
		mylist.add(1);
		mylist.add(2);
		mylist.add(3);
		mylist.add(4);
		mylist.add(5);
		mylist.add(6);
		mylist.add(7);
		mylist.add(8);
		mylist.add(9);
		mylist.add(10);
		
		for(int i : mylist) {
			System.out.println(i*i);
		}
		
		int result =sumOfSqaure(mylist);
		
		System.out.println("result: " + result );
	}

}
