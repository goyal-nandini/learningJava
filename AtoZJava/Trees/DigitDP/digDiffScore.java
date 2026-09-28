package Trees.DigitDP;

/*Q4 — Count Numbers in Range by Digit Difference Score (Exact statement provided — Digit DP)

You are given two integers num1 and num2 (as strings, length 1–22) representing an inclusive range, and integers low
and high (1–400).

The score of a number = sum of absolute differences between every pair of consecutive digits.

Example: 123455
|2-1|+|3-2|+|4-3|+|5-4|+|5-5| = 1+1+1+1+0 = 4
Single digit numbers have score 0.

Count all numbers in [num1, num2] whose score lies in [low, high] inclusive.

Constraints: num1, num2 length ≤ 22, low/high ≤ 400

Example:
num1="1", num2="100", low=1, high=5

Numbers with score in [1,5]:
12: |2-1|=1 ✓
21: |2-1|=1 ✓
...count all valid numbers in range

Pattern: Classic Digit DP — count numbers in [num1, num2] = count(num2) - count(num1-1)

State: dp[pos][lastDigit][currentScore][tight][started]

pos: current digit position (0 to 21)
lastDigit: last digit placed (0-9)
currentScore: running sum of differences (0 to 400)
tight: whether current number is bounded by num2
started: whether we've placed a non-zero digit yet

At end (pos == length): count if low ≤ currentScore ≤ high

State space: 22 × 10 × 401 × 2 × 2 ≈ 352,880 states — very manageable.

Person confirmed 4D DP is the right approach. O(22 × 10 × 400 × 2) per query.

java
// State: dp[pos][lastDigit][score][tight]
// Memoize and recurse
int[][][][] memo = new int[23][10][401][2];
// At each position, try digits 0-9 (bounded by tight constraint)
// Add |digit - lastDigit| to score
// At end, check low ≤ score ≤ high*/

//public class digDiffScore {
//}
