package mock;

public class LongestSub {
    /**
     * find the longest sub array that has the same values
     * return the starting index and value
     * */
    public int[] findLongestSub(int[] array) {
        //stores the longest length of the subarray
        int max = 0;
        int startingIndex = 0;
        int count = 0;
        for (int i = 0; i <array.length; i++) {
            //only when there are repetitive numbers, we increment j, and update count,until we reach a different number
            // update max: only when current count is greater than the previous, we update max and startingindex


        }
        //starting index and value
        int[] result = new int[]{};
        result[0] = startingIndex;
        result[1] = array[startingIndex];
        return result;
    }

    public static void main(String[] args) {
        //                                               s
        int[] array = new int[]{6, 9, 111, 23, 5, 92, 1, 2, 2, 2, 3, 3, 3, 3, 3};
        //                                               i
        //                                                     j
        //starting index : s        count: 3
        LongestSub l = new LongestSub();
        int[] result = l.findLongestSub(array);
        System.out.println("Starting index: " + result[0] + " value: " + result[1]);
    }
}
