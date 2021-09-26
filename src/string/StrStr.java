package string;
/**
 * Determine if a small string is a substring of another large string.
 * Return the index of the first occurrence of the small string in the large string.
 * Return -1 if the small string is not a substring of the large string.
 * Assumptions
 * Both large and small are not null
 * If small is empty string, return 0
 * Examples
 * “ab” is a substring of “bcabc”, return 2
 * “bcd” is not a substring of “bcabc”, return -1
 * "" is substring of "abc", return 0
 * */
/**
 解法1:
 一个定长的sliding window， 长度为small的长度，这个window 用i往后滑
 j在窗子里看里面的每个char是否和smallmatch
 检查是否和这small一样
 j出界了就证明找到了， 结果返回i

 解法2:
 robin karp
 每次滑一个window把它hash成一个值， 然后比这个window的值是否和target一样
 但如果出现重复的数值（不同的char）就需要一个一个查
 */
public class StrStr {
    public static int findSubStr(String longStr, String smallStr){
        int longLen = longStr.length();
        int smallLen = smallStr.length();
        //bcabc
        //  ab
        for (int i = 0; i <= longLen - smallLen; i++) {
            int j = 0;
            while (j < smallLen && longStr.charAt(i + j) == smallStr.charAt(j)) {
                j++;
            }
            if (smallLen == j) {
                return i;
            }
        }
       return 0;
    }

    public static void main(String[] args) {
        String longStr = "bcabc";
        String smallStr = "ab";
        System.out.println(findSubStr(longStr, smallStr));
    }
}
