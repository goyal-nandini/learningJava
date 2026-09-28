package extras_OA.infosys_OA_Prep;

/*Train Platform / Meeting Rooms

You are given N trains, each with an arrival time and a departure time. Find the maximum number of trains
present at the station simultaneously (i.e. maximum overlaps at any point in time).

This is the classic meeting rooms II problem. Greedy with sorting + min-heap, or difference array.

---
There are 3 common solutions
1. Sorting + Two Pointers ⭐⭐⭐⭐⭐ (Most common in OA)
Sort arrivals.
Sort departures.
Walk through both arrays.

2. Min Heap ⭐⭐⭐⭐
Sort intervals by start time.
Maintain ending times.
3. Difference Array / Line Sweep ⭐⭐⭐

Useful when time values are small.

---
📚 Practice Problems
🟢 Direct Match
Minimum Number of Platforms (GeeksforGeeks) ⭐⭐⭐⭐⭐
This is literally the same problem.
LeetCode 253 – Meeting Rooms II ⭐⭐⭐⭐⭐
Same problem with meeting rooms.
LintCode – Meeting Rooms II
Same concept.

🟡 Same Pattern
LeetCode 56 – Merge Intervals
LeetCode 57 – Insert Interval
LeetCode 435 – Non-overlapping Intervals
LeetCode 452 – Minimum Number of Arrows to Burst Balloons

🔴 Advanced
My Calendar III (LeetCode 732)

Excellent interval overlap problem.

⭐ Must Solve
GFG Minimum Platforms
LC253 Meeting Rooms II

These alone cover most OAs.

---
🎯 Pattern
Interval Overlap / Sweep Line
Alternative: Sorting + Two Pointers / Min Heap

https://chatgpt.com/s/t_6a66ec68b7748191a1f2a01c23ab1368
*/

//public class train_platforms {
//}
