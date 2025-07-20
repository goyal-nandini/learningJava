package Strings;

public class BasicsOfString {
    public static void main(String[] args) {
        String a = "Nandini";
        System.out.println(a);

        a = "Goyal"; // created a new object, former got to garbage collection
        System.out.println(a);

        String b = "Nandini";
        String c = "Nandini";
        System.out.println(b == c); // this shows different reference variable, b & c point to
        // same object in the String pool inside heap memory.

        System.out.println(b);
        b = "Tom";
        System.out.println(b);
        System.out.println(c);

        String name1 = new String("Nandini");
        String name2 = new String("Nandini");

        System.out.println(name1.equals(name2)); // true, checks for value
        System.out.println(name1 == name2); // false

    }
}
