package extras_OA.infosys_OA_Prep;

/*Count Valid Strings over {0,1,2}

Count all strings of length N over characters {0, 1, 2} satisfying:

"00" must not appear (no two consecutive 0s)
"111" must not appear (no three consecutive 1s)
Every '2' must be surrounded by '1' on both sides (i.e. pattern must be "1 2 1")

Return the count of valid strings of length N.

DP state: dp[i][prev][prevprev] — position, previous char, char before that.

---
📚 Tier 1
1. AtCoder DP T (or similar state-string DP)

2. Count Binary Strings Without Consecutive Ones
The simplest version.

3. LeetCode 552 – Student Attendance Record II ⭐⭐⭐⭐⭐
This is probably the closest interview problem.
State depends on:
previous absences
consecutive L's

Exactly the same philosophy.

4. Domino and Tromino Tiling (LC790)
Another state-transition DP.

---
🎯 Pattern

DP on Strings / Automaton DP

https://chatgpt.com/s/t_6a66f8c311cc819180c57bbcaa0aa798
*/

//public class cntValidStrings {
//}
