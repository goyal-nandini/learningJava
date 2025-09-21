package collection_framework;

import java.util.*;

class Student2 {
    int id;
    String name;

    Student2(int id, String name) {
        this.id = id;
        this.name = name;
    }
}

// 2️⃣ Comparator implemented via separate class
class SortBySize implements Comparator<Student2> {
    // Correctly compares the lengths of the student names
    public int compare(Student2 s1, Student2 s2) {
        return Integer.compare(s1.name.length(), s2.name.length());
    }
}

class Comparator_separatorClass {
    public static void main(String[] args) {
        List<Student2> list = new ArrayList<>();
        list.add(new Student2(2, "Raj"));
        list.add(new Student2(1, "Anudeep"));
        list.add(new Student2(3, "Rakhi"));
        list.add(new Student2(4, "Sharmila"));

        Collections.sort(list, new SortBySize());

        for (Student2 s : list) {
            System.out.println(s.id + " " + s.name);
        }
    }
}


