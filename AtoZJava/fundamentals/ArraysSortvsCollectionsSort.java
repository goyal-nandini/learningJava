package fundamentals;
import java.util.*;
public class ArraysSortvsCollectionsSort {
    public static void main(String[] args) {
        arraysSortVsCollectionsSort();
        /*Arrays.sort() → For int[], String[], any array type
Collections.sort() → For List<Integer>, ArrayList<String>, any List type*/
    }
    public static void arraysSortVsCollectionsSort() {
        System.out.println("\n=== Arrays.sort() VS Collections.sort() ===\n");

        // ==========================================
        // Arrays.sort() - For ARRAYS (primitive or object)
        // ==========================================
        int[] primitiveArray = {5, 2, 8, 1, 9};
        Arrays.sort(primitiveArray);  // ✅ Works with primitive arrays
        System.out.println("Sorted primitive array: " + Arrays.toString(primitiveArray));

        String[] objectArray = {"banana", "apple", "cherry"};
        Arrays.sort(objectArray);  // ✅ Works with object arrays
        System.out.println("Sorted object array: " + Arrays.toString(objectArray));

        // ==========================================
        // Collections.sort() - For LISTS (not arrays!)
        // ==========================================
        List<Integer> list = new ArrayList<>(Arrays.asList(5, 2, 8, 1, 9));
        Collections.sort(list);  // ✅ Works with Lists
        System.out.println("Sorted list: " + list);

        // ==========================================
        // WRONG USAGE - What DOESN'T work:
        // ==========================================
        // Collections.sort(primitiveArray);  // ❌ ERROR! Cannot sort arrays
        // Arrays.sort(list);  // ❌ ERROR! Cannot sort Lists

        // ==========================================
        // SUMMARY:
        // ==========================================
        System.out.println("\n✅ Arrays.sort() → for int[], String[], etc. (ARRAYS)");
        System.out.println("✅ Collections.sort() → for List<Integer>, List<String>, etc. (LISTS)");
    }
}
