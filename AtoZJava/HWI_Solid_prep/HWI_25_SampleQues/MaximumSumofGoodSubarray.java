package HWI_Solid_prep.HWI_25_SampleQues;

// are same as HWI_25_E2

// edit: 12 august 2026
//https://share.google/aimode/y9bI1udIEIWVMJ066
//https://www.linkedin.com/posts/srishtik-dutta-890587160_algorithms-weekly-heres-an-interesting-share-7350885709454397440-WYJh/
// suggested under this:
//https://leetcode.com/problems/subarrays-with-k-different-integers/description/
//https://leetcode.com/problems/shortest-subarray-with-sum-at-least-k/

/*Maximum Sum of Good Subarray:
You are given an array A of length N and an integer k. It is given that a subarray from l to r
is considered good, if the number of distinct elements in that subarray doesn’t exceed k.
Additionally, an empty subarray is also a good subarray and its sum is considered to be zero.
Find the maximum sum of a good subarray.

Constraints:
N <= 1e5, K <= N, -1e5 <= ai <= 1e5
*/

// edit: 13/8/2026
//https://share.gemini.google/0dpoSvA30nHu PENDING QUE to practice... ❓❓⁉️⁉️🙋‍♀️🙋‍♀️🙋‍♀️❓❓❓⁉️⁉️⁉️

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashMap;
import java.util.Scanner;

public class MaximumSumofGoodSubarray {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int[] arr = new int[n];
        for(int i = 0; i<n; i++){
            arr[i] = sc.nextInt();
        }
        int res = solve(arr, k);
        System.out.println(res);
    }

    private static int solve(int[] arr, int k){
        /* k distinct sum - can handle it - fine
        but the trouble is with max sum - we have neg too in the array,
        if we had all pos, then we can simply expand, shrink based on getting more than k distinct elements and get the
        max sum,
        we have neg now, shrinking the window will make the sum worse then the current
        normal sliding window can't optimize the sum

        we can use prefix sum: prefix sum = prefix[r+1]-prefix[l]
        want to maximum prefix[r+1]-prefix[l]
        l>=currentLeft as sliding window must be somewhere between left and r
        do for fixed r, maximize prefix[r+1]-prefix[l], since prefix[r+1] is fixed, we need minimum prefix[l] for all valid l

        -> Sliding window determines which starting indices are allowed. Prefix sums determine which allowed
        starting index gives the maximum sum.

        which ds do we need?!
        For every right, we need:
        minimum prefix[l] among l ∈ [left, right].
        And left only moves forward.
        This is exactly where a monotonic deque can help.

        LC 862
        We wanted:
        minimum prefix satisfying a SUM >= K condition
        and used a deque ordered by prefix values.

        This problem
        We want:
        minimum prefix inside the current valid sliding-window range
        So we can maintain a monotonic increasing deque of prefix indices.

        🧠 Pattern recognition you should write in your notes
        Constraint is sliding-window friendly, but objective is not because of negative numbers → use sliding window to find
        the valid range + prefix sum to optimize the sum inside that range.
        This is not a normal "sum sliding window" problem. That's the trap.

        */

        int n = arr.length;

        int[] prefix = new int[n+1];
        for(int i=0; i<n; i++){
            prefix[i+1] = prefix[i]+arr[i];
        }

        HashMap<Integer, Integer> map = new HashMap<>();
        Deque<Integer> dq = new ArrayDeque<>(); // it will store starting indices l, sorted by prefix sum values

        int r = 0, l = 0;
        int maxSum = 0;
        while(r<n) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            // shrink left boundary if distinct count exceeds k
            while (map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                l++;
            }

            // abb ye sb max sum ln k lie...
            // maintain a monotonic increasing dq
            /*
              Last in - here make sure ki jo hm daal rhe hai vo prefix[r] se bda na hoo, if it is then dq.pollLast()
            |    |
            |    |
            |    |
            |    |
               Front out - here we get the min sums
            */

            while (!dq.isEmpty() && prefix[dq.peekLast()] >= prefix[r]) {
                dq.pollLast();
            }
            dq.add(r); // equivalent to addLast()

            while (!dq.isEmpty() && dq.peekFirst() < l) {
                dq.pollFirst();
            }

            // we need max sum, subarray ending at r, we need min prefix[l] so
            // prefix[r+1]-prefix[l] to get maximum, ie we have min sums in the front of
            // our dq, in formal terms: The front of the deque deque.peekFirst() is now guaranteed to be the index in
            // [l, r] with the absolute smallest prefix sum!
            if(!dq.isEmpty()) {
                int currentWindowMax = prefix[r + 1] - prefix[dq.peekFirst()];
                maxSum = Math.max(maxSum, currentWindowMax);
            }
            r++;
        }
        return maxSum;

    }

    private static int solve_WRONG(int[] arr, int k) {

        HashMap<Integer, Integer> map = new HashMap<>();
        int r = 0, l = 0;
        int sum = 0;
        int maxSum = 0;
        while (r < arr.length) {
            map.put(arr[r], map.getOrDefault(arr[r], 0) + 1);

            while(map.size() > k) {
                map.put(arr[l], map.get(arr[l]) - 1);
                sum -= arr[l];
                if (map.get(arr[l]) == 0) {
                    map.remove(arr[l]);
                }
                /*for clean code only:
                int count = map.get(arr[l]);
                if (count == 1) {
                    map.remove(arr[l]);
                } else {
                    map.put(arr[l], count - 1);
                }*/
                l++;
            }
            sum += arr[r];
            maxSum = Math.max(maxSum, sum);

            r++;
        }
        return maxSum;
    }
}





