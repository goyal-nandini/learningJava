package BasicHashing;
/* 🧠 Why HashMap?
    No need to fix range like int[] hash = new int[100].
    Works with any integer — negative, large, or non-continuous.
*/
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class NumberHashMap {
    public static int withHashing(int[] arr, int n){
        // pre-compute
        // ✅ Step 1: Create a HashMap to store frequencies
        // Key: the number in the array
        // Value: how many times that number appears (its frequency)
        Map<Integer, Integer> map = new HashMap<>();
//      Map<Long, Long> map2 = new HashMap<>();  --> also works for > 10^8.

        // ✅ Step 2: Loop through the entire array

        for(int i=0; i<arr.length; i++){
            int curr = arr[i];

            // 📌 map.getOrDefault(curr, 0):
            //   - If the map already contains curr, get its current frequency
            //   - If it doesn't exist in the map, use 0 as default
            //   - Then add 1 to increase the count
            //   - Finally, store it back using map.put()

            map.put(curr, map.getOrDefault(curr, 0) + 1); // 📌
        }

        // ✅ Step 3: After pre-computation, return the frequency of `n`
        // 📌 Again, use getOrDefault in case n is not present in the array
        //   - If `n` is present, return its frequency
        //   - If not, return 0

        // iterate through map
        for(Map.Entry<Integer, Integer> e: map.entrySet()){
            System.out.println(e);
        } // keys are not in sorted fashion!!

        return map.getOrDefault(n, 0); // 📌


    }

    /* 💡 What is getOrDefault(key, defaultValue)?
        This is a shortcut method in Java Map:
        If the key exists → returns map.get(key)
        If the key does NOT exist → returns the defaultValue */

    public static void main(String[] args) {
        // i want to count the numbers appearing in an array

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];

        System.out.println("Enter " + n + " Elements: ");
        for(int i=0; i<n; i++)
             arr[i] = sc.nextInt();

        System.out.println("Enter the number of test-cases: ");
        int t = sc.nextInt();

        System.out.println("Enter the number of which frequency you want: ");
        while(t-- >0){
            int num = sc.nextInt();
            System.out.println("the number "+ num + " is appearing " + withHashing(arr, num) + " times.");
        }
    }
}
