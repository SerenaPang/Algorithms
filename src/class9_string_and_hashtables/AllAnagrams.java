package class9_string_and_hashtables;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/**
 * 9:47 - 9:57
 * input: aabc
 * output: aacb = bcaa = acba
 */
public class AllAnagrams {

    public List<String> findAllAnagrams(String s) {
        List<String> result = new ArrayList<>();
        Set<Character> mySet = toSet(s);

        return result;
    }

    public Set<Character> toSet(String s) {
        Set<Character> mySet = new HashSet<>();
        for (int i = 0; i < s.length(); i++) {
            mySet.add(s.charAt(i));
        }
        return mySet;
    }
}
