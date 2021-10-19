package sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortNumberTest {

    @Test
    public void test_nonRepeatedElements() {
        int[] array = new int[]{5,3,8,7,9,6,1};

        BucketSortNumber bucketSort = new BucketSortNumber();
        bucketSort.sort(array);

        int[] expected = new int[]{1,3,5,6,7,8,9};
        assertArrayEquals(expected, array);
    }

    @Test
    public void test_repeatedElements() {
        int[] array = new int[]{5,5,3,8,7,9,6,1,1};

        BucketSortNumber bucketSort = new BucketSortNumber();
        bucketSort.sort(array);

        int[] expected = new int[]{1,1,3,5,5,6,7,8,9};
        assertArrayEquals(expected, array);
    }

}