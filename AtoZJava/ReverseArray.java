// here we have converted array to list
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class ReverseArray {
    public static void reverseArray(List<Integer> arr, int i){
        int n = arr.size();
        if(i>=n/2) return;

        // Collections.swap(arr, i, n - i - 1) properly swaps the ith and
        // (n - i - 1)th elements.
        Collections.swap(arr, i, n-i-1);

        reverseArray(arr, i+1);

    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        List<Integer> arr = new ArrayList<>();

        // Read 6 inputs into the list
        for(int i=0; i<6; i++)
            arr.add(sc.nextInt()); //collects inputs properly.

        reverseArray(arr, 0);
        for(int num : arr)
            System.out.println(num);// print the final list
    }

}
