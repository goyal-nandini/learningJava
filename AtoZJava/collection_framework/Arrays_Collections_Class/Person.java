package collection_framework.Arrays_Collections_Class;

public class Person implements Comparable<Person> {
    /* above You are making a promise:
"I promise to implement every method defined in Comparable<Person>."
In this case, Comparable<T> has only one method:
int compareTo(T o);*/

    String name;
    int age;

    // constructor
    public Person(String n, int a){
        this.age = a;
        this.name = n;
    }

/*
If you run System.out.println(list);, you’ll get something like:
[Person@1db9742, Person@106d69c]
🔴 Problem: Java doesn't know how to print the Person object meaningfully.
✅ Fix: Override the toString() method in the Person class.*/

    public String toString(){
        return this.name + " - " + this.age;
    }

    @Override
    public int compareTo(Person that) {
        return this.age - that.age;
    }
}
