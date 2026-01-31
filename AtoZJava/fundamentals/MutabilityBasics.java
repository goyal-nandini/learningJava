package fundamentals;

public class MutabilityBasics {
    public static void main(String[] args) {

        // Primitives:
        int a=10;
        int b=a; // b gets a copy of the value of a
        b=20;
        System.out.println("a = " + a); // 10
        System.out.println("b = " + b); // 20

        // References Types:
        int[] arr1 = {1, 2, 3};
        int[] arr2 = arr1; // arr2 gets copy of reference, not the array
        arr2[0] = 999;
        System.out.println("arr1[0] = " + arr1[0]); // 1❌ why? ans: References & Memory Model
        System.out.println("arr2[0] = " + arr2[0]); // 999

/*In Memory, two things are created:
The actual array [1, 2, 3] sits somewhere in memory (heap)
The variable arr1 holds the ADDRESS (reference/pointer) to that array.

-> when u do "int[] arr2 = arr1" -> Both variables arr1 and arr2, started pointing to the same array in memory.
hence when u modify the value of actual array, meanwhile it got changed for both variables.

KEY CONCEPT:
Primitives (int, char, boolean, etc.): Store the actual VALUE
Objects/Arrays: Store the REFERENCE (address/pointer) to the actual data
*/
        // creating a true copy:
        int[] arr3 = {1, 2, 3};
        int[] arr4 = arr3.clone(); // Or: Arrays.copyOf(arr3, arr.length);
        arr4[0] = 777;
        System.out.println("arr3[0] = " + arr3[0]); // 1
        System.out.println("arr4[0] = " + arr4[0]); // 777

/*When you use .clone() or Arrays.copyOf():

A NEW array is created in memory
arr4 gets the address of this NEW array (different address)
Now arr3 and arr4 point to different arrays
Modifying one doesn't affect the other!*/

        stringImmutability();
        stringConcatenationProblem();
        stringBuilderSolution();
        stringBuilderChaining();
    }

    public static void stringImmutability(){
        // String IMMutability:
        String s1 = "Hello";
        String s2 = s1; // s2 points to same String Object

        System.out.println("Before: ");
        System.out.println("s1 = " + s1); // Hello
        System.out.println("s2 = " + s2); // Hello

        s2 = s2 + "World";

        System.out.println("After: ");
        System.out.println("s1 = " + s1); // Hello
        System.out.println("s2 = " + s2); // HelloWorld

        System.out.println("Are they same object? " + (s1 == s2)); // false

/*Sum-up: here, s2 Should get the same reference as S1 but It does not happen as the strings are immutable
so S2 starts pointing to a different address with the same Value in it, hence
Changing S2 does not modify S1, and also s1 != s2 is true.

Points:
1. Java tries to modify the String "Hello" to "Hello World"
2. **BUT Strings are IMMUTABLE** - they CANNOT be changed!
3. So Java creates a **NEW String object** "Hello World" in memory
4. `s2` now points to this NEW object
5. `s1` still points to the original "Hello"
*/
    }

    public static void stringConcatenationProblem(){
        String res = "";

        // This is very inefficient!!
        for(int i=0; i<5; i++){
            res = res + i;
            System.out.println("After adding " + i + ": res = " + res);
        }

        // What's happening in memory?
        // Iteration 0: "" --> "0" (1 new object)
        // Iteration 1: "0" --> "01" (1 new object, "0" becomes garbage)
        // Iteration 2: "01" --> "012" (1 new object, "01" becomes garbage)
        // ... and so on!

        System.out.println("final res: " + res);
        System.out.println("total new string objects created are: 5");
        System.out.println("this is why we use Stringbuilder for loops!");

/*If 1000 iterations = 1000 NEW String objects created, with 999 of them becoming garbage immediately!
This is extremely memory inefficient and slow.*/
    }

    public static void stringBuilderSolution(){
        StringBuilder sb = new StringBuilder(); // Mutable!

        for(int i=0; i<5; i++){
            sb.append(i); // Modifies same object!
            System.out.println("After adding " + i + ": sb = " + sb);
        }

        System.out.println("final res: " + sb);
        System.out.println("total objects created: only 1 stringbuilder!");

        // converting stringbuilder to string
        String newString = sb.toString();
        System.out.println("StringBuilder to string: " + newString);

        System.out.println("Reverse: " + sb.reverse());

        System.out.println("Insert at index (say2): " + sb.insert(2, 'X'));

        System.out.println("Del char at index (say2): " + sb.deleteCharAt(2));

        sb.setCharAt(0, 'Z');
        System.out.println("Set char at index (say2): " + sb);
//        System.out.println("Set char at index (say2): " + sb.setCharAt(0, 'Z')); ❌, returns a void, RULE 👇

        System.out.println("length: " + sb.length());

        System.out.println("char at ind 0: " + sb.charAt(0));

/* THE Rule:
Methods that MODIFY the object usually return void (because the object itself is changed)
Methods that CREATE or GET something return a value
*/
        // MODIFIERS - return void (they change the StringBuilder itself)
        sb.append("x");        // void - modifies sb
        sb.insert(0, "x");     // void - modifies sb
        sb.delete(0, 1);       // void - modifies sb
        sb.deleteCharAt(0);    // void - modifies sb
        sb.setCharAt(0, 'x');  // void - modifies sb
        sb.reverse();          // void - modifies sb

        // GETTERS/CONVERTERS - return values (they don't modify, just read/create)
        sb.charAt(0);          // returns char
        sb.length();           // returns int
        sb.toString();         // returns String
        sb.substring(0, 5);    // returns String

    }

    public static void stringBuilderChaining(){
        StringBuilder sb = new StringBuilder();

        // These actually RETURN StringBuilder (for chaining):
        sb.append("Hello")
                .append(" ")
                .append("World")
                .reverse();

        System.out.println(sb);

        // But setCharAt returns void (cannot chain):
        sb.setCharAt(0, 'X');  // void - no chaining
        System.out.println(sb);

        // charAt returns char (can use in expression):
        char c = sb.charAt(0);
        System.out.println("First char: " + c);
    }
}
