package com.nandini.oops;

// 🎥🫣👁️from 28 aug to 10 nov to 24/11 🔦
class Student{
    int roll;
    String name;
    float marks;

    void greeting(){
        System.out.println("My name is " + this.name); //internally it'll be like Nandini.name
    }

    void changeName(String newName){
        name = newName;
    }

//    Student(){
//        this.roll = 76; // ""this"" is basically replacing with the reference variable
//        this.name = "Nandini Goyal";
//        this.marks = 88.5f;
//    }

//    Student (int roll, String name, float marks){
//        roll = roll;
//        name = name;
//        marks = marks;
//    }

//    vs

    // for understanding chaining constructors
    Student(){
        this(13, "Arpit", 100.0f);
    }

    Student (int roll, String name, float marks){
        this.roll = roll;
        this.name = name;
        this.marks = marks;
    }
}

public class ThisKeyword {
    public static void main(String[] args) {
        Student Nandini = new Student(); // Nandini is the reference variable

        // ""this"" is internally doing this!!
//        Nandini.roll = 76;
//        Nandini.name = "Nandini";
//        Nandini.marks = 88.5f;

//        System.out.println(Nandini.roll);
//        System.out.println(Nandini.name);
//        System.out.println(Nandini.marks);
//        Nandini.changeName("Art Lover");
//        Nandini.greeting();

        Student Rahul = new Student(18, "Rahul", 88.5f);
        System.out.println(Rahul.roll);
        System.out.println(Rahul.name);
        System.out.println(Rahul.marks);

        // for understanding chaining constructors
        Student random = new Student();
        System.out.println(random.name); // prints: Arpit
    }

}
