package Strings;
import java.util.Arrays;

public class String_Mathods {
    public static void main(String[] args) {
        String name = "Nandini Goyal";
        System.out.println(Arrays.toString(name.toCharArray())); // [N, a, n, d, i, n, i,  , G, o, y, a, l]
/*name.toCharArray() returns a char array (char[]).
Printing a raw array reference directly (like System.out.println(charArray)) will print something
like a memory address (e.g., [C@1a2b3c) instead of the array contents.
Arrays.toString(charArray) converts the array into a readable String representation of the array
elements, for example: [a, b, c, d] if the char array was {'a','b','c','d'}.

        -> i thought:  name.toCharArray() is an object so we use toString() for its representation:
            truth:
The char array is an object (all arrays are objects in Java).
But directly printing it calls the default toString() from the Object class, which prints the reference info,
not the contents.
Using Arrays.toString() explicitly creates a string showing the elements inside the array.*/


        System.out.println(name.toLowerCase());
        System.out.println(name);
        System.out.println(name.indexOf('a'));
        System.out.println("     Nandini   ".strip()); // Returns a string with all leading and trailing white
        // space removed.
        System.out.println(Arrays.toString(name.split(" ")));
    }
}
