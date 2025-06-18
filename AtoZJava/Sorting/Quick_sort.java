package Sorting;
import java.util.*;
public class Quick_sort {
    static int partition(List<Integer> arr, int low, int high) {
        int pivot = arr.get(low);
        int i = low;
        int j = high;

        while (i < j) {
            while (arr.get(i) <= pivot && i <= high - 1) {
                i++;
            }

            while (arr.get(j) > pivot && j >= low + 1) {
                j--;
            }
            if (i < j) {
                int temp = arr.get(i);
                arr.set(i, arr.get(j));
                arr.set(j, temp);
            }
        }
        int temp = arr.get(low);
        arr.set(low, arr.get(j));
        arr.set(j, temp);
        return j;
    }

    static void qs(List<Integer> arr, int low, int high) {
        if (low < high) {
            int pIndex = partition(arr, low, high);
            qs(arr, low, pIndex - 1);
            qs(arr, pIndex + 1, high);
        }
    }
    public static List<Integer> quickSort(List<Integer> arr) {
        qs(arr, 0, arr.size() - 1);
        return arr;
    }
    public static void main(String[] args) {
        List<Integer> arr = new ArrayList<>();

        // Creates a fixed-size list (not a resizable ArrayList) containing these integers.
        //Arrays.asList(...) returns a List backed by an array, so you can’t add/remove elements.
        Integer[] intArray = {4, 6, 2, 5, 7, 9, 1, 3};
        arr = Arrays.asList(intArray);
        //✨ Arrays.asList() in Java is a method that converts an array into a fixed-size
        // list. It is part of the java.util.Arrays class and provides a bridge between
        // array-based and collection-based APIs.
        int n = arr.size();
        System.out.println("Before Using quick Sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();
        arr = quickSort(arr);
        System.out.println("After quick sort: ");
        for (int i = 0; i < n; i++) {
            System.out.print(arr.get(i) + " ");
        }
        System.out.println();

    }
}
