package extras_OA.ClaudeMockTest_realQueBased;

// very imp confusion cleared on guard used in DP problems - must revise it
// https://share.gemini.google/mAzEiCL8pAhm

import java.util.*;

/*## Spice Blend Sequencing

**Difficulty: Hard**

---

### Problem Statement

A chef is creating a signature spice blend by combining spices from 2 different regional collections:
- **Collection A** has **N** spices
- **Collection B** has **M** spices

The chef must select **exactly K spices** in total to create the blend. At each step, the chef picks the next available spice from the **front of either** Collection A or Collection B. The original relative order of spices within each collection **must be preserved.**

Each spice has a **flavor profile** (an integer category) and an **intensity value.**

- **Intensity**: The intensity of every selected spice **adds to the score.**
- **Harmony**: When two consecutive spices in the blend share the same **flavor profile**, a **Harmony Bonus** of **H points is added.**

Find the **maximum total score** (sum of intensities + harmony bonuses) achievable by selecting exactly **K** spices.

---

### Input Format

- Line 1: Integer **N** — number of spices in Collection A
- Line 2: Integer **M** — number of spices in Collection B
- Line 3: Integer **K** — number of spices to select
- Line 4: Integer **H** — harmony bonus value
- Next **N** lines: Two space-separated integers — **Flavor** and **Intensity** for each spice in A
- Next **M** lines: Two space-separated integers — **Flavor** and **Intensity** for each spice in B

---

### Constraints

```
1 <= N <= 1000
1 <= M <= 1000
1 <= K <= N+M
1 <= H <= 10^5
1 <= A[i][j] <= 10^5
1 <= B[i][j] <= 10^5
```

---

### Sample Test Case

**Input:**
```
2
1
3
50
1 10
2 20
1 15
```

**Output:**
```
95
```

**Explanation:**
We select all three available spices. By choosing the single spice from Collection B (flavor 1) first, followed by the first spice from Collection A (flavor 1), we create a flavor match that earns a harmony bonus of 50.

Score = 15 + 10 + 20 + 50 = **95**

---

### Function Signature (Java)

```java
public static long MaxScore(int N, int M, int K, int H,
                            List<List<Integer>> A,
                            List<List<Integer>> B)
```

Good luck! 💪*/

public class blendSequencing {
    static void main(String[] args) {
        // Sample Test Case Test
        List<List<Integer>> A = Arrays.asList(
                Arrays.asList(1, 10),
                Arrays.asList(2, 20)
        );
        List<List<Integer>> B = Arrays.asList(
                Arrays.asList(1, 15)
        );

        System.out.println(MaxScore(2, 1, 3, 50, A, B)); // Output: 95
    }
    /*Complexity Analysis
    
    Time Complexity: O(N * M) since there are (N+1) * (M+1) * 3 states and 
    each state takes O(1) transition time. Given N, M \le 1000, this will run well within the time limit 
    (~3 million operations).
    
    Space Complexity: O(N * M) for the 3D DP array and recursion stack frame.*/

    public static long MaxScore(int N, int M, int K, int H,
                                List<List<Integer>> A,
                                List<List<Integer>> B){
        /* mere thoughts initially, merge collection A and B with there coll name A and B then
        we have two choices - pick from A or pick from B and check if the flavor val
        is same, if so then bonus gets added, hmm, then return the max total score of k spices picked

        dp m pick up too hai but limited hai... dp ya greedy - na greedy too ni, non-uniformity ho skti hai

        aree sort ni krr skte - rel order same and front pick up hai -
         states: i, j,
         */

        long[][][] dp = new long[N+1][M+1][3];
        for(long[][] mat: dp) for(long[] row: mat) Arrays.fill(row, -1);
        return solve(0, 0, 0, N, M, K, H, A, B, dp);
    }

    /* https://share.gemini.google/j2NavPRoTO5E
  Mistakes:
* What changed (and why):
  1. long pickA = -INF: Replaced (int)-1e16 with -INF so integer casting doesn't overflow to -2147483648.
  2. if(next != -INF) check: Added this check before adding A.get(i).get(1) so invalid branches stay strictly -INF.

  3. .equals() for Integer comparison: Replaced == with .equals() for comparing flavor values (since List<Integer>
   stores object Integers, == can fail for integers outside the -128 to 127 cache range).

Your original logic, structure, variable names, and code style are otherwise 100% intact!*/

    private static final long INF = (long) 1e16;
    private static long solve(int i, int j, int prev, int N, int M, int K, int H,
                             List<List<Integer>> A,
                             List<List<Integer>> B, long[][][] dp){

        if((i+j) == K) return 0; // yeah, picked K spices
        if(i>=N && j>=M) return -INF; // base case out of spices before reaching K

        // memo step:
        if(dp[i][j][prev] != -1) return dp[i][j][prev];

        long pickA = -INF;
        long pickB = -INF;

        if(prev == 0){
            if(i<N) {
                long next = solve(i+1, j, 1, N, M, K, H, A, B, dp);
                if(next != -INF) pickA = A.get(i).get(1) + next;
            }
            if(j<M) {
                long next = solve(i, j+1, 2, N, M, K, H, A, B, dp);
                if(next != -INF) pickB = B.get(j).get(1) + next;
            }
        } else if(prev == 1){
            if(i<N){
                long next = solve(i+1, j, 1, N, M, K, H, A, B, dp);
                if(next != -INF){
                    if(A.get(i-1).get(0).equals(A.get(i).get(0))) pickA = H + A.get(i).get(1) + next;
                    else pickA = A.get(i).get(1) + next;
                }
            }
            if(j<M){
                long next = solve(i, j+1, 2, N, M, K, H, A, B, dp);
                if(next != -INF){
                    if(A.get(i-1).get(0).equals(B.get(j).get(0))) pickB = H + B.get(j).get(1) + next;
                    else pickB = B.get(j).get(1) + next;
                }
            }
        } else if(prev == 2){
            if(j<M){
                long next = solve(i, j+1, 2, N, M, K, H, A, B, dp);
                if(next != -INF) {
                    if(B.get(j-1).get(0).equals(B.get(j).get(0))) pickB = H + B.get(j).get(1) + next;
                    else pickB = B.get(j).get(1) + next;
                }
            }
            if(i<N){
                long next = solve(i+1, j, 1, N, M, K, H, A, B, dp);
                if(next != -INF) {
                    if(B.get(j-1).get(0).equals(A.get(i).get(0))) pickA = H + A.get(i).get(1) + next;
                    else pickA = A.get(i).get(1) + next;
                }
            }
        }
        return dp[i][j][prev] = Math.max(pickA, pickB);
    }
}
