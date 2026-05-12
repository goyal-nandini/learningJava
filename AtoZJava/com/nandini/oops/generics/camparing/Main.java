package com.nandini.oops.generics.camparing;

import java.util.Arrays;
import java.util.Comparator;

public class Main {
    public static void main(String[] args) {
        Student kunal = new Student(12, 89.76f);
        Student rahul = new Student(5, 99.52f);
        Student arpit = new Student(2, 95.52f);
        Student karan = new Student(13, 77.52f);
        Student sachin = new Student(9, 99.53f);

        Student[] list = {kunal, rahul, arpit, karan, sachin};

        Arrays.sort(list); // seems to be in ascending order with makes HOW?!
        // as it is internally implementing the compareTo() method that we have overridden in student class

        System.out.println(Arrays.toString(list));

        // comparator has compare() method: TWO objects come as parameters.
        Arrays.sort(list, new Comparator<Student>() {
            @Override
            public int compare(Student o1, Student o2) {
//                return -(int)(o1.marks - o2.marks); or this way is also correct
                return (int)(o2.marks - o1.marks); // descending order
            }
        });

        // type casting above below is imp !! why: because compareTo() and compare must return int
        Arrays.sort(list, (a, b) -> (int)(a.marks - b.marks));  // ascending order

        System.out.println(Arrays.toString(list));

        // comparable has compareTo() method
        if (kunal.compareTo(rahul) < 0) {
            // current object, "this" is kunal
            // "o" is rahul, => if value is neg means curr object is smaller

            System.out.println(kunal.compareTo(rahul));
            System.out.println("Rahul has more marks");
        }
        //🟢 one liner:
// Comparable gives ONE natural order.
// Comparator gives MANY custom orders.

        //🟢 final big difference
/*| Comparable              | Comparator          |
| ----------------------- | ------------------- |
| inside class            | outside class       |
| compareTo()             | compare()           |
| natural sorting         | custom sorting      |
| current object involved | both objects passed |


🟢
VERY IMPORTANT UNDERSTANDING:

Arrays.sort(list) uses: Comparable
Arrays.sort(list, comparator) uses: Comparator and ignores compareTo for that sorting call.

🟢
SUPER IMPORTANT FLOW
Arrays.sort(list)
↓
Java internally does many:
compareTo()
calls
↓
Based on:

negative
positive
zero

↓
elements swapped accordingly
↓
sorted array produced.


use this: 🟢
Integer.compare()
Double.compare()
Float.compare()
*/

    }
}
