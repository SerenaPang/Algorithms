package mock;

import java.util.*;

public class TopK {
    /**
     * find the maximum frequent word appears in the array
     * */
    public Word findTopOne(String[] array) {
        //key: string value: frequency
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else{
                int count = map.get(array[i]);
                map.put(array[i],count + 1);
            }
        }
        //iterate map
        Word word = null;
        int max = Integer.MIN_VALUE;
        String maxFrequentWord = null;
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            int curValue = entry.getValue();
            if (curValue >= max) {
                max = curValue;
                maxFrequentWord = entry.getKey();
                word = new Word(max, maxFrequentWord);
            }
        }
        return word;
    }

    /**
     *  find top k frequent words in the array
     * */
    public Word[] findTopK(String[] array, int k) {
        Word[] result = new Word[k];
        //key: string value: frequency
        HashMap<String, Integer> map = new HashMap<>();
        for (int i = 0; i < array.length; i++) {
            if (!map.containsKey(array[i])) {
                map.put(array[i], 1);
            } else {
                int count = map.get(array[i]);
                map.put(array[i], count + 1);
            }
        }
        ArrayList<Word> words = new ArrayList<>();
        Iterator<Map.Entry<String, Integer>> iterator = map.entrySet().iterator();
        Word word = null;
        while (iterator.hasNext()) {
            Map.Entry<String, Integer> entry = iterator.next();
            String curKey = entry.getKey();
            int curValue = entry.getValue();
            word = new Word(curValue, curKey);
            words.add(word);
        }


      //  PriorityQueue<Word> minHeap = new PriorityQueue<Word>(k, new WordComparator());
        return result;
    }




    public static void main(String[] args) {
        String[] array = new String[]{"a","a", "b", "b", "b","c","c","c","c","c","c"};
        int k = 2;
        TopK t = new TopK();
       // Word result = t.findTopOne(array);
       // System.out.println("word: " + result.getWord() + " frequency: " + result.getFrequency());


    }
}
