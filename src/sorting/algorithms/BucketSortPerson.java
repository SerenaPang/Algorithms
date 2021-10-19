package sorting.algorithms;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class BucketSortPerson {
    public void sortByAge(Person[] people) {
        LinkedList<Person>[] indexAsAgeArray = new LinkedList[131];
        for (int i = 0; i < indexAsAgeArray.length; i++) {
            indexAsAgeArray[i] = new LinkedList<>();
        }

        for (Person aPerson : people) {
            indexAsAgeArray[aPerson.getAge()].add(aPerson);
        }
         // print(indexAsAgeArray);
        //put the sorted elements to a list
        List<Person> listOfSortedPersons = new ArrayList<>();
        for (int i = 0; i < indexAsAgeArray.length; i++) {
            if (indexAsAgeArray[i].size() == 0) {
                continue;
            } else{
                for (int j = 0; j < indexAsAgeArray[i].size(); j++) {
                    listOfSortedPersons.add(indexAsAgeArray[i].get(j));
                }
            }
        }
        //put the elements sorted to the original array
        for (int i = 0; i < people.length; i++) {
            people[i] = listOfSortedPersons.get(i);
        }
        print(people);
    }

    public void print(LinkedList<Person>[] indexAsAgeArray) {
        for (int i = 0; i < indexAsAgeArray.length; i++) {
           System.out.println(indexAsAgeArray[i].toString());
        }
    }

    public void print(Person[] result) {
        for (int i = 0; i < result.length; i++) {
            System.out.println(result[i].toString());
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
