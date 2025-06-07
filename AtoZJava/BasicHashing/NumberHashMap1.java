package BasicHashing;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

// non clustered (me)
public class NumberHashMap1 {
    public static void main(String[] args) {
        // just refinement and revising at same time

        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the size of array: ");
        int size = sc.nextInt();

        int[] arr = new int[size];

        Map<Integer, Integer> map = new HashMap<>();
        System.out.println("Enter the elements: ");
        for(int i=0; i<arr.length; i++){
            arr[i] = sc.nextInt();

            int n = arr[i];
            map.put(n, map.getOrDefault(n, 0) + 1);
        }
        System.out.println("Enter the number you want to get frequency of: ");
        int num = sc.nextInt();
        System.out.println(map.getOrDefault(num, 0));

    }
}
