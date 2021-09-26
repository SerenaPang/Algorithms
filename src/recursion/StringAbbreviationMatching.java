package recursion;

/**
 * check if the pattern matches the input string
 * <p>
 * base case: when it's going to stop?
 * -when we reaches to the end of the input string and pattern
 * <p>
 * what do we need to do in each recursive call?
 * - for the input string,
 * - for the pattern :
 * <p>
 * 1. if the pattern is a number, not a character, then read the number until
 * it reaches to the point where there is a character or the end of the pattern.
 * how to increment the index when encounter digits?
 * -first of all, read all the numbers and take the whole number string
 * -second, convert this string into actual number
 * how to convert string to number format?
 * -
 * <p>
 * <p>
 * 2. if the pattern character is a letter, then check if it matches with the input string character
 * ,and then increment the both index to read the next character
 */
public class StringAbbreviationMatching {
    public static boolean match(String input, String pattern) {
        int sindex = 0;
        int pindex = 0;
        while (sindex < input.length() && pindex < pattern.length()) {
            //which means if the letter in pattern are characters
            if (pattern.charAt(pindex) < '0' || pattern.charAt(pindex) > '9') {
                if (input.charAt(sindex) != pattern.charAt(pindex)) {
                    return false;
                }
                sindex++;
                pindex++;
            } else {//if the letters in pattern are numbers
                int count = 0;
                while (pindex < pattern.length() && pattern.charAt(pindex) >= '0' && pattern.charAt(pindex) <= '9') {
                    count = count * 10 + (pattern.charAt(pindex) - '0');
                    pindex++;
                }
                sindex = sindex + count; //move forward count steps to match the number
            }

        }
        //at the end if both length matches, it means string and pattern is matched
        return sindex == input.length() && pindex == pattern.length();

    }

    public static void matchResult(String s, String p) {
        if (match(s, p)) {
            System.out.println(s + " matches with " + p);
        } else {
            System.out.println(s + " does not matches with " + p);
        }
    }

    public static void main(String[] args) {
        String s = "book";
        String pat = "book";
        String pat1 = "4";
        String pat2 = "b3";
        String pat3 = "b2k";

        // matchResult(s, pat);
        matchResult(s, pat1);
    }

}
