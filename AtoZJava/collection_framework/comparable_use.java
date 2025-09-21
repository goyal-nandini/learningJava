package collection_framework;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

class Student implements Comparable<Student>{ // 🚩🚩
    int age;
    String name;

    public Student(int age, String name) {
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString() {
        return "Student{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }

    public int compareTo(Student that){
        if(this.age > that.age)
            return 1;
        else
            return -1;
    }
}
public class comparable_use {

    public static void main(String[] args) {
        List<Student> studs = new ArrayList<>();

        studs.add(new Student(21, "Navin"));
        studs.add(new Student(12, "Ritik"));
        studs.add(new Student(13, "Aish"));
        studs.add(new Student(29, "Sunny"));

        for(Student s:studs)
            System.out.println();

        Collections.sort(studs); // 🚩🚩

        for(Student s: studs)
            System.out.println(s);

    }
}
