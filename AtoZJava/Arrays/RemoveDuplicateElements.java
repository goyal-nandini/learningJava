package Arrays;

import java.util.HashSet;

public class RemoveDuplicateElements {
    public static void main(String[] args) {
        // using hash set --> as it contains only unique elements which we want...!!
        HashSet<Integer> hs = new HashSet<>();
        int[] arr = {3, 5, 6, 1, 1, 6};
        for(int i=0; i<arr.length; i++){
            hs.add(arr[i]);
        }
        System.out.println(hs); // [1, 3, 5, 6] --> does maintain the uniqueness
        // but not the order
    }
}
