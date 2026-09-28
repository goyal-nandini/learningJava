package Trees.DigitDP;

/*Q3 — Rotated Reverse Numbers (Digit DP)

Count numbers in range [1, N] where:

Number contains only digits from {1,2,5,6,8,9} (no 3,4,7)
Apply rotation mapping: 1↔1, 2↔5, 5↔2, 6↔9, 8↔8, 9↔6
Reverse the number, then apply mapping to get r(x)
Valid if: r(x) ≠ x AND r(x) % digitSum(x) == 0

Return count of valid numbers in [1, N].

Example:
x=2: reversed=2, mapped=5 → r(2)=5
  r(2)≠2 ✓, digitSum(2)=2, 5%2=1≠0 ✗ → invalid

x=9: reversed=9, mapped=6 → r(9)=6
  r(9)≠9 ✓, digitSum(9)=9, 6%9≠0 ✗ → invalid

x=12: reversed=21, mapped: 2→5,1→1 → r(12)=51
  r(12)≠12 ✓, digitSum(12)=3, 51%3=0 ✓ → valid!

x=18: reversed=81, mapped: 8→8,1→1 → r(18)=81
  r(18)≠18 ✓, digitSum(18)=9, 81%9=0 ✓ → valid!

Pattern: For small N, brute force works. For large N, Digit DP:

dp[pos][digitSum][tight][isRotSame]
Track digit sum mod LCM of possible digit sums (1-54 for up to 8-digit numbers → LCM is large, so track sum directly)
At end check: r(x) ≠ x and r(x) % digitSum == 0

The r(x) % digitSum == 0 constraint makes pure digit DP hard since r(x) depends on full number.
For large N this likely needs digit DP with sum tracking + careful construction. O(digits × maxSum × 2 × 2).*/

//public class rotatedReverseNumber {
//}
