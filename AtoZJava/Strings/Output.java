package Strings;
import java.util.Arrays;
public class Output {
    public static void main(String[] args) {
        // "out" is a variable of "PrintStream" class
        // the method overloading is happening here.

        // anything put is println -> will print String only
        // internally calls -> valueOf() -> toString() (for everyone in println)
        System.out.println(56);
        System.out.println("Nandini");
        System.out.println(new int[]{2, 3, 4}); // object has been passed

        System.out.println(Arrays.toString(new int[]{2, 3, 4})); // function overriding
    }
}
