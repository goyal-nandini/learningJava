package fundamentals;

import java.util.*;
// RESOURCE:
//https://copilot.microsoft.com/shares/nNqc64W9q2xaWzLn6uuZo

public class listToArray_viceVersa {
    public static void main(String[] args) {

    }
    public static void listToArray_IntegerType(){
        List<Integer> list = new ArrayList<>(Arrays.asList(1, 2, 3, 4, 5));

        // Convert to array
        Integer[] arr = list.toArray(new Integer[0]);
        // list.toArray(new Integer[0]) → gives Integer[].
        // To get int[], you must unbox each element (via loop or streams).

        // Print array
        System.out.println(Arrays.toString(arr)); // [1, 2, 3, 4, 5]

    }

    public static void listToArray_intType(){
        // classic way: easy
        List<Integer> list = Arrays.asList(1, 2, 3, 4, 5);

        int[] primitiveArr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            primitiveArr[i] = list.get(i);  // auto-unboxing Integer → int
        }

        System.out.println(Arrays.toString(primitiveArr)); // [1, 2, 3, 4, 5]

        // way2:
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5);

        // Convert to int[]
        int[] primitiveArr2 = list1.stream().mapToInt(Integer::intValue).toArray();

        System.out.println(Arrays.toString(primitiveArr2)); // [1, 2, 3, 4, 5]

    }

    public static void arrayToList(){
        Integer[] arr = {5, 2, 8, 1, 9};

        // Convert to fixed-size list
        List<Integer> list = Arrays.asList(arr);

        // Convert to resizable list
        List<Integer> resizableList = new ArrayList<>(Arrays.asList(arr));

        System.out.println(list);          // [5, 2, 8, 1, 9]
        System.out.println(resizableList); // [5, 2, 8, 1, 9]

    }
}
