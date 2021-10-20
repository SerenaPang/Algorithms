package sorting.algorithms;

public class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public void setAge(int val) {
        this.age = val;
    }

    public int getAge() {
        return this.age;
    }

    public void setName(String name){
        this.name = name;
    }

    public String getName() {
        return this.name;
    }

    public String toString() {
        return this.name + " " + this.age;
    }

    public int hasCode() {
        return this.age;
    }

    public boolean equals(Object obj) {
        Person aPerson = (Person)obj;
        if (this.age == aPerson.age && this.name == aPerson.name) {
            return true;
        }
        return false;
    }

}
