package collection_framework.HashSet;

import java.util.Objects;

public class Students {

    int RollNo;
    String name;

    // Constructor: gets called automatically when you create a new Student object.
    public Students(int rollNo, String name){
        this.name = name;
        this.RollNo = rollNo;
    }

    @Override
    public String toString() {
        return "Students{" +
                "RollNo=" + RollNo +
                ", name='" + name + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Students students = (Students) o;
        return RollNo == students.RollNo;
    }

    @Override
    public int hashCode() {
        return Objects.hashCode(RollNo);
    }
}
