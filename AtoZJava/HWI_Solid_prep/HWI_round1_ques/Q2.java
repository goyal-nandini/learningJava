package HWI_Solid_prep.HWI_round1_ques;

import java.util.Arrays;
import java.util.Scanner;

/*
## Problem Statement

You are given an array **A** of **N** integers and an integer **K**.
You start at index **0** and must reach index **N-1**. From any index **i**, you can jump to any index **j** such that:
> **i < j <= i + K**
The **cost** of performing a jump from index **i** to index **j** is defined as the **product** of their values:
**A[i] * A[j]**.
Find the **minimum total cost** to reach the last index.
---

### Input Format
- First line: integer **N** — size of the array
- Second line: integer **K** — the constant K
- Next **N** lines: each line **i** (where 0 ≤ i < N) contains integer **A[i]**

---

### Constraints
- 1 <= N <= 10^5
- 1 <= K <= 10^2
- -10^5 <= A[i] <= 10^5

## Example Test Cases

---

### Example 1 — Basic
```
Input:
4
2
1
3
2
4

Output:
10
```
**Explanation:**
- Jump 0→1: cost = A[0]*A[1] = 1*3 = 3
- Jump 1→3: cost = A[1]*A[3] = 3*4 = 12 ❌ (total 15)
- Jump 0→2: cost = 1*2 = 2, then 2→3: cost = 2*4 = 8 → total **10** ✓
- Jump 0→1→3: 3 + 12 = 15
- **Optimal: 0→2→3 = 10** *(K=2 so from 0 can go to 1 or 2)*

---

### Example 2 — Negative values (the tricky case)
```
Input:
4
2
-2
3
-1
4

Output:
-13
```
**Explanation:**
- 0→2: (-2)*(-1) = 2, then 2→3: (-1)*4 = -4 → total **-2**
- 0→1: (-2)*3 = -6, then 1→3: 3*4 = 12 → total **6**
- 0→2→3: 2 + (-4) = **-2**
- 0→1→2→3: -6 + (-3) + (-4) = **-13** ✓ *(check if K allows each hop)*

---

### Example 3 — K = 1 (forced path)
```
Input:
3
1
2
3
4

Output:
20
```
**Explanation:**
Only path: 0→1→2
- 2*3 + 3*4 = 6 + 12 = **18**
*/
public class Q2 {
    public static void main(String[] args) {
        // dp ka sawaal hai 1d dp :)
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] arr = new int[n];
        for(int i=0; i<n; i++){
            arr[i] = sc.nextInt();
        }

        // memoization
        long[] dp = new long[n];
        Arrays.fill(dp, -1);
        long ans1 = solve(n-1, k, arr, dp);

        // tabulation time
        long ans2 = solve(k, arr);
        System.out.println(ans2);
    }

    static long solve_SO_NOTPOSSIBLE(int k, int[] arr){
        int n = arr.length;
        long prev = 0L;

        for(int i=1; i<n; i++){
            long curr = 0L;
            Long minCost = Long.MAX_VALUE;
            for(int j=i-1; j>=i-k; j--){
                long cost = (long)arr[i]*arr[j] + prev;
                minCost = Math.min(cost, minCost);
            }
            curr = minCost;
            prev = curr;
        }
        return prev;
    }
/*🔥 Hard truth
Space optimization only works when dependencies are fixed and small
Here: Dependency size = K (variable) So → no O(1) space possible
We can't optimise space because dp[i] depends on up to k previous states, so we must store them.”*/

    // backward dp k lie i-1 already solved hona chahiye, jaise i+1 wali dp me n-1 to 0 tkk jatte hai, aur ism i-1 wali
    // me 0 to n-1
    static long solve(int k, int[] arr){
        int n = arr.length;
        long[] dp = new long[n];

        // dp[i] represents min cost to jump till index i from index 0, so dp[0] means no jump - no cost,
        dp[0] = 0; // must condition as if we run from 0 to n-1 then inner loop crashes!!
        for(int i=1; i<n; i++){

            // ye andar ka too #copy from recursion hai#
            long minCost = Long.MAX_VALUE;
            for(int j=i-1; j>=i-k; j--){
                if(j<0) break;

                long cost = (long)arr[i]*arr[j] + dp[j];
                minCost = Math.min(cost, minCost);
            }
            dp[i] = minCost;

        }
        return dp[n-1];

    }
    static long solve(int i, int k, int[] arr, long[] dp){
        // backward dp
        if(i == 0){
            return 0;
        }

        if(dp[i] != -1) return dp[i];

        long min_cost = Long.MAX_VALUE;
        for(int j = i-1; j>= i-k; j--){ // backward loop
            // caution!!
            if(j<0) break; // as if one time j gets < 0 then doing j-- will anyways gets neg too so break is a good choice!!
            long cost = (long)arr[j] * arr[i] + solve(j, k, arr, dp); // aur betaa ji kitni brr kaha hai
            // long ya mod lga dia kroo!! WAIT WAIT!!**
            min_cost = Math.min(cost, min_cost);
        }

        return dp[i] = min_cost;
    }
/*
** When MOD is allowed
Use MOD only when:
Problem says: “return answer modulo 1e9+7” ✔️
OR counting ways (like combinations, paths) ✔️
*
* 🧠 What YOU should do instead
If overflow is your concern:
👉 Use long
long cost = (long) arr[j] * arr[i] + solve(j, k, arr, dp);
*
⚠️ Blunt truth
Using MOD here means:
You don’t trust your understanding and are applying a random trick.
👉 That will get you rejected in interviews.*/
}
