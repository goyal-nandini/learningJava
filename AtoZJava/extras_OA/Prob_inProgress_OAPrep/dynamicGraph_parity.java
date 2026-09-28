package extras_OA.Prob_inProgress_OAPrep;

/*Dynamic Graph: Shortest Path with Parity Constraint

You are given N nodes with no edges initially. Edges are added one by one over time (each edge has a timestamp).

For Q queries, each query gives (u, v, p):

Find the minimum time at which a path from u to v exists
Such that the number of edges on the path % 2 == p (parity constraint)
Any node can be visited any number of times

Return the minimum timestamp for each query.

Hint: This is a DSU / binary lifting on time + parity-aware BFS problem. Think of each node as two nodes
(node, parity) — classic parity graph trick.
*/

/*If chatgpt were mentoring you, I'd give this order

✅ Week 1

LC 785 ✅
LC 886 ✅
LC 1697 ✅
 */

// from lc 1697 i get to know lc 1102 and 1631...
// https://algo.monster/liteproblems/1102 <- todo
/*similar to lc 1631
Similar Questions
3341. Find Minimum Time to Reach Last Room I
1631. Path With Minimum Effort
3286. Find a Safe Walk Through a Grid
2290. Minimum Obstacle Removal to Reach Corner
1293. Shortest Path in a Grid with Obstacles Elimination
864. Shortest Path to Get All Keys*/

 /*

✅ Week 2

SPOJ BUGLIFE https://www.spoj.com/problems/BUGLIFE/
UVa 10158 (War) https://one-problem-a-day.blogspot.com/2011/07/uva-10158-war.html
POJ 1182 (Food Chain) http://poj.org/problem?id=1182


then your OA question.*/

/*📚 Tier 1

These are NOT LeetCode-style problems.

Instead:

1. Dynamic Connectivity (CP-Algorithms)
2. Offline Queries using DSU
3. Parallel Binary Search (CP-Algorithms)
4. Bipartite Graph Checking with DSU

Very important.

5. BFS on Parity Graph
Common Codeforces idea.

---
🎯 Pattern

Offline Dynamic Connectivity

Binary Search on Answer

Parity Graph

https://chatgpt.com/s/t_6a66f8c311cc819180c57bbcaa0aa798
*/

//public class dynamicGraph_parity {
//}
