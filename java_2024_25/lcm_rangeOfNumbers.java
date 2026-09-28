// done nicely be me, faces minor issues but resolved it, one new way of representing, idea in this
// code, check it out here!!
import java.util.*;
public class lcm_rangeOfNumbers {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of the array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];
        System.out.println("Enter the elements: ");
        for(int i = 0; i < arr.length; i++){
            arr[i] = sc.nextInt();
        }

        System.out.println("Lcm of these given " + size + " numbers which are: " + printArray(arr) + " is: " + findLcm(arr));
        // I wanted here to print the array as [a, b, c,....] so here it is
    }
    public static String printArray(int[] a){
        // Create a new StringBuilder to build the string.
        //A StringBuilder is used to build the string efficiently.
        // It's like a container where we can add characters or strings piece by piece.
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        // Loop through each element of the array
        for(int i = 0; i < a.length; i++){
            // Append/adds the current element of the array to the StringBuilder
           sb.append(a[i]);
            // If this is not the last element, add a comma and a space.
            //This ensures that the last element does not have a trailing comma.
           if(i < a.length - 1){
               sb.append(", ");
           }
        }
        sb.append("]");
        // Convert the StringBuilder to a string and return it
        return sb.toString();
    }
    public static int findLcm(int a, int b){
        int lcmOfTwoNumbers = (a * b) / findHcf(a, b);
        return lcmOfTwoNumbers;
    }

    public static int findLcm(int[] input){
         int result = input[0];
         for(int i = 1; i < input.length; i++){
             result = findLcm(result, input[i]);
         }
         return result;
    }
     public static int findHcf(int p, int q){
        if(p == 0){
            return q;
        }
        return findHcf(q % p, p);
     }
}
