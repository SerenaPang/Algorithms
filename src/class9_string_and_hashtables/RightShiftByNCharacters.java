package class9_string_and_hashtables;
/**
 * 先调转string中要shift掉的n个字母，后半部分
 * 再调转前半部分，不用shift掉的所有字母
 * 最后，调转整个string
 * */
public class RightShiftByNCharacters {
    public static String rightShift(String input, int n){
        char[] array = input.toCharArray();
        n = n % array.length;
        System.out.println("n = " + n + " left: " + (array.length - n));
        //reverse the order of last two char(the chars that are going to be shifted
        //abcd ef -> abcd fe
        reverse(array, array.length - n, array.length - 1);
        System.out.println("n = " + n + " right: " + (array.length - n - 1));
        //reverse the string from the beginning to the end except the one that's shifted
        //abcd fe -> dcba fe
        reverse(array, 0, array.length - n - 1);
        //reverse the whole string now
        //dcba fe -> efabcd
        reverse(array, 0, array.length - 1);
        return new String(array);
    }

    public static void reverse(char[] array, int left, int right){
        while (left < right) {
            char temp = array[right];
            array[right] = array[left];
            array[left] = temp;
            left++;
            right--;
        }
    }
    public static void main(String[] args) {
        String s = "abcdef";
        System.out.println(s + "   ->length:"+ s.length());
        int n = 2;
        System.out.println(rightShift(s,n));
    }
}
