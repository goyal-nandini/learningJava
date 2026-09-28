package extras_OA.infosys_OA_Prep;

/*Shift Sort (Rotate & Negate)

You are given an array of integers. In one operation, take the last element, multiply it by -1, and place it at the first position (shift all others right).

Find the minimum number of such operations to make the array sorted in ascending order. Return the count of elements shifted.

Example:
arr = [3, 1, 2]
Op1: take 2, negate → -2, place first → [-2, 3, 1]
Op2: take 1, negate → -1, place first → [-1, -2, 3]
...keep going until sorted

---
5. Shift Sort (Rotate & Negate)

This is the most interesting one.

I haven't seen this exact problem before, which makes it a good OA question.

Likely Pattern

This mixes:

Simulation
Greedy
Observation
Circular Array

The main challenge is finding an invariant rather than brute-forcing operations.

🟢 Direct Match

There probably isn't a standard LeetCode equivalent.

Instead, practice:

Rotate Array (LC 189)
Circular Array Loop
Check if Array is Sorted and Rotated
Array Rotation Problems
🟟 Same Pattern
Minimum Operations to Sort Array
Pancake Sorting
Minimum Domino Rotations
Reveal Cards in Increasing Order
🔴 Advanced Variant
Circular Buffer Simulation
Deque-based Transformations
Permutation Transformation Problems
Codeforces constructive algorithms

Concepts

Simulation
State transitions
Mathematical invariants
Circular arrays*/

//public class shiftSort {
//}
