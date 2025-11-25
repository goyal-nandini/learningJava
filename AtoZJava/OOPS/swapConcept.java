package OOPS;
import java.util.Arrays;

// here is concept not logic!!

public class swapConcept {
    public static void main(String[] args) {
        // 1.
        int a=10; int b=20;
//        swap(a, b);
//        System.out.println(a+" "+b); // won't swap values✒️ exp in nb check it out🧐
        System.out.println(Arrays.toString(swap(a, b))); // got swapped!! 🔎🗡️
//      🔦the Arrays.toString() method is used to obtain a string representation
//      of a one-dimensional array.

        // 2.
//        Integer c=30; Integer d=40;
//        swap(c, d);
//        System.out.println(c+" "+d); // won't swap values✒️

        // 3.
        int[] nums = {10,20};
        swap(nums);
        System.out.println(Arrays.toString(nums));

    }

    // 1.
    static int[] swap(int a, int b){
        int temp = a;
        a = b;
        b = temp;
        return new int[]{a, b};
//      This works because arrays are objects and modifications happen
//      on the same reference.
    }

    // 2.
    static void swap(Integer a, Integer b){
        int temp = a;
        a = b;
        b = temp;
    }

    // 3.
    static void swap(int[] arr){
        int temp = arr[0];
        arr[0] = arr[1];
        arr[1] = temp;
    }

/*🔎🗡️
* 🧠 Concept explanation
a and b inside the swap() method are still copies of the original primitive values.
You are not modifying original variables a and b in main.
But you use the swapped values by returning them inside an array.
Arrays are objects, so you are returning an object reference.
So returning swapped values bypasses the pass-by-value limitation.*/
}

//Swap using Wrapper Class
//check part II of this file