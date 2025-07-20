package collection_framework.Arrays_Collections_Class;

import java.util.Arrays;
public class LearnArraysClass {
    public static void main(String[] args) {
        /*🔷 1. Arrays Class
        ✅ What is it?
        A utility class in java.util package.
        Provides static methods to work with arrays (like sorting, searching, filling, etc).
        Common Methods:
        | Method                          | Description                               |
        | ------------------------------- | ----------------------------------------- |
        | `Arrays.sort(arr)`              | Sorts an array                            |
        | `Arrays.toString(arr)`  ✨        | Prints array as string (for easy viewing) |
        | `Arrays.binarySearch(arr, key)` | Searches using binary search              |
        | `Arrays.equals(arr1, arr2)`     | Compares two arrays                       |
        | `Arrays.fill(arr, value)`       | Fills all elements with given value       |
        | `Arrays.parallelSort(arr)`       | sorts arrays faster      |
        | Arrays.copyOf(array, newLength) | copy/resize array |    */


        int[] n = {1, 3, 5, 6, 7, 10};
        int index = Arrays.binarySearch(n, 8);
        System.out.println(index);

/* Arrays.parallelSort(n);

    It’s a method from the Arrays class introduced in Java 8 that sorts arrays faster using multiple threads (parallelism). It’s useful for large arrays.
    Just like Arrays.sort(), but it works in parallel (behind the scenes using the Fork/Join framework).
    📌 When to Use?
    Use parallelSort() when:

        The array is large (e.g., 10,000+ elements).
        You want to speed up sorting using multiple CPU cores.

    Use sort() when:

        You’re working with small or medium arrays.
        You need predictable, stable sorting.*/

                Arrays.fill(n, 0);

        for(int i: n)
            System.out.print(i+" ");


    }
}
/* ✨📍
🔸 Problem First:
When you try to print an array directly like this:
int[] arr = {1, 2, 3};
System.out.println(arr);
It won’t print the actual numbers. You’ll get something weird like:
[I@15db9742
That’s just the memory reference, not the content.

🔹 Solution: Arrays.toString(arr)
To properly print the contents of the array, use:
System.out.println(Arrays.toString(arr));
Output:
[1, 2, 3]

✅ Now it prints the actual values in the array, wrapped in [].

🔧 Why does it work?
        Arrays.toString() is a method from the java.util.Arrays class that:

        Takes any array (like int[], double[], String[], etc.)

        Converts it into a readable String

quick summary:
| Array Type  | Can Use `Arrays.toString()` | Why Use It?                             |
| ----------- | --------------------------- | --------------------------------------- |
| `int[]`     | ✅ Yes                       | Primitive numbers                       |
| `Integer[]` | ✅ Yes                       | Object type, useful with collections    |
| `String[]`  | ✅ Yes                       | For printing or displaying names, texts |
| `char[]`    | ✅ Yes                       | For individual characters               |



*/