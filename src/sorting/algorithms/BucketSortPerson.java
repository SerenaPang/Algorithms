package sorting.algorithms;
import java.util.LinkedList;

public class BucketSortPerson {
    public void sortByAge(Person[] people) {
        LinkedList<Person>[] indexAsAgeArray = new LinkedList[131];
        for (int i = 0; i < indexAsAgeArray.length; i++) {
            indexAsAgeArray[i] = new LinkedList<>();
        }

        for (Person aPerson : people) {
            indexAsAgeArray[aPerson.getAge()].add(aPerson);
        }
        print(indexAsAgeArray);

    }

    public void print(LinkedList<Person>[] indexAsAgeArray) {
        for (int i = 0; i < indexAsAgeArray.length; i++) {
           System.out.println(indexAsAgeArray[i].toString());
        }
    }

    public static void main(String[] args) {
        BucketSortPerson s = new BucketSortPerson();
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
        s.sortByAge(people);
    }


}
