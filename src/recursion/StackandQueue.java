package recursion;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

public class StackandQueue {
	public static void main(String[] args) {
		//queue
		Queue<Integer> queue = new LinkedList<>();
		
		queue.add(1);//push
		queue.add(2);
		queue.offer(3);
		queue.offer(4);
		
		queue.poll();//pop
		
		int frontElement = queue.peek();
		int queueSize = queue.size();
		boolean isEmptyQueue = queue.isEmpty();
		
		//stack of ints -> double ended queue
		Deque<Integer> stack = new LinkedList<>();
		stack.push(1);
		stack.push(2);
		
		stack.pop();
		int topElement = stack.peek();
		int stackSize = stack.size();
		boolean isEmptyStack = stack.isEmpty();
	}

}
