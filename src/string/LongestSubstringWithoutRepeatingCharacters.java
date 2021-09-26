package string;

/**
 * 10:32 - 10:40
 * input: b c d f  b d
 * output:4 {bcdf} b repeat
 */
public class LongestSubstringWithoutRepeatingCharacters {
    public int longesrSubString(String s) {
        if (s.length() == 1) {
            return 1;
        }
        char[] array = s.toCharArray();
        int slow = 0;
        int length = 0;
        for (int fast = 1; fast < array.length; fast++) {
            if (array[slow] == array[fast]) {
                length = 1;
            }

        }

        return length;
    }
}
