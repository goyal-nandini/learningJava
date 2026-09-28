package extras_OA.Prob_inProgress_OAPrep;

/*
 Jump Game with Cost (DP)
You are given N platforms in a row, each with a cost value. Starting from platform 1, you need to reach the last platform.
Rules:

You can take a single jump (move 1 step forward) at any time
You can take a double jump (move 2 steps forward) at any time
You cannot take two consecutive double jumps

Find the minimum cost to reach the last platform.

Classic DP — state needs to track whether the previous jump was a double jump.

dp[i][0] = min cost at platform i, last jump was single
dp[i][1] = min cost at platform i, last jump was double

---
📚 Practice Problems
🟢 Direct Match
1. Frog Jump (AtCoder DP A) ✅
Best starting point.

2. Frog 2 (AtCoder DP B) ✅
Generalizes jump lengths.

3. Min Cost Climbing Stairs (LeetCode 746) ✅
Almost identical.

🟡 Same Pattern
4. House Robber ✅
Previous decision affects current.

5. Paint House https://www.geeksforgeeks.org/problems/distinct-coloring--170645/1 ✅
State DP.

6. Best Time to Buy and Sell Stock III ✅
State augmentation.

7. Maximum Subarray Sum with One Deletion ✅
Exactly same "one extra state" philosophy.

🔴 Advanced
8. Shortest Path with Obstacle Elimination ✅
edit: saath m ek aur krr lia... -> Minimum Obstacle Removal to Reach Corner
Graph version of state DP.

⭐ Most Important

Solve:

Frog Jump
Frog 2
Min Cost Climbing Stairs

These three will almost completely prepare you.

---
🎯 Pattern
DP + Previous State
or
DP with State Augmentation

https://chatgpt.com/s/t_6a66ec68b7748191a1f2a01c23ab1368
*/



//public class jumGameWithCost {
//}
