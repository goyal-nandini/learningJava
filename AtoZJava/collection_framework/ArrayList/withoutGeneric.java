package collection_framework.ArrayList;

import java.util.ArrayList;
public class withoutGeneric {
    //    Without Generics (Raw ArrayList)
//    When you're using an ArrayList without generics, it behaves like a raw type.
//    This means it doesn't enforce any specific type restrictions, and you can add any
//    object to the list, even if those objects are of different types.
//
//    Here’s the problematic code again:
    public static void main(String[] args) {
        ArrayList list = new ArrayList();
        list.add("Hello");  // Adding a String
        list.add(123);  // Adding an Integer, no error at compile-time

        // Retrieving and casting
        String str = (String) list.get(0);  // This works, but could cause an exception if data is not a String
        System.out.println(str);

        // Now, let's retrieve and cast the second element (Integer)
        Integer num = (Integer) list.get(1);  // Cast to Integer
        System.out.println(num);
    }
}
//In this case, the code works because:
//At index 0, you know there's a String, so the cast to String is safe.
//
//At index 1, you know there's an Integer, so the cast to Integer is also safe.
//
//However, if you had added an object of the wrong type (say, a Double at index 1),
// trying to cast it as an Integer would cause a "ClassCastException" at runtime.

// 📌📌
//If you use ArrayList<Integer>, for example, Java will enforce that only Integer objects
// can be added. There's no need for casting, and you'll get a compile-time error if you
// try to add a String or any other type.

