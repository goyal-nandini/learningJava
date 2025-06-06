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
/*    🔁 Template to Remember:
@Override
public String toString() {
    return "ClassName{" +
           "field1=" + field1 +
           ", field2='" + field2 + '\'' +
          '}';
}
This is how Java developers usually format the string:
ClassName{field1=value1, field2=value2, ...}*/

    @Override
    public boolean equals(Object o) {
        // 1. Check if compared to itself
        if (this == o) return true;

        // 2. Check if the other object is null or from a different class
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Cast the object and compare relevant fields
        Students students = (Students) o;
        return RollNo == students.RollNo;
    }

    @Override
    public int hashCode() {
        // Use the field(s) used in equals — here rollNo
        return Objects.hashCode(RollNo);   // You can also use: return Integer.hashCode(rollNo);
    }

    // If two objects are equal according to equals(), then their hashCode() must be the same.

    // So always use the same field(s) in both methods.

    // A field in Java is just a variable defined inside a class.
    // So rollNo and name are fields (a.k.a. member variables or instance variables).
}
