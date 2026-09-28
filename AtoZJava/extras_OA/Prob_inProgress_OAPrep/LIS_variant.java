package extras_OA.Prob_inProgress_OAPrep;

// came to know some code from the person who got to HWI round 2 - list with some reset option
// probable question:
// Given an array of integers, find the maximum number of elements you can select such that the
// selected elements can be split into at most 2 non-decreasing subsequences (maintaining relative order).
// Alternatively: you may skip a prefix once and restart your subsequence count.

// que: split into k subsequences such that this this...
// (condition on it will be given) like each should in sorted order or can be taken in forward manner only...

// well this que is quite imp to study and practice:
// i can get many que on it to practice: and gives hands on to ratto these que

/*
---
Longest Increasing Subsequence (LIS) ✅
Russian Doll Envelopes ✅
Number of Longest Increasing Subsequences ✅
Patience Sorting - its actually BS for LIS ✅

⁉️⁉️⁉️🙋‍♀️
Partition Array Into Increasing Subsequences - https://algo.monster/liteproblems/1121#editor
Make Array Non-decreasing - https://leetcode.com/problems/make-array-non-decreasing/description/
Increasing Triplet Subsequence - https://leetcode.com/problems/increasing-triplet-subsequence/
Minimum Number of Increasing Subsequences - https://www.geeksforgeeks.org/dsa/minimum-number-of-increasing-subsequences/
https://leetcode.com/problems/minimum-swaps-to-make-sequences-increasing/description/ - i added it seeing inc sequences...

---
and one lc 659: split array into cons subsequences or ✅
https://www.geeksforgeeks.org/problems/split-array-subsequences/1 ✅

lc 1269: Divide Array in Sets of K Consecutive Numbers or ✅
lc 846 Hand of Straights ✅ same as above
https://www.geeksforgeeks.org/dsa/check-if-an-array-can-be-split-into-subsets-of-k-consecutive-elements/ ✅ same as above

---
dp with additional state: index, prev, flag
Problems similar to this

Once you solve this, I'd recommend these because they strengthen the same mental model:

Maximum Subarray Sum with One Deletion (LeetCode 1186)
Longest Increasing Subsequence (LeetCode 300)
Best Time to Buy and Sell Stock III (limited transactions → extra state)
Shortest Path in a Grid with Obstacles Elimination (LeetCode 1293)
Longest Ideal Subsequence (state-based DP)
Delete and Earn (state transition DP)

Notice how they all revolve around augmenting a familiar DP with one additional piece of state.

---
"LIS with at most one reset"
"Longest non-decreasing subsequence with one skip/restart"
"Split array into 2 non-decreasing subsequences, maximize total length"

---
https://www.hackerearth.com/practice/data-structures/advanced-data-structures/segment-trees/practice-problems/algorithm/modified-lis-1/

---
Pattern Card 📝
Whenever you see:
"at most one..."
or
"one chance..."
or
"one modification..."
or
"one deletion..."
or
"one restart..."
Immediately think:
DP + an extra state representing whether the special operation has been used.*/

// https://chatgpt.com/s/t_6a66e14de75481919704c54596ba7558

public class LIS_variant {
    static void main(String[] args) {
        // nothing else
    }
}
