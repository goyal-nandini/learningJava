package com.nandini.oops.generics;

/*Generic METHOD
static <T> void printData(T value)
ONLY this method knows about T.
Not whole class.*/

class Demo{
    static <T> void printData(T value){ // remember <T> is not return type,
        // it only tells: “This method introduces a generic type T.”
        System.out.println(value);
    }

    static <T> void printArray(T[] arr){ // This works only for OBJECT type elements.
        // like: String[] Integer[] Double[] Student[], T = String, T = Integer, T = Double
        for(T ele: arr)
            System.out.print(ele + " ");
        System.out.println();
    }

    static <T> void show(T obj){
        System.out.println(obj.getClass());
    }
}
public class genericMethods {
    static void main() {
        Demo.printData("Hello");
        Demo.printData(45);
        Demo.printData(3.14);

        String[] names = new String[3];
        names[0] = "Riya";
        names[1] = "Rita";
        names[2] = "Yash";
        Demo.printArray(names);

//        T[] arr = new T[3]; // Error, aree T hai kya...!?

        int[] arr2 = {2, 3, 4};
//        Demo.printArray(arr2); // Compile ERROR, printArray method takes Object type not primitive type.
        // REMEMBER: Generics cannot use primitive types.

// to avoid this error: always ask: what T is becoming?!
/*Here:
<T> void show(T obj)  with int[] => T = int[] => VALID.
But here:
<T> void printArray(T[] arr) with int[] => T = int => INVALID.*/


        String str = "Hey";
        Integer num = 20;
        int[] arr = {5, 6, 7}; // int[] IS-A Object

        Demo.show(str); // class java.lang.String
        Demo.show(num); // class java.lang.Interger
        Demo.show(arr); // class [I
        Demo.show(new int[]{2, 3, 4}); // class [I,
        // T = int[] not int

/*[I is the internal representation for int[] means int array
*/
    }
}
/*Notice: Java added one EXTRA thing: "<T>" before return type.
Why?
Because Java must FIRST know:
“This method is using a type parameter named T.”

Only THEN can it understand: "T value"
and possible return type T.

Imagine: <T>
as:
“Template setup area”
before actual method definition starts. That’s why it comes before return type.
*/
