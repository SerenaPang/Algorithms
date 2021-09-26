package string;

import java.util.ArrayDeque;
import java.util.Deque;

public class RemoveDuplicateRepeat {
    /**
     * remove all adjacent, repeat characters repeatedly
     * a b b b b a z w
     */
    public static String removeDup(String s) {
        //corner case: if string is null or there is no duplicate
        if (s == null || s.length() <= 1) {
            return s;
        }
        char[] array = s.toCharArray();
        Deque<Character> myStack = new ArrayDeque<Character>();
        int fast = 0;
        while (fast < array.length) {
            char currentChar = array[fast];
            System.out.println("Current char: " + array[fast] + "  Stack top: " + myStack.peek());
            if (!myStack.isEmpty() && currentChar == myStack.peek()) {
                while (fast < array.length && array[fast] == currentChar) {
                    fast++;//increment until we found the element not the same as the top
                }
                myStack.pollFirst();
            } else {//stack is empty or top char and current char are not the same
                myStack.offerFirst(currentChar);
                fast++;
            }
        }
        //now rearrange the chars to array
        int len = myStack.size();
        for (int i = len - 1; i >= 0; i--) {
            array[i] = myStack.pollFirst();
        }
        System.out.println();
        printStack(myStack);
        return new String(array, 0, len);
    }

    public static void printStack(Deque<Character> stack) {
        System.out.println("Printing stack: ");
        ArrayDeque<Character> copy = (ArrayDeque<Character>) stack;
        while (!copy.isEmpty()) {
            System.out.print(copy.peek() + " ");
            copy.pollFirst();
        }
    }

    public static void print(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + " ");
        }
        System.out.println();
    }

    public static void main(String[] args) {
        String s = "abbbbazw";
        System.out.println("Original String " + "length: " + s.length());
        System.out.println(s);
        String result = removeDup(s);
        System.out.println("Result: ");
        System.out.println(result);
    }
}
