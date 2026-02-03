package com.nandini.oops;
// remember, this static class is not same as u are thing it in context of static method and
// static variables, keep it in mind!!
public class InnerClasses_2 {

    // non-static inner class: it means it is dependent on the instances of the outer class.
    // so to create n Test obj, you must have an outer class object first!
    class Test{
        String name;

        public Test(String name){
            this.name = name;
        }

        @Override // these are annotations!!
        public String toString() {
            return name;
        }
    }

    static class Test2{
        String name;
        public Test2(String name){
            this.name = name;
        }

        @Override // these are annotaions!!
        public String toString() {
            return name;
        }
    }
    public static void main(String[] args) {
// main is STATIC - no InnerClasses_2 object exists here!

//      hey this is an error: Non-static variable cannot be referenced from a static context.
//        Test a = new Test("Kunal");
//        Test b = new Test("Nikhil");
// Question: Which InnerClasses_2 object does this Test belong to?
// Answer: NONE! No object exists!
/*The JVM is confused:**
- To create `Test`, it needs an `InnerClasses_2` object
- But in `main` (static context), **no such object exists**!
- So it cannot create `Test`*/

        // solution 1: CREATE OUTER CLASS OBJECT:
        InnerClasses_2 outerObj = new InnerClasses_2();

        Test innerObj = outerObj.new Test("Kunal"); // CORRECT!!
        System.out.println(innerObj);

        // solution 2: make inner class STATIC!!
        // then there's no need of outer class object!!
        Test2 obj1 = new Test2("Rohan");
        Test2 obj2 = new Test2("Sohan");

        System.out.println(obj1.name);
        System.out.println(obj2.name);
    }
/*⭐⭐⭐Why Does This Design Exist? 🤷‍♀️

When to use non-static inner class:
When inner class needs access to outer class's instance variables
Example: Car has Engine - engine needs to know about the car

When to use static nested class:
When inner class is independent
Example: University.Course - course doesn't need a specific university instance*/
}
