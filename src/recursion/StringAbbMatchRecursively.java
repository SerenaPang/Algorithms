package recursion;

/**
 * TC: O(n)
 * SC: O(n)
 * <p>
 * base case: when to stop?
 * - when string index reach to the end and pattern index reach to the end at the same time
 * <p>
 * when do we return false?
 * - if the pattern is letter, check if it matches with string characters
 * [if not match, return false]
 * <p>
 * -if it's number, read the number until it reaches to a letter(and move the pattern index)
 * calculate the digit form, and then move the string index count steps(count represents how many
 * characters it represents)
 * [if read pattern is done but string is not done, or read string is done but pattern is not doen
 * that means it does not match]
 * <p>
 * what do we need to do in each recursive call?
 * -check if the current character match with the pattern char
 * -or check if the number count matches with the string
 * <p>
 * what's the problem size a little smaller than the original problem?
 * <p>
 * -the string that's one character less than the original string,
 * -or the string that's count steps less than the original string
 */
public class StringAbbMatchRecursively {
    public boolean isMatch(String string, String pattern) {
        int si = 0;
        int pi = 0;
        return match(string, pattern, si, pi);
    }

    public boolean match(String str, String pat, int si, int pi) {
        if (pat.length() == pi && str.length() == si) {
            return true;
        }

        if (si >= str.length() || pi >= pat.length()) {
            return false;
        }

        if (pat.charAt(pi) < '0' && pat.charAt(pi) > '9') {
            if (str.charAt(si) != pat.charAt(pi)) {
                return false;
            } else {
                return match(str, pat, si++, pi++);
            }
        }

        int count = 0;
        while (pi < pat.length() && pat.charAt(pi) >= '0' && pat.charAt(pi) <= '9') {
            char cur = pat.charAt(pi);
            int num = cur - '0';
            count = count * 10 + num;
            pi++;
        }
        si = si + count;
        return match(str, pat, si, pi);
    }

    /**
     * when checking the characters, we don't have to have the condition if pi
     * is out of bound
     * <p>
     * when checking the numbers we have to pay attention to the bound becasue
     * we have to read until it reaches to end or a letter
     * <p>
     * whenever we call the next recursive funciton, we have to return since we need to make sure in
     * every round of the recursive function, it returns true when it checks if it matches
     */

    public static void main(String[] args) {

    }

}
