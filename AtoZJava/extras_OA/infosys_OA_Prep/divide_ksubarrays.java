package extras_OA.infosys_OA_Prep;

/*Divide Array into K Subarrays, Minimize Max Unique Characters

You are given an array of characters and an integer K. Divide the array into exactly K contiguous subarrays.

The score of a subarray is the number of unique characters in it.

Minimize the maximum score among all K subarrays.

Return this minimized maximum score.

Example:
arr = [a,b,a,c,b,d], K = 3
One split: [a,b,a] score=2, [c,b] score=2, [d] score=1 → max=2
Answer: 2

Approach: Binary search on the answer (max unique chars allowed). For a given limit mid, greedily check if array
can be split into ≤ K parts each with unique chars ≤ mid.

---
Similar Problems
🟢 Direct Match
Split Array Largest Sum (LC 410)
Allocate Minimum Number of Pages
Painter's Partition Problem
🟡 Same Pattern
Capacity To Ship Packages Within D Days
Koko Eating Bananas
Magnetic Force Between Two Balls
Aggressive Cows
🔴 Advanced Variant
Minimize Maximum Distance to Gas Station
Divide Chocolate
Minimum Limit of Balls in a Bag
Parallel Courses Scheduling

---
Pattern

⭐⭐⭐⭐ Binary Search on Answer + Greedy Validation

https://chatgpt.com/s/t_6a66fdf807bc81919ea085539beb8324*/

//public class divide_ksubarrays {
//}
