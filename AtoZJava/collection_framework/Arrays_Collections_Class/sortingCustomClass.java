package collection_framework.Arrays_Collections_Class;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class sortingCustomClass {
    public static void main(String[] args) {

        ArrayList<Person> list = new ArrayList<>();

        // objects of person class
        Person p1 = new Person("Anuj", 23);
        Person p2= new Person("Tanuj", 32);
        Person p3 = new Person("David", 20);
        Person p4 = new Person("Nicolos", 20);
        Person p5 = new Person("Ron", 21);

        list.add(p1);
        list.add(p2);
        list.add(p3);
        list.add(p4);
        list.add(p5);
        System.out.println(list);

/*To sort a list of custom objects like Person, you must:
1. Either make Person implement Comparable<Person> and define the logic inside compareTo().
2. Or use Comparator<Person> for custom sorting.
*/
        // 1. sorting following the compareTo() method in Person class
        // This is the traditional way of writing a comparator using an anonymous inner class. 👇👇🚨🚨
        // It’s longer, but works in all Java versions.
        System.out.println(p1.compareTo(p2));
        Collections.sort(list);
        System.out.println(list);

        // 2. Use Comparator externally (no need to change class)
        Collections.sort(list, new Comparator<Person>() {
            @Override
            public int compare(Person o1, Person o2) {
                return o1.name.compareTo(o2.name);
            }
        });

        // lambda expression: This is a modern and concise way (Java 8+) to write the same comparator
        // using lambda syntax. It's cleaner and easier to read.
        Comparator<Person> sortByName = (o1, o2) -> o1.name.compareTo(o2.name);
        Collections.sort(list, sortByName);

        // or
        Collections.sort(list, (o1, o2) -> o1.name.compareTo(o2.name));

    }

}
/*📍📍🚨🚨
An anonymous class is a class without a name that is used to create an object on the spot for one-time use.
You define and instantiate it at the same time.
🔸 In your code:

Collections.sort(list, new Comparator<Person>() {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
});
This part:

new Comparator<Person>() {
    @Override
    public int compare(Person o1, Person o2) {
        return o1.name.compareTo(o2.name);
    }
}
...is an anonymous class.

🔁 Alternative: Named class (not anonymous)

class SortByName implements Comparator<Person> {
    public int compare(Person a, Person b) {
        return a.name.compareTo(b.name);
    }
}
Then:

Collections.sort(list, new SortByName());
🔸 This works the same, but requires creating a full class with a name (SortByName).

*/
