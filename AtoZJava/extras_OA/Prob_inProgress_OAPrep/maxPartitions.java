package extras_OA.Prob_inProgress_OAPrep;

// exact match: https://www.geeksforgeeks.org/dsa/count-of-subarrays-with-average-k/
// https://share.gemini.google/pP3Cx2equD1d :)
/*Maximum Partitions with Exact Average X

You are given an array of N integers and a value X. Divide the array into the maximum number of contiguous partitions
(subarrays) such that the average of every partition is exactly X.
Return the maximum number of such partitions possible, or -1 if it's not possible to partition the entire array.

Example:
arr = [1, 3, 2, 3, 2, 1], X = 2
Partitions: [1,3] avg=2 ✓, [2] avg=2 ✓, [3,2,1] avg=2 ✓
Answer: 3

Key Insight: Replace each element with arr[i] - X. Now you need to find the maximum number of contiguous partitions
whose sum = 0. Use prefix sums.

This is the right way to prepare. 👍

Don't memorize these 4 questions. Instead, identify the algorithmic pattern behind each and practice from easy →
medium → hard. Most Tier-1 companies (Google, Microsoft, Amazon, Atlassian, Adobe, Uber, etc.) test patterns, not exact problems.

---
Similar Problems
🟢 Direct Match
Maximum Number of Non-overlapping Subarrays With Sum Equals Target (LC 1546) ✅ lc 560 jaisa tha...
Count Zero Sum Subarrays (GFG) ✅
Largest Zero Sum Subarray ✅ also did this: https://algo.monster/liteproblems/325#description - good variant like lc 1546 is one of lc 560 like wise it is too
Split Array into Zero Sum Segments - ni mila ye wala... ye wala sahi hai https://www.geeksforgeeks.org/problems/split-array-in-three-equal-sum-subarrays/1
✅ also did lc 1013 and
lc 1712 [a bit different - find ways to split the array into three sum subarray] ✅

🟡 Same Pattern ⁉️❓⁉️🙋‍♀️
Continuous Subarray Sum (LC 523)
Subarray Sum Equals K (LC 560)
Binary Subarrays With Sum
Make Sum Divisible by P

🔴 Advanced Variant ⁉️❓⁉️🙋‍♀️
Split Array Largest Sum (LC 410)
Partition Array for Maximum Sum
Maximum Number of Ways to Partition an Array (LC 2025)
Prefix Sum + Hashing on Trees

Pattern

⭐⭐⭐ Prefix Sum + Greedy

https://chatgpt.com/s/t_6a66fdf807bc81919ea085539beb8324
*/

import java.util.HashMap;
import java.util.Scanner;

public class maxPartitions {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        int x = sc.nextInt();

        int ans = solve(arr, x);
        System.out.println(ans);
    }
    // sum/cnt=avg
    // sum = avg*cnt -> we don't know the count here... still lets try it...
    // partition complete array - if not possible for complete array return -1
    private static int solve(int[] arr, int x){
        int n = arr.length;
        int cnt = 0;
        int sum = 0;
        for(int i=0; i<n; i++){
            sum += (arr[i]-x);
            // found valid partition with avg x
            if(sum == 0) {
               cnt += 1;
            }
        }

        // if sum != 0 at the end, the last partition never closed properly
        // means last partition has not avg as x
        return sum == 0 ? cnt : -1;
    }
}
