package extras_OA.repeatedQue;

/*Min Cost Jump (No Consecutive Double Jumps)

You are given N platforms in a row, each with a cost. You start at platform 1 and must reach platform N.

At each step you can:

Take a single jump: move from platform i to i+1
Take a double jump: move from platform i to i+2
Constraint: You cannot take two consecutive double jumps

The cost of landing on a platform is added to your total. Find the minimum total cost to reach platform N.

Example:
cost = [1, 10, 3, 5, 2]
Path: 1→3→4→5 = 1+3+5+2 = 11
Answer: 11

DP state: dp[i][0] = min cost at i, last jump was single
dp[i][1] = min cost at i, last jump was double

---
🎯 Pattern
DP with Previous State

Recognition:

Minimum cost ✔️
Reach end ✔️
Previous jump affects next ✔️

Immediately:

DP(position, previous_state)
Anchor Problems

🥇 AtCoder DP A (Frog 1)
🥈 LC746 Min Cost Climbing Stairs
🥉 Frog 2

https://chatgpt.com/s/t_6a66fd09689c81918195f0202c9836d3
*/

//public class jumpCost {
//}
