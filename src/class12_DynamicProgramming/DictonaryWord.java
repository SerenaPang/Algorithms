package class12_DynamicProgramming;

import java.util.HashSet;
import java.util.Set;

/**
 字典里有单词
 给一个input，这个词无论怎么切切几刀都可以找出一个对应的词在字典里找到，找到了一个对应的切法就return true
 从小的开始切，
 能不能切成功，切一刀就查字典里有没有这个词，记录下来
 比如 字典里的词有：bob cat rob
 输入的字符串为： bobcatrob

 m[1]切一刀b，不在字典里，记下来false
 m[2]bo，情况有：注意只要是case中一个true就可以返回true
 case1: 不切：bo，不在字典里，false
     case2：切：b｜o  这个b见过，表里说它不在字典里，o没见过，不在字典里，记在表里false
     注意必须2边b和o都在字典里才能return true
     m[3] bob 不切：在字典里，表里写true
     切：
 b 见过
 bo 见过
 ob 不在字典里，false

 linear scan：长度在变大
 回头看：看前面所有可以切出来的情况

 */

public class DictonaryWord {
    public boolean canBreak(String input, String[] dict) {
        Set<String> dictSet = toSet(dict);
        /**
         * bob -> b|ob {b|o|b, b|ob}
         * */
        boolean[] canBreak = new boolean[input.length() + 1];
        canBreak[0] = true;
        for (int i = 1; i < canBreak.length; i++) {
            for (int j = 0; j < i; j++) { //cut all the letters before i
                //
                if (dictSet.contains(input.substring(j, i)) && canBreak[j]) {
                    canBreak[i] = true;
                    break;
                }
            }
        }
        return canBreak[canBreak.length - 1];
    }

    public Set<String> toSet(String[] dict) {
        Set<String> set = new HashSet<>();
        for (String s : set) {
            set.add(s);
        }
        return set;
    }

}
