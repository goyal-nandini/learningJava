package Arrays;
import java.util.Arrays;
public class Cyclic_sort {
    public static void main(String[] args) {
        // for arrays with range 1 to N
        int[] arr = {3, 5, 2, 1, 4};
        sort(arr);
        System.out.println(Arrays.toString(arr));
    }

    private static void sort(int[] arr) {
//        for(int i=0; i<arr.length; i++){ // ensures we keep checking the same index until the correct element is placed.
        int i=0; int n=arr.length;
        while(i<n){
            int curr = arr[i]; // curr should be at curr-1 index
            int validInx = curr - 1; // where arr[i] should go to!:)

            if(curr != validInx){
                swap(arr, i, validInx);
            } else {
                i++; // only move forward when the current element is in the right place
            }
        }
    }

    private static void swap(int[] arr, int i, int j){
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }


}
