package Strings;

public class WrapperClass {
    public static void main(String[] args) {
        // we'll see further about this, take a look in basic_info_navigate

        Integer num = new Integer(56); // creates an Integer object that wraps the value 56.
        System.out.println(num.toString()); // converts that object to its String representation.
        System.out.println(num); // prints the object, which automatically calls toString() behind the scenes.

//        In modern Java (after Java 9), new Integer(56) is discouraged. Instead, you should use autoboxing:
        Integer num1 = 56; // cleaner, faster
    }
}
