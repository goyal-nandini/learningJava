
/*reason for array is an object
| Reason                          | Explanation                       |
| --------------------------------- | --------------------------------- |
| Created with `new`                | Just like objects                 |
| Have `length` field               | Like object properties            |
| `getClass()` & `instanceof` works | Arrays belong to internal classes |
| Stored in heap & referenced       | Like all Java objects             |

just for knowledge:
Whenever an object is created, it's always stored in the "Heap space" and "stack memory"
contains the "reference" to it. Stack memory only contains local primitive variables and
reference variables to objects in heap space.
 */
public class ArrayAsObject {
    public static void main(String[] args) {
        // 1️⃣
        int[] n = new int[3];

        System.out.println(n.getClass());
        if(n instanceof Object){
            System.out.println("array is an object");
        }

        // What's happening next?
        // new int[3] creates an array of primitive integers: int[].
        // You're storing it in a reference of type Object.

        Object ob = new int[3];

        // But this does not mean ob is an array of Objects — it’s just holding a
        // reference to an int[].
        // ob[0] = 10;  ❌ Compile-time error — `Object` doesn't know it's an array

        // To access it like an array, you'd need to cast:

        int[] arr = (int[]) ob;
        arr[0] = 10;  // ✅ Now you can access

        // 2️⃣

        // What's happening next?
        // You're creating an array of references, where each element can store
        // any object (not primitive types like int, char, etc.).

        // Object[] can hold objects of any class — like Sample, String, Integer, etc.
        Object[] ob1 = new Object[3];

//        ob1[0] = new Sample();     // ✅ okay
        ob1[1] = "Hello";          // ✅ also okay

        if(ob1 instanceof Object){
            System.out.println("ob1 is an object");
        }


    }
}
