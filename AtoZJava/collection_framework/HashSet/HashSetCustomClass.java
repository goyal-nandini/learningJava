package collection_framework.HashSet;

import java.util.HashSet;
import java.util.Set;

public class HashSetCustomClass {
    public static void main(String[] args) {
        Set<Students> stud = new HashSet<>();

        Students s1 = new Students(23, "Raman");
        Students s2 = new Students(24, "Rajesh");
        Students s3 = new Students(23, "Rajeev");

        stud.add(s1);
        stud.add(s2);
        stud.add(s3);

        System.out.println(stud);
        // output: [Students{RollNo=23, name='Raman'}, Students{RollNo=24, name='Rajesh'},
        // Students{RollNo=23, name='Raman'}]
        // Because each object has a different "memory address", and default
        // equals()/hashCode() methods don't compare name and rollNo.

        // Override equals() and hashCode(): -->
        // students class
        // now, "no more duplicate roll no." entered!!


    }
}
