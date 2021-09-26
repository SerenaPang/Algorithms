package string;
/**
 * Reverse a given string.
 * Assumptions
 * The given string is not null.
 * */
public class ReverseString {
    public static String reverseStr(String str){
        char[] array = str.toCharArray();
        int left = 0;
        int right = str.length() - 1;
        while (left < right) {
            swap(array, left, right);
            left++;
            right--;
        }
        return new String(array);
        //note: here we are not returning from 0 to right, because right has reduce to the middle of the string
    }

    public static void swap(char[] array, int x, int y){
        char temp = array[x];
        array[x] = array[y];
        array[y] = temp;
    }
    public static void main(String[] args) {
        String s = "I love yahoo";
        String result = reverseStr(s);
        System.out.println(result);
    }
}
