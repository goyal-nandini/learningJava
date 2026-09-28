package extras_OA.infosys_OA_Prep;

/*Select K Non-Overlapping Intervals with Maximum Profit

You are given N intervals each with a start time, end time, and profit. Select a subset of exactly K intervals that are non-overlapping (no two selected intervals share any time point).

Maximize the total profit of the selected intervals.

Return the maximum profit achievable.

Example:
intervals = [(1,3,5), (2,4,3), (3,6,8), (5,7,4)], K=2
Select (1,3,5) and (3,6,8) → non-overlapping, profit = 13
Answer: 13

Approach: Sort by end time + DP.
dp[i][j] = max profit considering first i intervals, selecting exactly j of them.
Binary search for the latest non-overlapping interval at each step.

---
Similar Problems
🟢 Direct Match
Maximum Profit in Job Scheduling (LC 1235)
Weighted Job Scheduling (GFG)
Weighted Interval Scheduling
🟡 Same Pattern
Non-overlapping Intervals
Meeting Rooms II
Maximum Length Pair Chain
Russian Doll Envelopes
🔴 Advanced Variant
Maximum Earnings From Taxi
Maximum Number of Events II (LC 1751)
Attend Events III
Interval DP with Segment Tree

---
Pattern

⭐⭐⭐⭐ Weighted Interval Scheduling + DP

https://chatgpt.com/s/t_6a66fdf807bc81919ea085539beb8324*/

//public class intervals_profit {
//}
