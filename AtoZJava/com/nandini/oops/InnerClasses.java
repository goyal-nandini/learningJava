package com.nandini.oops;

/*Types of Inner Classes 📚
There are 4 types of inner classes in Java:

Non-static Nested Class (Inner Class)
Static Nested Class
Local Inner Class
Anonymous Inner Class
*/

//Top-level outer class CANNOT be static
public class InnerClasses {
    int outerVal = 10;
    static int staticOuterVal = 12;

    class Demo1{
        void display(){
            System.out.println(outerVal);
            System.out.println(staticOuterVal);
        }
    }

//    Static Nested Class Means: "independent of outer class instances"
    static class Demo2{
        void display(){
//            System.out.println(outerVal); ❌ ERROR as static class can't access non-static mem of outer class
            System.out.println(staticOuterVal);
        }
    }

    public static void main(String[] args) {
        InnerClasses outerObj = new InnerClasses();

        InnerClasses.Demo1 innerObj = outerObj.new Demo1(); // Need outer object
        innerObj.display();

//        Demo1 obj = new Demo1(); // ERROR

        InnerClasses.Demo2 staticClassObj = new InnerClasses.Demo2(); // Don't need outer object
        staticClassObj.display();
    }
}
