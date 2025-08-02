package Strings;

import java.util.ArrayList;

public class Operators {
    public static void main(String[] args) {
        System.out.println('a' + 'b'); // When using + between chars, they are converted to int first (ASCII values), then added.
        System.out.println("a" + "b"); // both are strings -> concatenation

        System.out.println('a' + 3); // char + int results in int addition

        System.out.println("a" + 3); // Since one is a String, Java converts the "int" to a
        // "String" and concatenates
        // Java implicitly converts 3 to a String using String.valueOf(3).
        //Then it concatenates: "a" + "3" → "a3"

//        System.out.println("Nandini" + new Integer(56)); // When you concatenate an object with a
        // String, Java calls toString() on the object, --> new Integer(56) is discourage and deprecated
        System.out.println("Nandini" + new ArrayList<>());

        //📍✨📍 "string" + anything	->  String concatenation using toString()


//       System.out.println(new Integer(56) + new ArrayList<>());
/*  ✨ 🚨  why this doesn't work:
      Because you're trying to use the + operator between two objects:
new Integer(56) is an Integer object
new ArrayList<>() is an ArrayList object

Java doesn't know how to add an "Integer" object to an "ArrayList" object using "+".
Unlike:
System.out.println("hello" + new ArrayList<>());
Where one operand is a String, so Java uses string concatenation, here neither operand is a String,
so Java looks for a way to mathematically add the two objects — but there's no such rule for combining Integer + ArrayList.*/

        // to make it work, Use a string somewhere so Java performs string concatenation:
//        System.out.println(new Integer(56) + " " + new ArrayList<>());

        // ✨
        // Java overloads "+" only for String concatenation — this is built-in by the language,
        // not something the user can define.
        System.out.println(1 + 2);         // Arithmetic → 3
        System.out.println("a" + "b");     // Concatenation → "ab"
        System.out.println("a" + 10);      // "a10" (int → string)
        System.out.println("a" + true);    // "atrue" (boolean → string)
        System.out.println("a" + new ArrayList<>());  // Calls toString() on ArrayList
//        So:

//        If any operand is a String, Java automatically converts the other one to a String and concatenates.
//        This is hardcoded into the language — you can't define your own behavior for + with your own
//        classes (unlike C++).


    }
}
