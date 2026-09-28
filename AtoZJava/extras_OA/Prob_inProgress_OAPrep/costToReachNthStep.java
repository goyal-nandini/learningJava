package extras_OA.Prob_inProgress_OAPrep;

/*
Perfect. I'll keep it **concise**, focus on the **pattern**, and make the **Practice Problems** section the main part.
---
# Q2 — Minimum Cost to Reach Nth Step (2D DP)
## 📝 Interview-Ready Statement
Given `N` steps and costs:

* `A` → cost of 1-step jump
* `B` → cost of 2-step jump
* `C` → cost of 3-step jump

Rule:
* After taking a **2-step** or **3-step** jump, the **next jump must be a 1-step**.
Find the **minimum cost** to reach exactly step `N`.
*/

import java.util.*;

/*
---

# 🧠 Pattern Recognition Checklist

✅ Minimize cost → DP
✅ Current decision depends on previous move
✅ Extra constraint ("next move depends on last move") → **State DP**

**Pattern:** DP with State (Finite State Machine)

---

# 💡 Intuition

Normal staircase DP won't work because the **validity of the next move depends on the previous jump**.

Need to remember whether we're **forced to take a 1-step**.

State:

* `dp[i][0]` → Free to choose any jump.
* `dp[i][1]` → Must take a 1-step next.

---

# 💻 Optimal Idea

Transitions:

* From **Free**:

  * Take 1-step → Free
  * Take 2-step → Forced
  * Take 3-step → Forced
* From **Forced**:

  * Only 1-step → Free

**Time:** `O(N)`
**Space:** `O(N)` → can optimize to `O(1)` if needed.

---

# ⚠️ Common Pitfalls

* Forgetting to enforce the forced 1-step.
* Invalid transitions from the forced state.
* Overshooting `N`.
* Incorrect DP initialization.

---

# 📚 Practice Problems ⭐⭐⭐⭐⭐

## 🟢 Direct Match (State DP)

1. LeetCode 552 — Student Attendance Record II✅
2. LeetCode 801 — Minimum Swaps To Make Sequences Increasing✅
3. LeetCode 983 — Minimum Cost For Tickets
4. AtCoder DP C — Vacation
5. GeeksforGeeks — Staircase with Constraints

---

## 🟡 Same Pattern (DP with Previous State)

1. LeetCode 309 — Best Time to Buy and Sell Stock with Cooldown
2. LeetCode 714 — Best Time to Buy and Sell Stock with Transaction Fee
3. LeetCode 198 — House Robber
4. LeetCode 213 — House Robber II
5. LeetCode 276 — Paint Fence✅

---

## 🔴 Advanced Variants

1. LeetCode 188 — Best Time to Buy and Sell Stock IV
2. LeetCode 1269 — Number of Ways to Stay in the Same Place
3. AtCoder DP O — Matching
4. Codeforces — DP with finite states (FSM DP problems)
5. CSES — Counting Towers

---

# 🎯 Interview Follow-ups

* What if after a 3-step jump, you must take **two** 1-step jumps?
* Different costs for every step instead of fixed `A, B, C`.
* Allow `K`-step jumps with similar constraints.
* Count the number of minimum-cost ways.

---

### 🏷️ Pattern Tag

**State DP / Finite State Machine DP / Staircase DP**

---

This is one of those problems where recognizing **"previous action affects future choices"** should immediately trigger **State DP**.

➡️ **Next:** Q3 — *Minimum Sum After One Swap (Greedy)*. This one is a good greedy + implementation problem with an interesting optimization angle.
*/
// 1-A, 2-B, 3-C
public class costToReachNthStep {
    static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int A = sc.nextInt();
        int B = sc.nextInt();
        int C = sc.nextInt();

        // use long beta ji... see the constraints and act on it :)
        int[][] dp = new int[n+1][4]; // -1, 1, 2, 3 as prev values
        for(int[] row: dp) Arrays.fill(row, -1);

        int ans = solve(0, -1, n, A, B, C, dp); // tip use 0 for prev not -1 if it can be used :)
    }
    private static int solve(int idx, int prev, int n, int A, int B, int C, int[][] dp){
        if(idx == n) return 0;
        if(idx > n) return Integer.MAX_VALUE;
        if(dp[idx][prev+1] != -1) return dp[idx][prev+1];

        int choiceA = Integer.MAX_VALUE;
        int choiceB = Integer.MAX_VALUE;
        int choiceC = Integer.MAX_VALUE;
        if(prev == 2 || prev == 3){
            int next = solve(idx+1, 1, n, A, B, C, dp);
            if(next!=Integer.MAX_VALUE) choiceA =  A+next;
        } else {
            int next1 = solve(idx+1, 1, n, A, B, C, dp);
            if(next1!=Integer.MAX_VALUE) choiceA =  A+next1;

            int next2 = solve(idx+2, 2, n, A, B, C, dp);
            if(next2!=Integer.MAX_VALUE) choiceB =  B+next2;

            int next3 = solve(idx+3, 3, n, A, B, C, dp);
            if(next3!=Integer.MAX_VALUE) choiceC =  C+next3;
        }

        return dp[idx][prev+1] = Math.min(choiceA, Math.min(choiceB, choiceC));
    }
}
