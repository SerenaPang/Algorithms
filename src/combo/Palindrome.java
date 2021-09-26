package combo;

/**
 * 10:50 - 11:00
 * input: string: "ababbbabbababa"
 * requirement: partition section must be palindrome
 * output: minimum cuts so that every section of the string is a palindrome
 * if the input itself is a palindrome, just return 0 because itself need 0 cuts
 * <p>
 * ababbbabbababa
 * memo[1]: (a|babbbabbababa)
 * (a|b|abbbabbababa)
 * (a|ba|bbbabbababa)
 * (a|bab|bbabbababa)
 * ... ...
 * <p>
 * memo[2]: (ab|abbbabbababa)
 * memo[3]: (aba|bbbabbababa)
 * memo[4]: (abab|bbabbababa)
 * memo[5]: (ababb|babbababa)
 * memo[6]: (ababbb|abbababa)
 * memo[7]: (ababbba|bbababa)
 * memo[8]: (ababbbab|bababa)
 * memo[9]: (ababbbabb|ababa)
 * memo[10]: (ababbbabba|baba)
 * memo[11]: (ababbbabbab|aba)
 * memo[12]: (ababbbabbaba|ba)
 * memo[13]: (ababbbabbabab|a)
 */
public class Palindrome {

}
