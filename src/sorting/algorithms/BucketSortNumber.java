package sorting.algorithms;

import java.util.LinkedList;

public class BucketSortNumber {
    //number range: [0 -2000]
    public void sortWithList(int[] array) {
      //  LinkedList<Integer>[] allNumsBuckets = new LinkedList[2001];
        LinkedList<Integer>[] allNumsBuckets = new LinkedList[20];
        for (int i = 0; i < allNumsBuckets.length; i++) {
            allNumsBuckets[i] = new LinkedList<>();
        }

        for (int i = 0; i < array.length; i++) {
            allNumsBuckets[array[i]].add(array[i]);
        }
/**
        //put the sorted elements to a list
        List<Integer> listOfSortedNumbers = new ArrayList<>();
        for (int i = 0; i < allNumsBuckets.length; i++) {
            if (allNumsBuckets[i].size() == 0) {
                continue;
            } else{
                for (int j = 0; j < allNumsBuckets[i].size(); j++) {
                    listOfSortedNumbers.add(allNumsBuckets[i].get(j));
                }
            }
        }
        //put the elements sorted to the original array
        for (int i = 0; i < array.length; i++) {
            array[i] = listOfSortedNumbers.get(i);
        }
 */
        int index = 0;
        for (int i = 0; i < allNumsBuckets.length; i++) {
            if (allNumsBuckets[i].size() == 0) {
                continue;
            } else {
                for (int j = 0; j < allNumsBuckets[i].size(); j++) {
                    array[index] = allNumsBuckets[i].get(j);
                    index++;
                }
            }
        }
       print(array);
    }

    public void sortWithCounter(int[] array) {
        //  LinkedList<Integer>[] allNumsBuckets = new LinkedList[2001];
       int[] allNumsBuckets = new int[20];

       //record the number of occurance of the number
        for (int i = 0; i < array.length; i++) {
                allNumsBuckets[array[i]] = allNumsBuckets[array[i]] + 1;
        }
     //   print(allNumsBuckets);

        int index = 0;
        for (int i = 0; i < allNumsBuckets.length; i++) {
            if (allNumsBuckets[i] == 0) {
                continue;
            } else {
                for (int j = 0; j < allNumsBuckets[i]; j++) {
                    array[index] = i;
                    index++;
                }
            }
        }
        print(array);
    }

    public void print(LinkedList<Integer>[] array) {
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
    }

    public void print(int[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i]);
        }
    }

    public static void main(String[] args) {
        BucketSortNumber bs = new BucketSortNumber();
       // int[] array = new int[]{5,3,8,7,9,6,1};
        int[] array = new int[]{5,5,3,8,7,9,6,1,1};
       // bs.sortWithList(array);
        bs.sortWithCounter(array);
    }
}
