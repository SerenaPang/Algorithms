package sorting.algorithms;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class BucketSortPersonTest {

    @Test
    public void test_nonRepeatedElements() {
        Person[] people = new Person[] {
                new Person("a", 5),
                new Person("b", 3),
                new Person("c", 8),
                new Person("d", 7),
                new Person("e", 9),
                new Person("f", 6),
                new Person("g", 1),
        };

        BucketSortPerson sort = new BucketSortPerson();
        sort.sortByAge(people);

        Person[] expectedResult = new Person[] {
                new Person("g", 1),
                new Person("b", 3),
                new Person("a", 5),
                new Person("f", 6),
                new Person("d", 7),
                new Person("c", 8),
                new Person("e", 9),
        };
        assertArrayEquals(expectedResult, people);
    }

    @Test
    public void test_repeatedElements() {
        Person[] people = new Person[] {
                new Person("a", 5),
                new Person("b", 3),
                new Person("c", 8),
                new Person("d", 7),
                new Person("e", 9),
                new Person("f", 6),
                new Person("g", 1),

                new Person("h", 7),
                new Person("i", 9),
                new Person("j", 6),
                new Person("k", 1),

                new Person("l", 9),
                new Person("m", 6),
                new Person("n", 1),
        };

        BucketSortPerson sort = new BucketSortPerson();
        sort.sortByAge(people);

        Person[] expectedResult = new Person[] {
                new Person("g", 1),
                new Person("k", 1),
                new Person("n", 1),
                new Person("b", 3),
                new Person("a", 5),
                new Person("f", 6),
                new Person("j", 6),
                new Person("m", 6),
                new Person("d", 7),
                new Person("h", 7),
                new Person("c", 8),
                new Person("e", 9),
                new Person("i", 9),
                new Person("l", 9),
        };
        assertArrayEquals(expectedResult, people);
    }

}