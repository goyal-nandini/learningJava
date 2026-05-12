package com.nandini.oops.generics.camparing;

public class Student implements Comparable<Student>{
// means Student objects can be compared with other Student objects.
// Comparable<Student> tells Java: compareTo() will compare Student objects only.

    int rollno;
    float marks;

    public Student(int rollno, float marks) {
        this.rollno = rollno;
        this.marks = marks;
    }

    @Override
    public String toString() {
        return "Student{" +
                "rollno=" + rollno +
                ", marks=" + marks +
                '}';
    }

    @Override
    public int compareTo(Student o) { // This method defines: HOW students should be compared.
        // Student o means compare current object with object o.

        int diff = (int)(this.marks - o.marks); // ascending order

//        int diff = (int)(o.marks - this.marks); // descending order

        System.out.println(this.marks + " compared with " + o.marks);
        return diff;

/*| Returned Value | Meaning                |
| -------------- | ---------------------- |
| negative       | current object smaller |
| positive       | current object bigger  |
| 0              | equal                  |
*/
    }
}
