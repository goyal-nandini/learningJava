package extras_OA.infosys_OA_Prep;

/*Count Sequences with Bounded Sum

Given integers N and T, count all sequences of length N using elements from {-1, 0, 1, 2} such that:

The final sum does not exceed T
At any position, if the current running sum % 3 == 0, you cannot pick 2 as the next element

Return the total count of valid sequences.

DP state: dp[i][curSum + offset][canTake2] — offset handles negative sums.

---
📚 Tier 1
1. Target Sum (LC494)
2. Count Subsets with Given Sum
3. Combination Sum IV
4. Dice Roll Simulation (LC1223) ⭐⭐⭐⭐⭐
Actually surprisingly close.
Why?
Because
what you choose next
depends on
previous history.

5. Number of Dice Rolls With Target Sum (LC1155)
Excellent practice.

---
🎯 Pattern

DP on Position + Running Sum

https://chatgpt.com/s/t_6a66f8c311cc819180c57bbcaa0aa798
*/

//public class sequence_boundedSum {
//}
