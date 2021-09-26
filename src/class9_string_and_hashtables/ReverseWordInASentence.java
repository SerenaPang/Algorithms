package class9_string_and_hashtables;
/**
 先把全部的词reverse整体/整个句子的顺序，再针对每个词reverse字母顺序（用2个pointers）
 这两步反过来做也可以
 */
public class ReverseWordInASentence {
    public static String reverseWords(String input){
        char[] array = input.toCharArray();
        //reverse the whole string
        reverseString(array, 0, array.length - 1);
        //reverse each words in the string
        int start = 0;
        for (int i = 0; i < array.length; i++) {
            //find the starting point of the word
            //note here we have to check if the char is space or not
            //because we don't want to reverse the space
            if (array[i] != ' ' && (i == 0 || array[i - 1] == ' ')) {
                start = i; //record the beginning position of the word
            }
            //find the end point of the word
            if (array[i] != ' ' && (i == array.length - 1 || array[i + 1] == ' ')){
                reverseString(array, start, i);//i walked forward and to the ending position of the word
            }
        }
        return new String(array);
    }

    public static void reverseString(char[] input, int left, int right){
        while (left < right) {
            char temp = input[right];
            input[right] = input[left];
            input[left] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        String s = "I love yahoo";
        System.out.println(s);
        System.out.println(reverseWords(s));
    }
}
