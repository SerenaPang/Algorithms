package string;
import java.util.*;

/**
 * Given a list of words, find k 个 the most frequent word in the list
 * return a list of most frequent words
 */
public class FindTopKFrequentWord {

    public static List<String> findTopWords(List<String> words, int k) {
        List<String> result = new ArrayList<String>();
        //put all the words and its count to the map
        Map<String, Integer> allWords = new HashMap<String, Integer>();
        for (int i = 0; i < words.size(); i++) {
            if (!allWords.containsKey(words.get(i))) {
                allWords.put(words.get(i), 1);
            } else {
                allWords.put(words.get(i), allWords.get(words.get(i)) + 1);
            }
        }
        printMap(allWords);
        //compare and insert the frequent word we want
        PriorityQueue<Map.Entry<String, Integer>> minHeap =
                new PriorityQueue<>(k,
                        new Comparator<Map.Entry<String, Integer>>() {
                            @Override
                            public int compare(Map.Entry<String, Integer> word1, Map.Entry<String, Integer> word2) {
                                return word1.getValue().compareTo(word2.getValue());
                            }
                        });
        for (Map.Entry<String, Integer> oneKeyValuePair : allWords.entrySet()) {
            // System.out.println("Offering: " + oneKeyValuePair.getKey());
            if (minHeap.size() < k) {
                minHeap.offer(oneKeyValuePair);
            } else if (oneKeyValuePair.getValue() > minHeap.peek().getValue()) {
                minHeap.offer(oneKeyValuePair);
                minHeap.poll();//always pull out the smallest one in the heap
            }
        }
        printHeap(minHeap);
        return result;
    }

    public static Map<String, Integer> toHashMap(List<String> words) {
        Map<String, Integer> allWords = new HashMap<String, Integer>();
        for (int i = 0; i < words.size(); i++) {
            if (!allWords.containsKey(words.get(i))) {
                allWords.put(words.get(i), 1);
            } else {
                allWords.put(words.get(i), allWords.get(words.get(i)) + 1);
            }
        }
        //printMap(allWords);
        return allWords;
    }

    public static void printMap(Map<String, Integer> allWords) {
        System.out.println("Print Map:");
        System.out.println(allWords.entrySet());
    }

    public static void printHeap(PriorityQueue<Map.Entry<String, Integer>> myHeap){
        System.out.println("Print Heap: " + " Heap size: " + myHeap.size());
        PriorityQueue<Map.Entry<String, Integer>> copy = myHeap;
        while (!copy.isEmpty()) {
            System.out.println(copy.peek());
            copy.poll();
        }
    }

    public static void main(String[] args) {
        List<String> words = new ArrayList<>();
        words.add("apple");
        words.add("apple");
        words.add("apple");
        words.add("eye");
        words.add("good night");
        words.add("hello");
        words.add("good night");
        words.add("bye");
        words.add("high");
        words.add("banana");
        words.add("banana");
        words.add("hope");
        words.add("sleep");
        words.add("life");
        toHashMap(words);

        int k = 4;

        findTopWords(words, k);
    }
}
