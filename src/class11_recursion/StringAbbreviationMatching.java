package class11_recursion;

public class StringAbbreviationMatching {
        /**
         base case：text和pattern都为0
         case1: 比较pattern的首字母， 不一样直接ruturn false，一样就往后找
         case2:如果是数字就要计算pattern的number是否一样
         */
        public boolean match(String input, String pattern) {
            return match(input, pattern, 0, 0);
        }

        /**
         s is the input string
         pattern is the pattern we are checking if it match with the input string
         si is the pointer keep track of character in input string
         ti keep track of the character position in pattern string
         */
        private boolean match(String s, String pattern, int si, int ti){
            //base case: 当两个string同时都到结尾了，表示没有更多字母可以check了，且match
            if (si == s.length() && ti == pattern.length()) {
                return true;
            }
            //反例：如果s和pattern的其中一个没字母了，说明没有match上
            if (si >= s.length() || ti >= pattern.length()) {
                return false;
            }
            //如果current character不是数字，是个字母，那就比较字母
            if (pattern.charAt(ti) < '0' || pattern.charAt(ti) > '9') {
                if(s.charAt(si) == pattern.charAt(ti)) { //如果字母一样，接着查下一个character是否match
                    return match(s, pattern, si + 1, ti + 1);
                }
                return false;
            }
            //如果current character不是数字，是个数字，那就要算出数字是多少
            int count = 0;
            while (ti < pattern.length() && pattern.charAt(ti) >= '0' && pattern.charAt(ti) <= '9') {
                count = count * 10 + (pattern.charAt(ti) - '0');
                ti++;
            }
            return match(s, pattern, si + count, ti); //si+count是因为如果有12个字母直接加12个index以保持match
        }
    }

