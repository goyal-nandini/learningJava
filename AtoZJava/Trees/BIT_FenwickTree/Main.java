package Trees.BIT_FenwickTree;
import java.util.*;
/** A Fenwick tree or binary indexed tree is a data structure providing efficient methods
 * for calculation and manipulation of the prefix sums of a table of values.
 *
 * Space complexity for fenwick tree is O(n)
 * Time complexity to create fenwick tree is O(nlogn)
 * Time complexity to update value is O(logn)
 * Time complexity to get prefix sum is O(logn)*/
public class Main {
    public static void main(String[] args){
        int[] arr = {3, 2, -1, 6, 5, 4, -3, 3, 7, 2, 3};

        BIT ft = new BIT(arr);

        System.out.println("Original array:");
        System.out.println(Arrays.toString(arr));

        System.out.println("Fenwick internal tree:");
        ft.printBIT();

        // -------- PREFIX SUM TEST --------
        System.out.println("\nPrefix sum till index 9:");
        System.out.println(ft.prefixSum(9)); //

        // -------- RANGE SUM TEST --------
        System.out.println("\nRange sum [2,5]:");
        System.out.println(ft.rangeSum(2,5));

        // -------- UPDATE TEST --------
        System.out.println("\nAdd +10 at index 3");
        ft.update(2,10);
        ft.update(5,-10);

        System.out.println("New prefix sum till index 9:");
        System.out.println(ft.prefixSum(9));
    }
}
