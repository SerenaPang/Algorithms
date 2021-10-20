package sorting.algorithms;

import java.util.LinkedList;

public class BucketSortPerson {
    public void sortByAge(Person[] people) {
        LinkedList<Person>[] ageBucketsArray = new LinkedList[131];
        for (int i = 0; i < ageBucketsArray.length; i++) {
            ageBucketsArray[i] = new LinkedList<>();
        }

        for (Person aPerson : people) {
            ageBucketsArray[aPerson.getAge()].add(aPerson);
        }
         // print(ageBucketsArray);
        /**
        //put the sorted elements to a list
        List<Person> listOfSortedPersons = new ArrayList<>();
        for (int i = 0; i < ageBucketsArray.length; i++) {
            if (ageBucketsArray[i].size() == 0) {
                continue;
            } else{
                for (int j = 0; j < ageBucketsArray[i].size(); j++) {
                    listOfSortedPersons.add(ageBucketsArray[i].get(j));
                }
            }
        }
        //put the elements sorted to the original array
        for (int i = 0; i < people.length; i++) {
            people[i] = listOfSortedPersons.get(i);
        }
         */

        int index = 0;
        for (int i = 0; i < ageBucketsArray.length; i++) {
            if (ageBucketsArray[i].size() == 0) {
                continue;
            } else {
                for (int j = 0; j < ageBucketsArray[i].size(); j++) {
                    people[index] = ageBucketsArray[i].get(j);
                    index++;
                }
            }
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
