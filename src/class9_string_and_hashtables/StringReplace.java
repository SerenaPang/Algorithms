package class9_string_and_hashtables;
//TODO Finish the implementation
/**
 把一个string里有的pattern1 转换成另一个pattern2

 如果要替换的p1和p2长度不一样怎么办？
 s走replace target的长度，因为s keep所有要留下来的letter（stu。。t）
 f要走pattern的长度，因为我们要忽略原来的pattern（den）
 当pattern比replace target的词长（要替换的词比较短）：比如 student ， pattern是den， replace target是xx， student-> stuxxt 3->2
 先找到所有有pattern1出现的位置，都找到之后开始replace
 用两个指针，同向而行
 f是正在processing的letter，slow左边都是处理过的letter（要留下来的letter）

 当pattern比replace target的词短（要替换的词比较长）：空格变成%20
 input：pizza near me
 output：pizza%20near%20me
 先找到有多少个空格要被replace，再算要扩容多少个位置
 扩容多少？ %20的长度：3  空格的长度：1  用替换pattern的长度减掉原来match pattern的长度，再乘以occurrence的个数
 从尾巴开始scan因为腾出来的位置都在尾部，从前面scan的话letter会被吃掉，从后面copy这样要保留的letter就不会被吃掉，但要注意patter就要从后往前的copy，先copy%再0再2
 不用替换的全copy ，

 f出界就表示没有更多字母可以process了

 如果pattern有多个ocuurance怎么办？
 f又找到了pattern match上，又把replace target copy到词上去

 url encoding：有空格要变成%20
 */
public class StringReplace {
    public static String replaceSmaller(String s, String pattern, String target){
        char[] array = s.toCharArray();
        int slow = 0;
        //Student
        //f
        for (int fast = 0; fast < array.length; fast++) {
            int satarting_position = StrStr.findSubStr(s, pattern);
        }
        return new String(array, 0, slow);
    }

    public static void main(String[] args) {
        String small = "Student";
        String smallMultiple = "Studentdent";
        String smallPatternMatch = "den";
        String SmallTarget = "xx";

        String longer = "pizza near me";
        String longerPatternMatch = " ";
        String longerTarget ="%20";
    }
}
