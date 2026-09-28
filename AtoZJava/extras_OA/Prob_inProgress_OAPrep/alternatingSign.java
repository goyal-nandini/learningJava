package extras_OA.Prob_inProgress_OAPrep;

/*
* look at this
You are given two integer arrays `A` and `B` of length `N`.
Construct a new array `C` such that for every index `i`, you must choose exactly one value:
- `C[i] = A[i]`, or
- `C[i] = B[i]`
Your goal is to maximize the length of the **longest contiguous subarray** in `C` whose consecutive elements have
* **alternating signs**.
A sequence is alternating if every adjacent pair has opposite signs.
-  Positive → Negative → Positive → ...
-  Negative → Positive → Negative → ...
It is guaranteed that **no element in A or B is zero**.
Return the maximum possible length.
---
## Example
```
A = [ 1, -2,  3, -4]
```
B = [2,  2, -3,  4]
Choose:
C = [1, -2, 3, -4]
Signs:
\+ - + -
Longest alternating length = 4
---
# Constraints
```
1 ≤ N ≤ 1000
```
No value is zero.
|Ai|, |Bi| ≤ 10^9
*
* https://chatgpt.com/s/t_6a89ac9f6e1c81918eb6a053f3af8c88*/

/*
test cases:
4
1 2 -3 4
5 6 -7 8
*/

/*isse milte hue sawaal - bhaii sahi m match hote hai pattern/undertsanding - expansion of brain/brain gym for sure
* wiggle subsequence
* turbulent subarray
* */

import java.util.*;

public class alternatingSign {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] A = new int[n];
        int[] B = new int[n];

        for(int i=0; i<n; i++) A[i] = sc.nextInt();
        for(int i=0; i<n; i++) B[i] = sc.nextInt();

        int[][] dp = new int[n+1][3]; // 0 - not set, 1 - pos, 2 - neg
        for(int[] row: dp) Arrays.fill(row, -1);
        int ans = solve(0, 0, A, B, dp);
        System.out.println(ans);
    }

    /* 🚩🚩
    So structurally your recursion is: pick1 (extend chain with A[i]), pick2 (extend chain with B[i]), notPick
    (give up on continuing from here, look for the best chain starting further right). That's correct, just expensive
    (extra states) for what's really a much simpler pattern.
     */

    private static int solve(int idx,  int prev, int[] nums1, int[] nums2, int[][] dp){
        if(idx >= nums1.length) return 0;

        if(dp[idx][prev] != -1) return dp[idx][prev];

        // pick from nums1
        int pick1 = 0;
        if(prev==0
            || (prev == 1 && nums1[idx] < 0)
            || (prev == 2 && nums1[idx] > 0)){
            int newPrev = (nums1[idx]<0) ? 2 : 1;
            pick1 = 1+solve(idx+1,  newPrev, nums1, nums2, dp);

        }

        // pick from nums2
        int pick2 = 0;
        if(prev==0
            || (prev == 1 && nums2[idx] < 0)
            || (prev == 2 && nums2[idx] > 0)){
            int newPrev = (nums2[idx]<0) ? 2 : 1;
            pick2 = 1+solve(idx+1, newPrev, nums1, nums2, dp);

        }

        int notPick = solve(idx+1, 0, nums1, nums2, dp);
        /* 🚩🚩
        this above line of code isn't skipping an array element — it's saying "abandon the current alternating chain and
        let the answer come
        from a fresh chain starting later." That's needed only because the longest alternating run can start anywhere
        in the array, not just at index 0. It's the same idea as Kadane's algorithm resetting when the running sum turns
        negative.*/

        return dp[idx][prev] = Math.max(notPick, Math.max(pick1,pick2));
    }
}
